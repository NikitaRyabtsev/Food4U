package by.htp.netcracker.foodfactory.Helper;

public class MathRandom {

    public int generateNumberOfBooking(){
        int numberOfBooking = 1 + (int) (Math.random() * 10000);
        return numberOfBooking;
    }
}
