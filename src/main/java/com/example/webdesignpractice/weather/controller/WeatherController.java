package com.example.webdesignpractice.weather.controller;

import com.example.webdesignpractice.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("")
    public ResponseEntity<String> getWeather() {
        return ResponseEntity.ok(weatherService.getWeather());
    }
}
