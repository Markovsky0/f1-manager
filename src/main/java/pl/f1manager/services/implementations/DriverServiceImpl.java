package pl.f1manager.services.implementations;

import org.springframework.stereotype.Service;
import pl.f1manager.mappers.implementations.DriverMapper;
import pl.f1manager.model.dto.DriverDto;
import pl.f1manager.repositories.DriverRepository;
import pl.f1manager.services.DriverService;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    public DriverServiceImpl(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    @Override
    public List<DriverDto> getDrivers() {
        return driverRepository.findAll().stream().map(driverMapper::toDto).toList();
    }
}
