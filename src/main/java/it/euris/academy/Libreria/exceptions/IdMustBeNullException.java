package it.euris.academy.Libreria.exceptions;

public class IdMustBeNullException extends RuntimeException{

    public IdMustBeNullException() {
        super("Id must be null.");
    }

    public IdMustBeNullException(String message) {
        super(message);
    }

}
