package ru.kpfu.tools.cct.core.services.dao.tasks;


import com.google.common.collect.Lists;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import ru.kpfu.tools.cct.core.services.AppContext;
import ru.kpfu.tools.cct.core.services.dao.IntegrationTestAppContext;
import ru.kpfu.tools.cct.core.services.exceptions.*;
import ru.kpfu.tools.cct.core.services.models.Task;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static ru.kpfu.tools.cct.core.services.dao.tasks.TasksDaoData.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppContext.class, IntegrationTestAppContext.class})
public class TasksDaoIntegrationImplTest {
/*
    @Autowired
    private TasksDaoJdbcImpl tasksDao;

    @Test
    public void testGetAvailableTasks() {
        List<Task> actual = tasksDao.getAvailableTasks();
        List<Task> expected = Lists.newArrayList(TASK_1, TASK_2);
        assertThat(actual, is(expected));
    }

    @Test
    public void testGetTask() throws Exception {
        Task actual = tasksDao.getTask(0);
        Task expected = TASK_1;
        assertEquals(actual, expected);
    }

    @Test (expected = TaskNotFoundException.class)
    public void testGetTaskForIncorrectTaskId() throws Exception {
        tasksDao.getTask(2);
    }

    @Test
    public void testTaskAssign() {
        tasksDao.taskAssign(0, 1);
        int actual = tasksDao.sqlQueryExecutor.queryForInt(
                "SELECT COUNT(*) FROM task_assignments WHERE (user_id = 0 AND task_id = 1)");
        assertThat(actual, is(1));
    }

    @Test (expected = UserNotFoundException.class)
    public void testTaskAssignForIncorrectUserId() {
        tasksDao.taskAssign(4, 1);
    }

    @Test (expected = TaskNotFoundException.class)
    public void testTaskAssignForIncorrectTaskId() {
        tasksDao.taskAssign(0, 10);
    }

    @Test (expected = HasUncompletedTasksException.class)
    public void testTaskAssignForIncorrectAssignment() {
        tasksDao.taskAssign(0,1);
        tasksDao.taskAssign(0,1);
    }

    @Test
    public void testComplaintToTask() {
        tasksDao.complaintToTask(1,1,"bad task");
        int actual = tasksDao.sqlQueryExecutor.queryForInt(
                "SELECT COUNT(*) FROM complaints WHERE (user_id = 1 AND task_id = 1 AND description = 'bad task')");

        assertThat(actual, is(1));
    }

    @Test(expected = TaskNotFoundException.class)
    public void testComplaintToTaskForIncorrectTaskId() {
        tasksDao.complaintToTask(1,10, "bad task");
    }

    @Test (expected = UserNotFoundException.class)
    public void testComplaintToTaskForIncorrectUserId() {
        tasksDao.complaintToTask(10, 1, "bad task");
    }

    @Test (expected = TaskNotAssignedToUserException.class)
    public void testComplaintToTaskForIncorrectAssignment() {
        tasksDao.complaintToTask(0, 1, "bad task");
    }

    @Test
    public void testFinishTask() {
        tasksDao.finishTask(1,1);
        int actual = tasksDao.sqlQueryExecutor.queryForInt(
                "SELECT COUNT (*) FROM completed_tasks WHERE (user_id = 1 AND task_id = 1)");
        assertThat(actual, is(1));
    }

    @Test (expected = UserNotFoundException.class)
    public void testFinishTaskForIncorrectUserId() {
        tasksDao.finishTask(10,1);
    }

    @Test (expected = TaskNotFoundException.class)
    public void testFinishTaskForIncorrectTaskId() {
        tasksDao.finishTask(1,10);
    }

    @Test (expected = TaskNotAssignedToUserException.class)
    public void testFinishTaskForIncorrectAssignments() {
        tasksDao.finishTask(0,1);
    }

    @Test (expected = TaskAlreadyCompletedByUserException.class)
    public void testFinishTaskSecond() {
        tasksDao.finishTask(1,1);
        tasksDao.finishTask(1,1);
    }
    */
}