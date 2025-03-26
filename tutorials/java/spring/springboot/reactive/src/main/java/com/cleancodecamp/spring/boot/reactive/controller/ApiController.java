package com.cleancodecamp.spring.boot.reactive.controller;

import com.cleancodecamp.spring.boot.reactive.service.FastService;
import com.cleancodecamp.spring.boot.reactive.service.SlowService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final FastService fastService;
    private final SlowService slowService;

    public ApiController(FastService fastService, SlowService slowService) {
        this.fastService = fastService;
        this.slowService = slowService;
    }

    @GetMapping(value = "/accounts", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getAccounts2() {
        Flux<String> fastAccounts = fastService.getAccounts();
        Flux<String> slowAccounts = slowService.getAccounts();
        return Flux.merge(fastAccounts, slowAccounts);
    }

}
