package com.MAHD.Recommendation.Service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {


    @Bean
    public WebClient recommendationWebClient(WebClient.Builder builder,
                                             @Value("${external.api.url}") String recommendationUrl) {
        return builder.baseUrl(recommendationUrl).build();
    }

    @Bean
    public WebClient userWebClient(WebClient.Builder builder,
                                   @Value("${external.api.user-url}") String recommendationUserUrl) {
        return builder.baseUrl(recommendationUserUrl)
                .build();
    }
}