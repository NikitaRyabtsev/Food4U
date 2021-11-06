package by.htp.netcracker.foodfactory.Reposotories;

import by.htp.netcracker.foodfactory.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
    @Override
    List<Ingredient> findAll();

    @Override
    Ingredient getById(Integer id);

    Ingredient save(Ingredient ingredient);

    @Override
    void deleteById(Integer integer);
}
