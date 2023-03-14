package Exceptions;

import java.io.IOException;

public class IncorrectArgumentException extends IOException {
    public IncorrectArgumentException(){

    }
    public IncorrectArgumentException(String message) {
        super(message);
    }
}
