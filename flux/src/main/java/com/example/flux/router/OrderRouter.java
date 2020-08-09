package com.example.flux.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class OrderRouter {

    //localhost:8080/route/order/findAllOrders
    //localhost:8080/route/order/delete/5f03157de820c46fb57164ab
    //localhost:8080/route/order/find/5f03157de820c46fb57164ab
    //localhost:8080/route/order/place
    @Bean
    public RouterFunction<ServerResponse> sayHeloWord(OrderHandelar orderHandelar){
        return RouterFunctions
                .route(
                RequestPredicates.GET("/hi"),
                serverRequest -> ServerResponse.ok().body(BodyInserters.fromValue("HelloWord"))
                )
                .andRoute(
                        RequestPredicates.GET("/route/order/findAllOrders").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        orderHandelar::findAllOrders
                )
                .andRoute(
                        RequestPredicates.POST("/route/order/place").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        orderHandelar::saveOrders
                )
                .andRoute(
                RequestPredicates.GET("/route/order/find/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                orderHandelar::findOrderBYId
                 )
                .andRoute(
                        RequestPredicates.GET("/route/order/update/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        orderHandelar::updateOrderBYId
                )
                .andRoute(
                        RequestPredicates.GET("/route/order/delete/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        orderHandelar::deleteOrderBYId
                );
    }

}
