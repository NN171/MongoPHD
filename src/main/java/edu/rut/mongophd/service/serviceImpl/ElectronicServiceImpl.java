package edu.rut.mongophd.service.serviceImpl;

import edu.rut.mongophd.dto.ElectronicDto;
import edu.rut.mongophd.mapper.ElectronicMapper;
import edu.rut.mongophd.model.Electronic;
import edu.rut.mongophd.repository.ElectronicRepository;
import edu.rut.mongophd.service.ElectronicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicServiceImpl implements ElectronicService {

    private final ElectronicRepository electronicRepository;
    private final ElectronicMapper electronicMapper;

    public ElectronicServiceImpl(ElectronicRepository electronicRepository, ElectronicMapper electronicMapper) {
        this.electronicRepository = electronicRepository;
        this.electronicMapper = electronicMapper;
    }

    @Override
    public long countElectronics() {
        return electronicRepository.count();
    }

    @Override
    public ElectronicDto addElectronic(ElectronicDto electronicDto) {
        Electronic electronic = electronicMapper.dtoToEntity(electronicDto);
        electronicRepository.save(electronic);
        return electronicDto;
    }

    @Override
    public List<ElectronicDto> getByName(String name) {
        List<Electronic> electronics = electronicRepository.getByName(name)
                .orElseThrow(() -> new RuntimeException("Name not found"));

        return electronicMapper.electronicsToDto(electronics);
    }

    @Override
    public List<ElectronicDto> getByBrand(String brand) {
        List<Electronic> electronics =  electronicRepository.getByBrand(brand)
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        return electronicMapper.electronicsToDto(electronics);
    }

    @Override
    public Page<ElectronicDto> getByAvailability(int page, int no, boolean isAvailable) {
        Pageable sortedByName = PageRequest.of(page, no, Sort.by("name").ascending());
        Page<Electronic> electronicPage = electronicRepository.getByAvailability(isAvailable, sortedByName);
        return electronicMapper.pageElectronicsToDto(electronicPage);
    }

    @Override
    public Page<ElectronicDto> getByCountry(int page, int no, String country) {
        Pageable sortedByName = PageRequest.of(page, no, Sort.by("country").ascending());
        Page<Electronic> electronicPage = electronicRepository.getByCountryProducer(country, sortedByName);
        return electronicMapper.pageElectronicsToDto(electronicPage);
    }

    @Override
    public List<ElectronicDto> getByNameAndBrand(String name, String brand) {
        List<Electronic> electronics = electronicRepository.getByNameAndBrand(name, brand)
                .orElseThrow(() -> new RuntimeException("Not found"));

        return electronicMapper.electronicsToDto(electronics);
    }
}
