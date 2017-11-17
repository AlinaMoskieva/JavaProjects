package ru.kpfu.tools.cct.core.services.exceptions;

public class TaskNotFoundException extends RuntimeException {
    private String message = null;

    public TaskNotFoundException(int taskId) {
        this.message = "Task with id <" + taskId + "> not found.";
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
