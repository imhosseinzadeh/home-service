package ir.maktab.homeserviceprovider.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DataNotExistsException extends Exception {
    public DataNotExistsException(String message) {
        super(message);
    }

    public DataNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
