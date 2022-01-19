package ru.grishin.weather.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import ru.grishin.weather.model.Temperature;

import java.io.IOException;
import java.sql.Date;


@Component
public class ParsService {
    private final TemperatureService temperatureService;
    private String currentTemp;

    public ParsService(TemperatureService temperatureService){
        this.temperatureService = temperatureService;
    }

    public String parse(){
        Temperature temperature;
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        if(temperatureService.findByDate(date) != null)
        {
            temperature = temperatureService.findByDate(date);
            currentTemp = temperature.getTemperature();
        }
        else
        {
            try {
                Document doc = Jsoup.connect("https://yandex.ru/")
                        .referrer("http://www.google.com")
                        .get();

                Elements temp = doc.select("div.weather__temp");
                System.out.println(temp.text());
                currentTemp = temp.text();
                temperature = new Temperature();
                temperature.setDate(date);
                temperature.setTemperature(currentTemp);
                temperatureService.saveTemperature(temperature);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return currentTemp;
    }
}
