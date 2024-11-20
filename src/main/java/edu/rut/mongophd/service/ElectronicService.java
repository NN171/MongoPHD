package edu.rut.mongophd.service;

import edu.rut.mongophd.dto.ElectronicDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ElectronicService {

    long countElectronics();

    ElectronicDto addElectronic(ElectronicDto electronicDto);

    List<ElectronicDto> getByName(String name);

    List<ElectronicDto> getByBrand(String brand);

    Page<ElectronicDto> getByAvailability(int page, int no, boolean availability);

    Page<ElectronicDto> getByCountry(int page, int no, String country);

    List<ElectronicDto> getByNameAndBrand(String name, String brand);

    Page<ElectronicDto> getElectronics(PageRequest pageRequest);

    void deleteElectronic(String id);
}
