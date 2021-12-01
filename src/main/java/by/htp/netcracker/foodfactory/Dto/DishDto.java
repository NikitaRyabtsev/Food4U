package by.htp.netcracker.foodfactory.Dto;

import java.math.BigDecimal;

public class DishDto {

    private String name;
    private BigDecimal price;
    private String src;
    private String type;

    public DishDto(String name, BigDecimal price, String src) {
        this.name = name;
        this.price = price;
        this.src = src;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
