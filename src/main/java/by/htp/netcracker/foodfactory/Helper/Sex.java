package by.htp.netcracker.foodfactory.Helper;

public enum Sex {

    MALE("Мужской"),
    FEMALE("Женский");

    private final String displayValue;

    private Sex(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}