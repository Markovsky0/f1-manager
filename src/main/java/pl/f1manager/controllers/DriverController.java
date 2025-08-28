package pl.f1manager.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.f1manager.model.api.DriverSearchCriteria;
import pl.f1manager.model.dto.DriverDto;
import pl.f1manager.services.DriverService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drivers")
@Slf4j
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/")
    public ResponseEntity<List<DriverDto>> getDrivers() {
        log.info("GET /drivers endpoint invoked");
        return ResponseEntity.ok(driverService.getDrivers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverDto> getDriverById(@PathVariable Long id) {
        log.info("GET /drivers/{} endpoint invoked", id);
        return ResponseEntity.ok(driverService.getDriverById(id));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<DriverDto>> searchDriversPage(@RequestBody DriverSearchCriteria driverSearchCriteria,
                                                             Pageable pageable) {
        log.info("GET /drivers/search endpoint invoked");
        return ResponseEntity.ok(driverService.getDriversPageByCriteria(driverSearchCriteria, pageable));
    }
}
