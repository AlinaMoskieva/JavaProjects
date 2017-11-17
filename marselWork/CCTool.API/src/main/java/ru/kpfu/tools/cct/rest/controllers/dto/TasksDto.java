package ru.kpfu.tools.cct.rest.controllers.dto;

import java.util.List;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
public class TasksDto implements DataTransferObject {
    private List<TaskDto> tasks;

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
    }
}
