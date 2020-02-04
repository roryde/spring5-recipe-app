package rory.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import rory.springframework.domain.Category;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
