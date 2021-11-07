package by.htp.netcracker.foodfactory.Helper;

public enum Role {

    USER("Пользователь"),
    ADMIN("Админ");

    private final String displayValue;

    private Role(String displayValue){
        this.displayValue = displayValue;
    }
    public String getDisplayValue(){
        return displayValue;
    }

}

