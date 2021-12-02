package by.htp.netcracker.foodfactory.Helper;

public enum OrderStatus {

    CONSIDERED("Оформляется"),
    FORMALIZED("Оформлен"),
    DONE("Подтверждён");


    private final String displayValue;

    private OrderStatus(String displayValue){
        this.displayValue = displayValue;
    }
    public String getDisplayValue(){
        return displayValue;
    }

    }
