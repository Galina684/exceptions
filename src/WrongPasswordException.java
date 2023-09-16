import java.io.IOException;

public class WrongPasswordException extends IOException {
    WrongPasswordException(String message){
        super(message);
    }
    WrongPasswordException(){

    }
}
