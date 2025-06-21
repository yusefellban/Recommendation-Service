package com.MAHD.Recommendation.Service.controller;

import com.MAHD.Recommendation.Service.model.top5models.Course;
import com.MAHD.Recommendation.Service.services.RecommendationServiceTop5;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendation/")
@Tag(name = "Recommendation Service", description = "This Spring Boot application provides a course recommendation API. It integrates with external services to: " +
        "Fetch a full list of courses." +
        "Fetch enrolled courses for a user using a token." +
        "Return the Top 5 recommended courses based on either rating or user tags.")
public class RecommendationController {

    private final RecommendationServiceTop5 recommendationService;

    public RecommendationController(RecommendationServiceTop5 recommendationService) {
        this.recommendationService = recommendationService;
    }

    @Operation(summary = "Top 5 courses globally",description = "Returns the top 5 courses globally, based on highest average rating.")
    @GetMapping("top5")
    public List<Course> getTop5Recommendations() {
        return recommendationService.getTop5Recommendations();
    }

    @Operation(summary = "Top 5 personalized recommendations for current user",description = "\tReturns courses matched to the current user’s tags (based on their token).")
    @GetMapping("user-top5")
    public List<Course> getUserTop5Recommendations(@RequestHeader("Authorization") String token) {
        return recommendationService.searchRecommendations(token);
    }




}