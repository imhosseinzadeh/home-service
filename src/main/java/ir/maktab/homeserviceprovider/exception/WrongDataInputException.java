package ir.maktab.homeserviceprovider.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WrongDataInputException extends Exception {

    public WrongDataInputException(String message) {
        super(message);
    }

    public WrongDataInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
