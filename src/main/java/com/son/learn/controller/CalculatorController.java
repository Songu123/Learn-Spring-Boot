package com.son.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calc")
public class CalculatorController {

    @GetMapping
    public String showForm() {
        System.out.println("Request to endpoint: /calculator");
        return "calculator-form";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam("a") double a,
            @RequestParam("b") double b,
            @RequestParam("operation") String operation,
            Model model
    ) {
        // Log
        System.out.println("[POST] /calc/calculate");
        System.out.println("  └─> a = " + a);
        System.out.println("  └─> b = " + b);
        System.out.println("  └─> operation = " + operation);

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("operation", operation);

        try {
            double result;
            String operationSymbol;
            String operationName;

            switch (operation) {
                case "+" -> {
                    result = a + b;
                    operationSymbol = "+";
                    operationName = "Addition";
                }
                case "-" -> {
                    result = a - b;
                    operationSymbol = "-";
                    operationName = "Subtraction";
                }
                case "*" -> {
                    result = a * b;
                    operationSymbol = "*";
                    operationName = "Multiplication";
                }
                case "/" -> {
                    if (b == 0) {
                        model.addAttribute("error", "❌ Không thể chia cho 0!");
                        return "calculator-result";
                    }
                    result = a / b;
                    operationSymbol = "/";
                    operationName = "Division";
                }
                default -> {
                    model.addAttribute("error", "❌ Phép tính không hợp lệ!");
                    return "calculator-result";
                }
            }
            model.addAttribute("result", result);
            model.addAttribute("operationSymbol", operationSymbol);
            model.addAttribute("operationName", operationName);
        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
            model.addAttribute("error", "❌ Lỗi:  " + e.getMessage());
        }
        return "calculator-result";
    }
}