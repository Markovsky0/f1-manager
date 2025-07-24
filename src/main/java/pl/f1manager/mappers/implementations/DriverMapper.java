package pl.f1manager.mappers.implementations;

import org.springframework.stereotype.Component;
import pl.f1manager.mappers.GenericMapper;
import pl.f1manager.model.db.Driver;
import pl.f1manager.model.dto.DriverDto;

@Component
public class DriverMapper implements GenericMapper<DriverDto, Driver> {
    @Override
    public DriverDto toDto(Driver entity) {
        if (entity == null) {
            return null;
        }
        return DriverDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .age(entity.getAge())
                .gender(entity.getGender())
                .status(entity.getStatus())
                .quickness(entity.getQuickness())
                .focus(entity.getFocus())
                .overtaking(entity.getOvertaking())
                .drivingInWet(entity.getDrivingInWet())
                .agility(entity.getAgility())
                .experience(entity.getExperience())
                .morale(entity.getMorale())
                .nationality(entity.getNationality())
                .overall(entity.getOverall())
                .technicalInsight(entity.getTechnicalInsight())
                .popularity(entity.getPopularity())
                .build();
    }

    @Override
    public Driver toEntity(DriverDto dto) {
        return null;
    }
}
