package pl.f1manager.services.implementations;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.f1manager.mappers.implementations.DriverMapper;
import pl.f1manager.model.api.DriverSearchCriteria;
import pl.f1manager.model.db.Driver;
import pl.f1manager.model.dto.DriverDto;
import pl.f1manager.repositories.DriverRepository;
import pl.f1manager.services.DriverService;

import java.util.List;
import java.util.Optional;

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

    @Override
    public DriverDto getDriverById(Long id) {
        return driverRepository.findById(id).map(driverMapper::toDto).orElseThrow();
    }

    @Override
    public Page<DriverDto> getDriversPageByCriteria(DriverSearchCriteria criteria, Pageable pageable) {
        return driverRepository.findByCriteria(criteria.getFirstName(),
                        criteria.getLastName(),
                        criteria.getMinAge(),
                        criteria.getMaxAge(),
                        criteria.getStatus(),
                        criteria.getMinOverall(),
                        criteria.getMaxOverall(),
                        pageable);
    }
}
