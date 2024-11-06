package edu.rut.mongophd.repository;

import edu.rut.mongophd.dto.ElectronicDto;
import edu.rut.mongophd.model.Electronic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectronicRepository extends MongoRepository<Electronic, String> {
    Optional<List<Electronic>> getByName(String name);
    Optional<List<Electronic>> getByBrand(String brand);
    Page<Electronic> getByAvailability(boolean availability, Pageable pageable);
    Page<Electronic> getByCountryProducer(String countryProducer, Pageable pageable);
    Optional<List<Electronic>> getByNameAndBrand(String name, String brand);

}
