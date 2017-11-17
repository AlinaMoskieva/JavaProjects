package ru.kpfu.tools.cct.rest.controllers.dto;

import com.inspiresoftware.lib.dto.geda.annotations.Dto;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
@Dto
public class TaskAssignmentDto implements DataTransferObject {
    private String taskId;
    private String userId;

    public String getTaskId() {
        return taskId;
    }

    public String getUserId() {
        return userId;
    }


    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
