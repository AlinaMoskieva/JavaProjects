package ru.kpfu.tools.cct.core.services.exceptions;

public class HasUncompletedTasksException extends RuntimeException {
    private String message = null;



    public HasUncompletedTasksException(int userId) {
        this.message = "User <" + userId + "> has uncompleted tasks.";
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
