package com.example.main.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    String calc(){
        return "calculator";
    }

    @PostMapping("/result")
    public String result(
            @RequestParam(name = "first_number") double first_number,
            @RequestParam(name = "second_number") double second_number,
            @RequestParam(name = "operator") String operator,
            Model model
    ) {
        double result = 0;
        switch (operator) {
            case "+" -> result = first_number + second_number;
            case "-" -> result = first_number - second_number;
            case "*" -> result = first_number * second_number;
            case "/" -> {
                if (second_number == 0){
                    model.addAttribute("error", "Деление на ноль!");
                    return "error";
                }
                result = first_number / second_number;
            }
        }
        model.addAttribute("result", result);
        return "result";
    }
}
