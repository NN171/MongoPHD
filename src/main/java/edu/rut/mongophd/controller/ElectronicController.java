package edu.rut.mongophd.controller;

import edu.rut.mongophd.dto.ElectronicDto;
import edu.rut.mongophd.model.Electronic;
import edu.rut.mongophd.service.ElectronicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("")
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

    @PostMapping("")
    public ResponseEntity<ElectronicDto> createElectronic(@RequestBody ElectronicDto electronicDto) {
        return ResponseEntity.ok(electronicService.addElectronic(electronicDto));
    }

    @DeleteMapping("/{id}")
    public void deleteElectronic(@PathVariable String id) {
        electronicService.deleteElectronic(id);
    }
}
