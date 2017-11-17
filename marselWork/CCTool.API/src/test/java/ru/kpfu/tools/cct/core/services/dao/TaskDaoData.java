package ru.kpfu.tools.cct.core.services.dao;
import ru.kpfu.tools.cct.core.services.models.Task;

import java.net.URL;

public class TaskDaoData {

    public static final Task TASK_1 = new Task(0, 0, "simple_task", 0, getURL("file://instructions.pdf"));
    public static final Task TASK_2 = new Task(1, 0, "simple_task_2", 0, getURL("file://instructions_2.pdf"));

    private static URL getURL(String url) {
        try {
            return new URL(url);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
