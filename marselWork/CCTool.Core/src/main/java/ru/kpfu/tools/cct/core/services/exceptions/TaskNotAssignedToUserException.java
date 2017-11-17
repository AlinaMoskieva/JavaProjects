package ru.kpfu.tools.cct.core.services.exceptions;

public class TaskNotAssignedToUserException extends RuntimeException {
    private String message = null;

    public TaskNotAssignedToUserException(int userId, int taskId) {
        this.message = "Task <" + taskId + "> not assigned to user <" + userId + ">.";
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
