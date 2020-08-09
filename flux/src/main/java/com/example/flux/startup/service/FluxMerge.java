package com.example.flux.startup.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Component
public class FluxMerge implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

//        Flux<Integer> flux1 = Flux.just(1, 2, 3, 4, 5).delayElements(Duration.ofSeconds(1));
//        Flux<Integer> flux2 = Flux.just(6,7,8,9,10).delayElements(Duration.ofSeconds(1));
//
//        Flux<Integer> result = Flux.zip(flux1,flux2,(a,b) ->{
//            return  a+b;
//        });
//        result .log().subscribe();

    }
}
