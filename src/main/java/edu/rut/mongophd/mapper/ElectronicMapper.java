package edu.rut.mongophd.mapper;

import edu.rut.mongophd.dto.ElectronicDto;
import edu.rut.mongophd.model.Electronic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mapper(componentModel = "spring")
public interface ElectronicMapper {

//    @Mapping(target = "color", qualifiedByName = "sepString")
//    Electronic dtoToEntity(ElectronicDto electronicDto);
//
////    @Mapping(target = "color", qualifiedByName = "mapList")
//    ElectronicDto entityToDto(Electronic electronic);
//
////    @Mapping(target = "color", qualifiedByName = "mapList")
//    List<ElectronicDto> electronicsToDto(List<Electronic> electronics);

//    @Named("mapList")
//    default String mapColours(Electronic electronic) {
//        return electronic.getColor().stream().map(String::valueOf)
//                .collect(Collectors.joining(", "));
//    }
//
//    @Named("sepString")
//    default List<String> separateColours(ElectronicDto electronicDto) {
//        return Stream.of(electronicDto.getColor().split(", ", -1))
//                .collect(Collectors.toList());
//    }
}
