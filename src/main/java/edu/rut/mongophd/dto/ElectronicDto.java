package edu.rut.mongophd.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ElectronicDto {

    private String id;
    private String name;
    private String brand;
    private String color;
    private LocalDate guarantee;
    private String category;
    private boolean availability;
    private String countryProducer;
    private double price;
}
