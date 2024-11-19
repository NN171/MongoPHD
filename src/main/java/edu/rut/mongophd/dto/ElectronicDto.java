package edu.rut.mongophd.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ElectronicDto {

    private String name;
    private String brand;
    private List<String> color;
    private LocalDate guarantee;
    private String category;
    private String availability;
    private String countryProducer;
    private double price;
}
