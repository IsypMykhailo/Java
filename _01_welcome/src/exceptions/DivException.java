package exceptions;

import lombok.Getter;

public class DivException extends Exception{
//    @Getter
//    private int number;

    public DivException(String message){
        super(message);
        // number = num;
    }
}
