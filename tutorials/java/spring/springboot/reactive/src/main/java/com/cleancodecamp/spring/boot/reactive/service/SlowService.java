package com.cleancodecamp.spring.boot.reactive.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;

@Service
public class SlowService {

    Logger logger = LoggerFactory.getLogger(SlowService.class);

    public Flux<String> getAccounts() {
        return Flux.fromIterable(Arrays.asList("slow_1", "slow_2", "slow_3"))
                .delayElements(Duration.ofSeconds(3))
                .doOnNext(x -> logger.info(x));
    }
}
