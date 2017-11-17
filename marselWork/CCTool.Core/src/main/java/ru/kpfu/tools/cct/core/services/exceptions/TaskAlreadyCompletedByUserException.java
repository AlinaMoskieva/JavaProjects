package ru.kpfu.tools.cct.core.services.exceptions;

public class TaskAlreadyCompletedByUserException extends RuntimeException {
    private String message = null;

    public TaskAlreadyCompletedByUserException(int userId, int taskId) {
        this.message = "Task <" + taskId + "> already completed by user <" + userId + ">.";
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
