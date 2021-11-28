package by.htp.netcracker.foodfactory.Helper;

public class MathRandom {

    public int generateNumberOfBooking(){
        int numberOfBooking = (int)(1 + Math.random() * 9999999);
        return numberOfBooking;
    }
}
