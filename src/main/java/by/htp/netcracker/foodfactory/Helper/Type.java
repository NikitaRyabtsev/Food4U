package by.htp.netcracker.foodfactory.Helper;

public enum Type {

    BAKERY("Выпечка"),
    DESERT("Десерт"),
    SALAD("Салат"),
    SEAFOOD("Морепродукты"),
    DRINK("Напитки"),
    SAUCE("Соусы"),
    GARNISH("Гарниры"),
    MEAT("Мясное"),
    SOUP("Супы"),
    FAST_FOOD("Фастфуд");

    private final String displayValue;

    private Type(String displayValue){
        this.displayValue = displayValue;
    }
    public String getDisplayValue(){
        return displayValue;
    }


}
