package edu.rut.mongophd.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "store")
@Data
@NoArgsConstructor
public class Electronic {

    @Id
    private String id;
    @Field(name = "name")
    @Indexed(sparse = true, direction = IndexDirection.ASCENDING, background = false)
    private String name;

    @Indexed(sparse = true, direction = IndexDirection.ASCENDING, background = false)
    @Field(name = "brand")
    private String brand;

    @Field(name = "color")
    private List<String> color;

    @Field(name = "guarantee")
    private LocalDate guarantee;

    @Field(name = "category")
    private String category;

    @Field(name = "availability")
    private String availability;

    @Field(name = "country_producer")
    private String countryProducer;

    @Field(name = "price")
    private double price;
}
