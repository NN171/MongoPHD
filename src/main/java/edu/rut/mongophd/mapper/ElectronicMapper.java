package edu.rut.mongophd.mapper;

import edu.rut.mongophd.dto.ElectronicDto;
import edu.rut.mongophd.model.Electronic;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ElectronicMapper {

    Electronic dtoToEntity(ElectronicDto electronicDto);
    List<ElectronicDto> electronicsToDto(List<Electronic> electronics);
    Page<ElectronicDto> pageElectronicsToDto(Page<Electronic> electronics);
}
