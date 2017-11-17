ipackage ru.kpfu.tools.cct.core.services.dao;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
public interface DaoArgumentsVerifier {
    public void verifyUser(int userId);
    public void verifyTask(int taskId);
    public void verifyAssignment(int userId, int taskId);
    public void verifyUncompletedTasksByUser(int userId);
    public void verifyAlreadyCompletedTask(int user, int task);
    public void verifyDocument(int documentId);
}
