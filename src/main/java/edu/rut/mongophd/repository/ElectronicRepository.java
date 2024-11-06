package edu.rut.mongophd.repository;

import edu.rut.mongophd.model.Electronic;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ElectronicRepository extends MongoRepository<Electronic, String> {
    Optional<List<Electronic>> getByName(String name);
    Optional<List<Electronic>> getByBrand(String brand);
    Optional<List<Electronic>> getByAvailability(boolean availability);
    Page<Electronic> getByCountryProducer(String countryProducer);
    Optional<List<Electronic>> getByNameAndBrand(String name, String brand);

}
