package com.son.learn.service;

import org.springframework.stereotype.Component;

@Component
public class EnglishGreetingService implements GreetingService {
    @Override
    public String getGreeting() {
        System.out.println("Hello World - EnglishGreetingService");
        return "Hello Spring Mvc";
    }

    @Override
    public String getGreeting(String name) {
        System.out.println("Hello " + name + " - EnglishGreetingService");
        return "Hello " + name + " - EnglishGreetingService";
    }
}
