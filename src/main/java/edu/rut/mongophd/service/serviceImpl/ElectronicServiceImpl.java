package edu.rut.mongophd.service.serviceImpl;

import edu.rut.mongophd.dto.ElectronicDto;
import edu.rut.mongophd.mapper.ElectronicMapper;
import edu.rut.mongophd.model.Electronic;
import edu.rut.mongophd.repository.ElectronicRepository;
import edu.rut.mongophd.service.ElectronicService;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ElectronicServiceImpl implements ElectronicService {

    private final ElectronicRepository electronicRepository;
    private final ModelMapper mapper;

    public ElectronicServiceImpl(ElectronicRepository electronicRepository,
                                 ModelMapper mapper) {
        this.electronicRepository = electronicRepository;
        this.mapper = mapper;
    }

    @Override
    @Cacheable("getAll")
    public Page<Electronic> getElectronics(PageRequest pageRequest) {
        return electronicRepository.findAll(pageRequest);
    }

    @Override
    @Cacheable("getCount")
    public long countElectronics() {
        return electronicRepository.count();
    }

    @Override
    public void deleteElectronic(String id) {
        electronicRepository.deleteById(id);
    }

    @Override
    @Cacheable("getSingle")
    public ElectronicDto getElectronic(String id) {
        Electronic electronic = electronicRepository.getById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return mapper.map(electronic, ElectronicDto.class);
    }

    @Override
    @CacheEvict("update")
    public ElectronicDto updateElectronic(ElectronicDto electronicDto, String id) {
        Electronic electronic = mapper.map(electronicDto, Electronic.class);

        if (electronicDto.getColor() != null) {
            electronic.setColor(Arrays.asList(electronicDto.getColor().substring(1, electronicDto.getColor().length()-1).split(", ")));
        }

        electronic.setId(id);
        electronicRepository.save(electronic);

        ElectronicDto updatedDto = mapper.map(electronic, ElectronicDto.class);
        updatedDto.setColor(String.join(",", electronic.getColor()));
        return mapper.map(electronic, ElectronicDto.class);
    }

    @Override
    @Cacheable("create")
    public ElectronicDto addElectronic(ElectronicDto electronicDto) {
        Electronic electronic = mapper.map(electronicDto, Electronic.class);
        electronicRepository.save(electronic);

        if (electronicDto.getColor() != null) {
            electronic.setColor(Arrays.asList(electronicDto.getColor().substring(1, electronicDto.getColor().length()-1).split(", ")));
        }

        electronicRepository.save(electronic);

        ElectronicDto updatedDto = mapper.map(electronic, ElectronicDto.class);
        updatedDto.setColor(String.join(",", electronic.getColor()));
        return electronicDto;
    }
}
