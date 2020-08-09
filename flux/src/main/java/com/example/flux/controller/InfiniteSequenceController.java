package com.example.flux.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class InfiniteSequenceController {

    @GetMapping(value = "/sequence",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux generateSequence(){
        Flux<Long> integerFlux = Flux.interval(Duration.ofSeconds(1));
        return integerFlux;
    }

}
