package edu.rut.mongophd.controller;

import edu.rut.mongophd.dto.ElectronicDto;
import edu.rut.mongophd.model.Electronic;
import edu.rut.mongophd.service.ElectronicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/electronics")
public class ElectronicController {

    private final ElectronicService electronicService;

    public ElectronicController(ElectronicService electronicService) {
        this.electronicService = electronicService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElectronicDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(electronicService.getElectronic(id));
    }

    @GetMapping("/")
    public ResponseEntity<Page<Electronic>> getElectronics(@RequestParam(defaultValue = "0") int offset,
                                                           @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(electronicService.getElectronics(PageRequest.of(offset, limit)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElectronicDto> updateElectronic(@RequestBody ElectronicDto electronicDto,
                                                          @PathVariable String id) {
        return ResponseEntity.ok(electronicService.updateElectronic(electronicDto, id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCount() {
        return ResponseEntity.ok(electronicService.countElectronics());
    }

    @PostMapping("/")
    public ResponseEntity<ElectronicDto> createElectronic(@RequestBody ElectronicDto electronicDto) {
        return ResponseEntity.ok(electronicService.addElectronic(electronicDto));
    }

//    @GetMapping("/{name}")
//    public ResponseEntity<List<ElectronicDto>> getByName(@PathVariable String name) {
//        return ResponseEntity.ok(electronicService.getByName(name));
//    }
//
//    @GetMapping("/brand")
//    public ResponseEntity<List<ElectronicDto>> getByBrand(@RequestParam String brand) {
//        return ResponseEntity.ok(electronicService.getByBrand(brand));
//    }

//    @GetMapping("/availability")
//    public ResponseEntity<Page<ElectronicDto>> getByAvailability(@RequestParam(defaultValue = "0") int offset,
//                                                  @RequestParam(defaultValue = "10") int limit,
//                                                  @RequestParam boolean available) {
//        return ResponseEntity.ok(electronicService.getByAvailability(offset, limit, available));
//    }
//
//    @GetMapping("/country")
//    public ResponseEntity<Page<ElectronicDto>> getByCountry(@RequestParam int offset,
//                                                            @RequestParam int limit,
//                                                            @RequestParam String country) {
//        return ResponseEntity.ok(electronicService.getByCountry(offset, limit, country));
//    }
//
//    @GetMapping("/namebrand")
//    public ResponseEntity<List<ElectronicDto>> getByNameAndBrand(@RequestParam String name,
//                                                            @RequestParam String brand) {
//        return ResponseEntity.ok(electronicService.getByNameAndBrand(name, brand));
//    }

    @DeleteMapping("/{id}")
    public void deleteElectronic(@PathVariable String id) {
        electronicService.deleteElectronic(id);
    }
}
