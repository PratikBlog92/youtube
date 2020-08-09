package com.example.flux.startup.service;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Component
@Log
public class FluxFactoryUtility implements CommandLineRunner {

//    List<Integer> nuberList = Arrays.asList(2,8,8,9,6,7);



    @Override
    public void run(String... args) throws Exception {

//        log.info("********** From Iterable *************");
//        Flux<Integer> integerFlux = Flux.fromIterable(nuberList);
//        integerFlux.log().subscribe();
//
//        log.info("********** From array *************");
//        String[] array = {"code","With","Pratik"};
//        Flux<String> stringFlux = Flux.fromArray(array);
//        stringFlux.log().subscribe();
//
//        log.info("********** From Stream *************");
//        Stream<Integer> stream = nuberList.stream();
//        Flux<Integer> integerFlux1 = Flux.fromStream(stream);
//        integerFlux1.log().subscribe();
//
//        log.info("********** From range *************");
//        Flux<Integer> range = Flux.range(10, 7);
//
//        range.log().subscribe();

    }
}
