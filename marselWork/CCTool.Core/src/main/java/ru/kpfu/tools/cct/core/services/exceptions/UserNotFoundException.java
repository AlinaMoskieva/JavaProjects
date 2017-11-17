package ru.kpfu.tools.cct.core.services.exceptions;


public class UserNotFoundException extends RuntimeException {
    private String message = null;

    public UserNotFoundException(int userId) {
        this.message = "User with id <" + userId + "> not found.";
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
