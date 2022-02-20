package ir.maktab.homeserviceprovider.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidDataInputException extends Exception {

    public InvalidDataInputException(String message) {
        super(message);
    }

    public InvalidDataInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
