package com.manager.salsa.gateway.filter;

import org.slf4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class LoggingFilter implements GlobalFilter {

    private static final Logger LOGGER = getLogger(LoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        LOGGER.info("Original request path -> {}", exchange.getRequest().getPath());

//        HttpHeaders headers = exchange.getResponse().getHeaders();
//        String token1 = exchange.getResponse().getHeaders().getFirst("token");
//        List<String> token = headers.get("token");
//        LOGGER.info("token recuperado -> {}",token1);

        return chain.filter(exchange);
    }
}
