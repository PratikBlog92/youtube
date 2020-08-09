package com.example.flux.startup.service;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@Log
public class FluxMap implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
//        Flux<String> just = Flux.just("My", "Name", "Pratik", "and", "love", "programming")
//                .filter(x -> x.length() > 3)
//                .map(x -> x.toUpperCase())
//                .log();
//        just.subscribe();

    }
}
