package ru.kpfu.tools.cct.core.services.dao.tasks;

import ru.kpfu.tools.cct.core.services.models.Task;

import java.util.List;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
public interface TasksDao {
    List<Task> getAvailableTasks();

    Task getTask(int taskId);

    void taskAssign(int userId, int taskId);

    void complaintToTask(int userId, int taskId, String description);

    void finishTask(int userId, int taskId);
}
