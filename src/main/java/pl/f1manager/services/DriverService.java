package pl.f1manager.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.f1manager.model.api.DriverSearchCriteria;
import pl.f1manager.model.dto.DriverDto;

import java.util.List;

public interface DriverService {
    List<DriverDto> getDrivers();
    DriverDto getDriverById(Long id);
    Page<DriverDto> getDriversPageByCriteria(DriverSearchCriteria driverSearchCriteria, Pageable pageable);
}
