package by.htp.netcracker.foodfactory.Dao;

public class DaoException extends Exception{

    public DaoException(){
        super();
    }
    public DaoException(String message){
        super(message);
    }
    public DaoException(Exception e,String message){
        super(message, e);
    }
    public DaoException(Exception e){
        super(e);
    }

}
