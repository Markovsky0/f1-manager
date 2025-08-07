package pl.f1manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.f1manager.model.db.Tyre;

@Repository
public interface TyreRepository extends JpaRepository<Tyre, Long> {
}
