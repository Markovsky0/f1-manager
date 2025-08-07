package pl.f1manager.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.f1manager.model.dto.DriverDto;
import pl.f1manager.services.DriverService;

import java.util.List;

@RestController
@RequestMapping("/drivers")
@Slf4j
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/")
    public List<DriverDto> getDrivers() {
        log.info("GET /drivers endpoint invoked");
        return driverService.getDrivers();
    }
}
