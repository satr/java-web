package io.github.satr.springapp.controller;

import io.github.satr.springapp.model.Order;
import io.github.satr.springapp.service.OrderService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final OrderService orderService;

    public HomeController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Order> orders = this.orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "home";
    }

    @GetMapping("/me")
    public String me(@AuthenticationPrincipal OidcUser user, Model model) {
        model.addAttribute("name", user.getAttributes().get("name"));
        model.addAttribute("email", user.getEmail());
        return "me";
    }
}
