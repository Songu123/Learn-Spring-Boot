package com.son.learn.controller;

import com.son.learn.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    private final GreetingService greetingService;

    @Autowired
    public HomeController(GreetingService greetingService) {
        this.greetingService = greetingService;
        System.out.println("Home controller created");
        System.out.println("Greeting Service: " + greetingService.getClass().getSimpleName());
    }

    @GetMapping("/")
    @ResponseBody
    public String home() {
        System.out.println("Request to endpoint: /home");
        String greeting = greetingService.getGreeting();
        System.out.println("Response: " + greeting);
        return greeting;
    }

    @GetMapping("/greet")
    @ResponseBody
    public String greet(String name) {
        System.out.println("Request to endpoint: /greet with name: " + name);
        String greeting = greetingService.getGreeting(name);
        System.out.println("Response: " + greeting);
        return greeting;
    }

    @GetMapping("/info")
    @ResponseBody
    public String info() {
        String info = "This is the Learn Application using Spring MVC.";
        System.out.println("Request to endpoint: /info");
        System.out.println("Response: " + info);
        return info;
    }
}
