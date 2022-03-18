package com.manager.salsa.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    private static final String login_path = "/api/auth/login";

    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder locatorBuilder){
        return locatorBuilder.routes()
                .route((predicateSpec) -> predicateSpec.path("/get")
                        .filters(f -> f.addRequestHeader("hello","world")).uri("http://httpbin.org:80"))

               .route(predicateSpec -> predicateSpec.path(login_path)
                       .filters(route -> route.addResponseHeader("header_gateway","i came from gateway"))
                        .uri("lb://login"))
                .build();
    }
}