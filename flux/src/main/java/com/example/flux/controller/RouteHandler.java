package com.example.flux.controller;

import com.example.flux.entity.Order;
import com.example.flux.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class RouteHandler {
    @Autowired private OrderRepository orderRepository;

    public Mono<ServerResponse> getresponse(ServerRequest request)
    {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderRepository.findAll(), Order.class);
    }

}
