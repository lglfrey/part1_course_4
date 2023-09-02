package com.example.main.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ConverterController {
    @GetMapping("/currency_converter")
    public String showCurrencyConverter() {
        return "currency_converter";
    }

    @GetMapping ("/convert")
    public String convertCurrency(
            @RequestParam(name="amount") double amount,
            @RequestParam(name="fromCurrency") String fromCurrency,
            @RequestParam(name="toCurrency") String toCurrency,
            Model model) {

        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("RUB-USD", 0.013);
        exchangeRates.put("RUB-EUR", 0.011);
        exchangeRates.put("RUB-CNY", 0.084);
        exchangeRates.put("USD-EUR", 0.85);
        exchangeRates.put("USD-RUB", 76.92);
        exchangeRates.put("USD-CNY", 6.45);
        exchangeRates.put("EUR-RUB", 90.91);
        exchangeRates.put("EUR-USD", 1.17);
        exchangeRates.put("EUR-CNY", 7.6);
        exchangeRates.put("CNY-RUB", 11.90);
        exchangeRates.put("CNY-USD", 0.15);
        exchangeRates.put("CNY-EUR", 0.13);

        String rateKey = fromCurrency + "-" + toCurrency;
        Double rate = exchangeRates.get(rateKey);
        if (rate == null) {
            model.addAttribute("result", "Курс обмена не найден.");
            return "currency_converter";
        }
        double result = amount * rate;
        model.addAttribute("result", result);

        return "currency_converter";
    }
}
