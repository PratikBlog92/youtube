package com.example.flux.controller;

import com.example.flux.entity.Order;
import com.example.flux.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired private OrderRepository orderRepository;
    //localhost:8080/order/place
    //localhost:8080/order/upate
    //localhost:8080/order/delete/{ID}
    //localhost:8080/order/findAllOrders
    //localhost:8080/order/find/{ID}

    @PostMapping("/place")
    public Mono<Order> save(@RequestBody Order order)
    {
        return orderRepository.save(order);
    }

    @GetMapping("/findAllOrders")
    public Flux<Order> findAllOrder()
    {
        return orderRepository.findAll();
    }

    @GetMapping("/find/{ID}")
    public Mono<ResponseEntity<Order>> findById(@PathVariable(value ="ID" ) String id)
    {
       return orderRepository.findById(id)
                .map(x -> ResponseEntity.ok(x))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/upate")
    public Mono<ResponseEntity<Order>> updateOrder(@RequestBody Order order)
    {
      return  orderRepository.findById(order.getId())
                .flatMap(x ->{
                    x.setProducts(order.getProducts());
                    x.setAddress(order.getAddress());
                    x.setId(order.getId());
                    x.setIsDelivered(order.getIsDelivered());
                    x.setUser(order.getUser());
                    return orderRepository.save(x);
                    })
                .map(x -> ResponseEntity.ok(x))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/delete/{ID}")
    public Mono<ResponseEntity<Void>> deleteById(@PathVariable(value ="ID" ) String id)
    {
        return  orderRepository.findById(id)
                .flatMap(x -> {
                    Mono<Void> delete = orderRepository.delete(x);
                    return  delete;
                })
                .map(x-> ResponseEntity.ok(x))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/findAll",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Order> findAllOrderStream()
    {
        return orderRepository.findAll();
    }
}
