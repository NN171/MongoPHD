package edu.rut.mongophd.controller;

import edu.rut.mongophd.dto.ElectronicDto;
import edu.rut.mongophd.service.ElectronicService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/electronics")
public class ElectronicController {

    private final ElectronicService electronicService;

    public ElectronicController(ElectronicService electronicService) {
        this.electronicService = electronicService;
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCount() {
        return ResponseEntity.ok(electronicService.countElectronics());
    }

    @PostMapping("/create")
    public ResponseEntity<ElectronicDto> createElectronic(@RequestBody ElectronicDto electronicDto) {
        return ResponseEntity.ok(electronicService.addElectronic(electronicDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<ElectronicDto>> getByName(@RequestParam String name) {
        return ResponseEntity.ok(electronicService.getByName(name));
    }

    @GetMapping("/")
    public ResponseEntity<List<ElectronicDto>> getByBrand(@RequestParam String brand) {
        return ResponseEntity.ok(electronicService.getByBrand(brand));
    }

    @GetMapping("/")
    public ResponseEntity<Page<ElectronicDto>> getByAvailability(@RequestParam int page,
                                                  @RequestParam int no,
                                                  @RequestParam boolean available) {
        return ResponseEntity.ok(electronicService.getByAvailability(page, no, available));
    }

    @GetMapping("/")
    public ResponseEntity<Page<ElectronicDto>> getByCountry(@RequestParam int page,
                                                            @RequestParam int no,
                                                            @RequestParam String country) {
        return ResponseEntity.ok(electronicService.getByCountry(page, no, country));
    }

    @GetMapping("/")
    public ResponseEntity<List<ElectronicDto>> getByNameAndBrand(@RequestParam String name,
                                                            @RequestParam String brand) {
        return ResponseEntity.ok(electronicService.getByNameAndBrand(name, brand));
    }
}
