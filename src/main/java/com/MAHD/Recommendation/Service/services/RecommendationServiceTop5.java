package com.MAHD.Recommendation.Service.services;

import com.MAHD.Recommendation.Service.model.top5models.Course;
import com.MAHD.Recommendation.Service.model.top5models.ExternalApiResponse;
import com.MAHD.Recommendation.Service.model.userTop5models.UserResponse;
import com.MAHD.Recommendation.Service.model.userTop5models.courses;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceTop5 {

    private final WebClient recommendationWebClient;
    private final WebClient userWebClient;

    public RecommendationServiceTop5(WebClient recommendationWebClient, WebClient userWebClient) {
        this.recommendationWebClient = recommendationWebClient;
        this.userWebClient = userWebClient;
    }

    public List<Course> getTop5Recommendations() {
        ExternalApiResponse response = recommendationWebClient.get()
                .uri("")
                .retrieve()
                .bodyToMono(ExternalApiResponse.class)
                .block();


        if (response != null && response.isSuccess()) {
            return response.getData().stream()
                    .sorted(Comparator.comparingDouble(course -> -course.getRating().getAverage()))
                    .limit(5)
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("Failed to fetch data from external API");
        }
    }


    public UserResponse getUserRecommendations(String token) {
        return userWebClient.get()
                .uri("")
                .header("Authorization", "Bearer " + token)
                .retrieve().bodyToMono(UserResponse.class).block();
    }


    public List<Course> searchRecommendations(String token) {
        ExternalApiResponse response = recommendationWebClient.get()
                .uri("")
                .retrieve()
                .bodyToMono(ExternalApiResponse.class)
                .block();

        UserResponse userResponse = getUserRecommendations(token);

        if (response == null || !response.isSuccess() || userResponse == null || !userResponse.isSuccess()) {
            throw new RuntimeException("Failed to fetch data");
        }

        List<Course> allCourses = response.getData();
        List<courses> userCourses = userResponse.getData().getCourses();

        List<String> userTags = userCourses.stream()
                .flatMap(course -> course.getTags().stream())
                .distinct()
                .toList();

        return allCourses.stream()
                .filter(course -> course.getTags().stream().anyMatch(userTags::contains))
                .collect(Collectors.toList());
    }


}
