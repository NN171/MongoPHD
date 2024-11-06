package edu.rut.mongophd.mapper;

import edu.rut.mongophd.dto.ElectronicDto;
import edu.rut.mongophd.model.Electronic;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ElectronicMapper {

    Electronic dtoToEntity(ElectronicDto electronicDto);
    List<ElectronicDto> electronicsToDto(List<Electronic> electronics);
}
