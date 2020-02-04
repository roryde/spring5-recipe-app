package rory.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import rory.springframework.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {
}
