package com.example.flux.startup.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.stream.Stream;

@Component
public class FluxFlatMap implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

//        Flux.just(1,2,3,4,5,6,7,8,9,10)
//                .window(2)
//                .flatMapSequential(x -> {
////            return Flux.fromStream(generateStream(x));
//                    return x.map(this::generateStream).subscribeOn(Schedulers.parallel())
//                            .flatMap(q -> Flux.fromStream(q));
//        }).log().subscribe();

    }
    public Stream generateStream(int value)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Stream.of(value * value);
    }
}
