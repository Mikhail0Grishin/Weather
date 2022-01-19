package ru.grishin.weather.service;

import org.springframework.stereotype.Service;
import ru.grishin.weather.model.Temperature;
import ru.grishin.weather.repository.TemperatureRepository;

import java.sql.Date;

@Service
public class TemperatureService {
    private final TemperatureRepository temperatureRepository;

    public TemperatureService(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    public Temperature findByDate(Date date) {
        return temperatureRepository.findByDate(date);
    }

    public Temperature saveTemperature(Temperature temperature) {
        return temperatureRepository.save(temperature);
    }
}
