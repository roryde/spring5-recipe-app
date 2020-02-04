package rory.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import rory.springframework.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
