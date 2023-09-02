package com.example.main.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @GetMapping("/redirect-to-calculator")
    public String redirectToCalculator() {
        return "redirect:/calculator";
    }

    @GetMapping("/redirect-to-converter")
    public String redirectToConverter() {
        return "redirect:/currency_converter";
    }
}

