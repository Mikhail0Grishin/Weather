package ru.grishin.weather.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Entity
@Table(name = "weather_history")
public class Temperature {
    @Id
    private int id;
    @Column(name = "weather_date")
    private Date date;
    @Column(name = "weather_temperature")
    private String temperature;
}
