import java.io.IOException;

public class WrongLoginException extends IOException {
     WrongLoginException(String message){
super(message);
    }
    WrongLoginException(){

    }

}
