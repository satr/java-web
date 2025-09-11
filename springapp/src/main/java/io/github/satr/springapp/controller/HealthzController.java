package io.github.satr.springapp.controller;

import io.github.satr.springapp.model.Order;
import io.github.satr.springapp.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthzController {
    @GetMapping("/healthz")
    public String heathz() {
        return "OK";
    }
}
