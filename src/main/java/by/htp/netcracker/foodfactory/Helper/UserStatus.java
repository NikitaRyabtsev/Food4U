package by.htp.netcracker.foodfactory.Helper;

public enum UserStatus {
    BLOCK("Заблокирован"),
    UNBLOCK("Разблокирован");

    private final String displayValue;

    private UserStatus(String displayValue){
        this.displayValue = displayValue;
    }
    public String getDisplayValue(){
        return displayValue;
    }

}
