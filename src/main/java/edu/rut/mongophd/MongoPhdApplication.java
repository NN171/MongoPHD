package edu.rut.mongophd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MongoPhdApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoPhdApplication.class, args);
    }

}
