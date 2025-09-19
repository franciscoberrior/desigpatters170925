package patterns.infrastructure.exception;

public class FilterNotFoundException extends RuntimeException {

    private static final String GENERIC_MESSAGE = "Error filter book.";


    public FilterNotFoundException() {
        super(GENERIC_MESSAGE);
    }

    public FilterNotFoundException(Throwable cause) {
        super(GENERIC_MESSAGE, cause);
    }




}
