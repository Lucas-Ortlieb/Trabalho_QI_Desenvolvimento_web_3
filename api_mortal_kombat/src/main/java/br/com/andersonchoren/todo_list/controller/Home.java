package br.com.andersonchoren.todo_list.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Home {
    @GetMapping
    public String home() {
        return "API Mortal Kombat";
    }
}
