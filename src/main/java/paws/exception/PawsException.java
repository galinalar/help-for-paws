package paws.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PawsException extends Exception {
    public PawsException(String message) {
        super(message);

        log.error(message);
    }

    public PawsException(String message, Throwable cause) {
        super(message, cause);

        log.error(message, cause);
    }
}
