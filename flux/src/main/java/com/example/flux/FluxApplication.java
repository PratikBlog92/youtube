package com.example.flux;

import com.example.flux.entity.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class FluxApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FluxApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		Flux<String> fluxString = Flux.just("Code","With","Pratik")
//				.concatWith(Flux.error(new RuntimeException("Hello there...! its exception")))
//				.concatWith(Flux.just("Hello Pratik"));
//
//		fluxString.log().subscribe(System.out::println,(e)->System.out.println(e.getMessage()));

//		Mono<String> stringMono=  Mono.error(new RuntimeException("This is exception.."));
//
//		stringMono.log().subscribe(System.out::println,(e)->System.out.println(e.getClass()));

	}
}