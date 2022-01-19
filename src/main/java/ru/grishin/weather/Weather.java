package ru.grishin.weather;

import org.springframework.stereotype.Component;
import ru.grishin.weather.service.ParsService;

@Component
public class Weather {
    private ParsService parsService;

    public Weather(ParsService parsService){
        this.parsService = parsService;
    }

    public String getTemperature(){
        return parsService.parse();
    }
}
