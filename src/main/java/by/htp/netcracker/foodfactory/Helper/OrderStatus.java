package by.htp.netcracker.foodfactory.Helper;

public enum OrderStatus {


    DONE("Оплачен"),
    INPROGRESS("Добавлен"),
    UNDONE("Не выполнен");

    private final String displayValue;

    private OrderStatus(String displayValue){
        this.displayValue = displayValue;
    }
    public String getDisplayValue(){
        return displayValue;
    }

    }
