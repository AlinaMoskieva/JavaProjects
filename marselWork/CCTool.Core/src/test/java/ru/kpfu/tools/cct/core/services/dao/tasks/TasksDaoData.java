package ru.kpfu.tools.cct.core.services.dao.tasks;

import ru.kpfu.tools.cct.core.services.dao.jdbc.utils.ParamsMapper;
import ru.kpfu.tools.cct.core.services.dao.jdbc.utils.ParamsMapperImpl;
import ru.kpfu.tools.cct.core.services.models.Task;

import java.net.URL;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class TasksDaoData {

    private static ParamsMapper paramsMapper = new ParamsMapperImpl();

    public static final int USER_1_ID = 0;
    public static final int USER_2_ID = 1;

    public static final Task TASK_1 = new Task(0, 0, "simple_task", 0, getURL("file://instructions.pdf"));

    public static final Task TASK_2 = new Task(1, 0, "simple_task_2", 0, getURL("file://instructions_2.pdf"));

    public static final List<Task> TASKS = asList(TASK_1, TASK_2);

    public static final Map<String, Object> PARAMS_TASK = paramsMapper.asMap(asList("taskId"), asList(TASK_1.getId()));

    public static final Map<String, Object> PARAMS_TASK_AND_USER = paramsMapper.asMap(asList("userId","taskId"),
            asList(USER_1_ID, TASK_1.getId()));

    private static URL getURL(String url) {
        try {
            return new URL(url);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }


}
