package com.cleancodecamp.spring.boot.reactive.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;

@Service
public class SlowService {
    public Flux<String> getAccounts() {
        return Flux.fromIterable(Arrays.asList("slow_1", "slow_2", "slow_3"))
                .delayElements(Duration.ofSeconds(3));
    }
}
