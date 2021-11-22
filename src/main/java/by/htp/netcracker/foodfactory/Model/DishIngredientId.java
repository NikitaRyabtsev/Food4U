package by.htp.netcracker.foodfactory.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DishIngredientId implements Serializable {

    @Column(name="dish_id")
    private Integer dishId;

    @Column(name="ingredient_id")
    private Integer ingredientId;

    public DishIngredientId(){

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishIngredientId that = (DishIngredientId) o;
        return Objects.equals(dishId, that.dishId) && Objects.equals(ingredientId, that.ingredientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishId, ingredientId);
    }

}
