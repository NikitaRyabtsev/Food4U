package by.htp.netcracker.foodfactory.Dto;

import java.util.List;

public class DishWrapperDto {

    private DishDto dishDto;
    private List<DishIngredientDto> dishIngredientDto;

    public DishWrapperDto(DishDto dishDto, List<DishIngredientDto> dishIngredientDto) {
        this.dishDto = dishDto;
        this.dishIngredientDto = dishIngredientDto;
    }

    public DishDto getDishDto() {
        return dishDto;
    }

    public void setDishDto(DishDto dishDto) {
        this.dishDto = dishDto;
    }

    public List<DishIngredientDto> getDishIngredientDto() {
        return dishIngredientDto;
    }

    public void setDishIngredientDto(List<DishIngredientDto> dishIngredientDto) {
        this.dishIngredientDto = dishIngredientDto;
    }
}
