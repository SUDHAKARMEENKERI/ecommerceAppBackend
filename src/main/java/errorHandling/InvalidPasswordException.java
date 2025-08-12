package errorHandling;

import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(String message) {
        super(message);
    }

    public InvalidPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPasswordException(HttpStatus notFound, String user_not_found) {

    }
}