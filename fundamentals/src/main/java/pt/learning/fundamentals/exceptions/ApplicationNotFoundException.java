package pt.learning.fundamentals.exceptions;


import java.util.function.Supplier;

public class ApplicationNotFoundException extends RuntimeException implements Supplier<ApplicationNotFoundException> {

    public ApplicationNotFoundException(final String message) {
        super(message);
    }

    @Override
    public ApplicationNotFoundException get() {
        return this;
    }


}
