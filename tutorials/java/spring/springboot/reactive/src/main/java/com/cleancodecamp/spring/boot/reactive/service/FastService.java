package com.cleancodecamp.spring.boot.reactive.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@Service
public class FastService {
    public Flux<String> getAccounts() {
        return Flux.fromIterable(Arrays.asList("fast_1", "fast_2", "fast_3"));
//        return Flux.fromIterable(accounts);
    }
}
