package ru.grishin.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.grishin.weather.Weather;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private Weather weather;

    public WeatherController(Weather weather){
        this.weather = weather;
    }

    @GetMapping
    public String temperature(){
        return "current temperature: " + weather.getTemperature();
    }
}
