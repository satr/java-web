package io.github.satr.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthzController {
    @GetMapping("/healthz")
    public String heathz() {
        return "OK";
    }
}
