package by.htp.netcracker.foodfactory.Helper;

public enum Status {
    BLOCK("Заблокирован"),
    UNBLOCK("Разблокирован");

    private final String displayValue;

    private Status(String displayValue){
        this.displayValue = displayValue;
    }
    public String getDisplayValue(){
        return displayValue;
    }

}
