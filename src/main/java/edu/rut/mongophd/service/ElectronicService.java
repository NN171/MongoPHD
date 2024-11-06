package edu.rut.mongophd.service;

import edu.rut.mongophd.dto.ElectronicDto;
import edu.rut.mongophd.model.Electronic;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ElectronicService {

    long countElectronics();
    ElectronicDto addElectronic(ElectronicDto electronicDto);
    List<ElectronicDto> getByName(String name);
    List<ElectronicDto> getByBrand(String brand);
    List<ElectronicDto> getByAvailability(int page, int no, boolean availability);
    List<ElectronicDto> getByCountry(int page, int no, String country);
    List<ElectronicDto> getByNameAndBrand(String name, String brand);

}
