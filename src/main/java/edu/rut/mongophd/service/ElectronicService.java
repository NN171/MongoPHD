package edu.rut.mongophd.service;

import edu.rut.mongophd.dto.ElectronicDto;
import edu.rut.mongophd.model.Electronic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ElectronicService {

    long countElectronics();

    ElectronicDto addElectronic(ElectronicDto electronicDto);

    Page<Electronic> getElectronics(PageRequest pageRequest);

    void deleteElectronic(String id);

    ElectronicDto getElectronic(String id);

    ElectronicDto updateElectronic(ElectronicDto electronicDto, String id);
}
