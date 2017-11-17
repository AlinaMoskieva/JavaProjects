package ru.kpfu.tools.cct.core.services.dao.tasks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import ru.kpfu.tools.cct.core.services.dao.DaoArgumentsVerifier;
import ru.kpfu.tools.cct.core.services.dao.jdbc.utils.ParamsMapper;
import ru.kpfu.tools.cct.core.services.dao.jdbc.utils.SqlQueryExecutor;
import ru.kpfu.tools.cct.core.services.exceptions.TaskNotAssignedToUserException;
import ru.kpfu.tools.cct.core.services.exceptions.TaskNotFoundException;
import ru.kpfu.tools.cct.core.services.exceptions.UserNotFoundException;
import ru.kpfu.tools.cct.core.services.models.Task;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static ru.kpfu.tools.cct.core.services.dao.tasks.TasksDaoJdbcImpl.*;
import static ru.kpfu.tools.cct.core.services.dao.tasks.TasksDaoData.*;

public class TasksDaoJdbcImplTest {

    private TasksDaoJdbcImpl tasksDao;

    @Mock
    DaoArgumentsVerifier verifier;

    @Mock
    SqlQueryExecutor sqlQueryExecutor;

    @Mock
    ParamsMapper paramsMapper;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        stubbing();
        buildTaskDao();
    }

    private void stubbing() {
        stubbingSqlQueryExecutor();
        stubbingParamsMapper();
        stubbingVerifier();
    }

    private void stubbingSqlQueryExecutor() {
        doReturn(TASKS).when(sqlQueryExecutor).queryForObjects(SQL_GET_TASKS, TASK_ROW_MAPPER);
        doReturn(TASK_1).when(sqlQueryExecutor).queryForObject(SQL_GET_TASK_BY_ID, PARAMS_TASK, TASK_ROW_MAPPER);
    }

    private void stubbingParamsMapper() {
        doReturn(PARAMS_TASK).when(paramsMapper).asMap(asList("taskId"), asList(TASK_1.getId()));
        doReturn(PARAMS_TASK_AND_USER).when(paramsMapper).asMap(asList("userId", "taskId"), asList(USER_1_ID, TASK_1.getId()));
    }

    private void stubbingVerifier() {
        doThrow(TaskNotFoundException.class).when(verifier).verifyTask(anyInt());
        doThrow(TaskNotAssignedToUserException.class).when(verifier).verifyAssignment(anyInt(), anyInt());
        doThrow(UserNotFoundException.class).when(verifier).verifyUncompletedTasksByUser(anyInt());
        doThrow(TaskNotAssignedToUserException.class).when(verifier).verifyUncompletedTasksByUser(USER_2_ID);
        doNothing().when(verifier).verifyTask(TASK_1.getId());
        doNothing().when(verifier).verifyUncompletedTasksByUser(USER_1_ID);
    }

    private void buildTaskDao() {
        tasksDao = TasksDaoJdbcImpl.build(verifier, paramsMapper, sqlQueryExecutor);
    }

    @Test
    public void testGetAvailableTasks() throws Exception {
        List<Task> actual = tasksDao.getAvailableTasks();
        List<Task> expected = TASKS;

        assertThat(actual, is(expected));
    }

    @Test
    public void testGetTask() throws Exception {
        Task actual = tasksDao.getTask(TASK_1.getId());
        Task expected = TASK_1;

        assertEquals(expected, actual);
    }

    @Test (expected = TaskNotFoundException.class)
    public void testGetTaskForIncorrectId() throws Exception {
        tasksDao.getTask(2);
    }

    @Test
    public void testTaskAssign() {
        tasksDao.taskAssign(USER_1_ID, TASK_1.getId());

        verify(verifier).verifyUncompletedTasksByUser(USER_1_ID);
        verify(verifier).verifyTask(TASK_1.getId());
    }

    @Test (expected = UserNotFoundException.class)
    public void testTaskAssignForIncorrectUserId() {
        tasksDao.taskAssign(2, TASK_1.getId());
    }

    @Test (expected = TaskNotAssignedToUserException.class)
    public void testTaskAssignForUnassignedUser() {
        tasksDao.taskAssign(USER_2_ID, TASK_1.getId());
    }

    @Test (expected = TaskNotFoundException.class)
    public void testTaskAssignForIncorrectTask() {
        tasksDao.taskAssign(USER_1_ID, 3);
    }
}