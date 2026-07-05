package com.example.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/rooms")
    public String rooms() {
        return "index";
    }

    @GetMapping("/users")
    public String users() {
        return "index";
    }

    @GetMapping("/maintenance")
    public String maintenance() {
        return "index";
    }
}