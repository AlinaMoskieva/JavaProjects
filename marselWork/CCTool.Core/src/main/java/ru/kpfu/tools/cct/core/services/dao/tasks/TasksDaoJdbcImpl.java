package ru.kpfu.tools.cct.core.services.dao.tasks;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Repository;
 import org.springframework.jdbc.core.RowMapper;
 import ru.kpfu.tools.cct.core.services.dao.DaoArgumentsVerifier;
 import ru.kpfu.tools.cct.core.services.dao.jdbc.utils.ParamsMapper;
 import ru.kpfu.tools.cct.core.services.dao.jdbc.utils.SqlQueryExecutor;
 import ru.kpfu.tools.cct.core.services.exceptions.*;
 import ru.kpfu.tools.cct.core.services.models.Task;

 import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import static java.util.Arrays.asList;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
@Repository
public class TasksDaoJdbcImpl implements TasksDao {

    @Autowired
    private DaoArgumentsVerifier verifier;

    @Autowired
    private ParamsMapper paramsMapper;

    @Autowired
    private SqlQueryExecutor sqlQueryExecutor;

    static TasksDaoJdbcImpl build(DaoArgumentsVerifier verifier, ParamsMapper paramsMapper, SqlQueryExecutor
            sqlQueryExecutor) {
        TasksDaoJdbcImpl result = new TasksDaoJdbcImpl();

        result.verifier = verifier;
        result.paramsMapper = paramsMapper;
        result.sqlQueryExecutor = sqlQueryExecutor;

        return result;
    }

    static final String SQL_GET_TASKS =
            "SELECT * FROM tasks";

    static final String SQL_GET_TASK_BY_ID =
            "SELECT * FROM tasks WHERE (id = :taskId)";

    static final String SQL_INSERT_TASK_ASSIGNMENT =
            "INSERT INTO task_assignments VALUES (:userId, :taskId)";

    static final String SQL_INSERT_INTO_COMPLAINTS =
            "INSERT INTO complaints VALUES (:userId, :taskId, :description)";

    static final String SQL_INSERT_INTO_COMPLETED =
            "INSERT INTO  completed_tasks VALUES (:taskId, :userId)";

    static final String SQL_DELETE_FROM_ASSIGNMENTS_BY_IDS =
            "DELETE FROM task_assignments WHERE (user_id = :userId AND task_id = :taskId)";


    static final RowMapper<Task> TASK_ROW_MAPPER = new RowMapper<Task>() {
        @Override
        public Task mapRow(ResultSet resultSet, int i) throws SQLException {
            try {
                return new Task(resultSet.getInt("id"), resultSet.getInt("author_id"), resultSet.getString
                        ("description"), resultSet.getInt("attribute_domain_id"), new URL(resultSet.getString
                        ("instructions_file_url")));
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException(e);
            }
        }
    };

    @Override
    public List<Task> getAvailableTasks() {
        return sqlQueryExecutor.queryForObjects(SQL_GET_TASKS, TASK_ROW_MAPPER);
    }

    @Override
    public Task getTask(int taskId) {
        verifier.verifyTask(taskId);
        Map<String, Object> paramMap = paramsMapper.asMap(asList("taskId"), asList(taskId));
        return sqlQueryExecutor.queryForObject(SQL_GET_TASK_BY_ID, paramMap, TASK_ROW_MAPPER);
    }

    @Override
    public void taskAssign(int userId, int taskId) {
        verifier.verifyUncompletedTasksByUser(userId);
        verifier.verifyTask(taskId);
        Map<String, Object> paramMap = paramsMapper.asMap(asList("userId", "taskId"),asList(userId, taskId));
        sqlQueryExecutor.updateQuery(SQL_INSERT_TASK_ASSIGNMENT, paramMap);
    }

    @Override
    public void complaintToTask(int userId, int taskId, String description) {
        verifier.verifyAssignment(userId, taskId);
        Map<String, Object> paramMap = paramsMapper.asMap(asList("userId", "taskId", "description"), asList(userId,
                taskId, description));
        sqlQueryExecutor.updateQuery(SQL_INSERT_INTO_COMPLAINTS, paramMap);
    }

    @Override
    public void finishTask(int userId, int taskId) {
        verifier.verifyAlreadyCompletedTask(userId, taskId);
        verifier.verifyAssignment(userId, taskId);
        Map<String, Object> paramMap = paramsMapper.asMap(asList("userId", "taskId"), asList(userId, taskId));
        sqlQueryExecutor.updateQuery(SQL_INSERT_INTO_COMPLETED, paramMap);
        sqlQueryExecutor.updateQuery(SQL_DELETE_FROM_ASSIGNMENTS_BY_IDS, paramMap);
    }


}
