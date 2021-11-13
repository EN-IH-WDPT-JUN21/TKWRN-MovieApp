package com.ironhack.gatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayCofiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/api/authorities/**")
                        .uri("lb://GATEWAY-SERVICE"))
                .route(p -> p.path("/api/authorities**")
                        .uri("lb://GATEWAY-SERVICE"))
                // Movie Service
                .route(p -> p.path("/api/movies/**")
                        .uri("lb://MOVIE-SERVICE"))
                .route(p -> p.path("/api/movies**")
                        .uri("lb://MOVIE-SERVICE"))

                // Playlist Service
                .route(p -> p.path("/api/playlists/**")
                        .uri("lb://PLAYLIST-SERVICE"))
                .route(p -> p.path("/api/playlists**")
                        .uri("lb://PLAYLIST-SERVICE"))

                // User Service
                .route(p -> p.path("/api/users/**")
                        .uri("lb://USER-SERVICE"))
                .route(p -> p.path("/api/users**")
                        .uri("lb://USER-SERVICE"))

                // Search Service
                .route(p -> p.path("/api/search/**")
                        .uri("lb://SEARCH-SERVICE"))
                .route(p -> p.path("/api/search**")
                        .uri("lb://SEARCH-SERVICE"))

                .build();
    }
}
