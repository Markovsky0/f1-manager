package pl.f1manager.services;

import pl.f1manager.model.dto.DriverDto;

import java.util.List;

public interface DriverService {
    List<DriverDto> getDrivers();
}
