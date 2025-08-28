package pl.f1manager.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.f1manager.model.db.Driver;
import pl.f1manager.model.dto.DriverDto;
import pl.f1manager.model.enums.DriverStatus;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    @Query(value = "select * from f1_manager.driver d " +
            "where (:firstName is null or upper(d.firstName) like concat(upper(:firstName), '%'))" +
            "and (:lastName is null or upper(d.lastName) like concat(upper(:lastName), '%'))" +
            "and (:minAge is null or :maxAge is null or d.age between :minAge and :maxAge)" +
            "and (:status is null or d.status = :status)" +
            "and (:minOvr is null or :maxOvr is null or d.overall between :minOvr and :maxOvr)",
            nativeQuery = true)
    Page<DriverDto> findByCriteria(@Param("firstName") String firstName,
                                   @Param("lastName") String lastName,
                                   @Param("minAge") short minAge,
                                   @Param("maxAge") short maxAge,
                                   @Param("status") DriverStatus status,
                                   @Param("minOvr") short minOverall,
                                   @Param("minOvr") short maxOverall,
                                   Pageable pageable);
}
