package com.example.flux.router;

import com.example.flux.entity.Order;
import com.example.flux.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Service
public class OrderHandelar {

    @Autowired private OrderRepository orderRepository;

    public Mono<ServerResponse> findAllOrders(ServerRequest request)
    {
        return  ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderRepository.findAll(), Order.class);
    }

    public Mono<ServerResponse> saveOrders(ServerRequest request)
    {
        Mono<Order> orderMono = request.bodyToMono(Order.class);
       return orderMono.flatMap(order -> ServerResponse
               .ok()
               .contentType(MediaType.APPLICATION_JSON)
               .body(orderRepository.save(order),Order.class));
    }

    public Mono<ServerResponse> findOrderBYId(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<Order> orderbyId = orderRepository.findById(id);

        return orderbyId.flatMap(order ->
                    ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(orderbyId,Order.class)
                ).switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> deleteOrderBYId(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<Order> orderbyId = orderRepository.findById(id);

        return orderbyId.flatMap(order ->
                ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(orderRepository.delete(order),Void.class)
        ).switchIfEmpty(ServerResponse.notFound().build());
    }


    public Mono<ServerResponse> updateOrderBYId(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<Order> orderMono = request.bodyToMono(Order.class)
        .flatMap(order ->{
            Mono<Order> dbOrderMono = orderRepository.findById(id);
            dbOrderMono.flatMap(dbOrder ->{
                dbOrder.setUser(order.getUser());
                dbOrder.setIsDelivered(order.getIsDelivered());
                dbOrder.setAddress(order.getAddress());
                dbOrder.setProducts(order.getProducts());
                return orderRepository.save(dbOrder);
            });
            return dbOrderMono;
        });

        return  ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderMono,Order.class)
                .switchIfEmpty(ServerResponse.notFound().build());

    }

}
