package ru.grishin.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.grishin.weather.model.Temperature;

import java.sql.Date;

public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
    Temperature findByDate(Date date);
}
