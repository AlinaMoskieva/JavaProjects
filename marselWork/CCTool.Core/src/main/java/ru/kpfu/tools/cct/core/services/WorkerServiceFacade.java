package ru.kpfu.tools.cct.core.services;

import ru.kpfu.tools.cct.core.services.models.Document;
import ru.kpfu.tools.cct.core.services.models.Precedent;
import ru.kpfu.tools.cct.core.services.models.Task;

import java.util.List;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
public interface WorkerServiceFacade {

    List<Task> getAvailableTasks();

    Task getTask(int taskId);

    void taskAssign(int userId, int taskId);

    List<Document> getDocuments(int taskId);

    Document getDocument(int documentId);

    void complaintToTask(int userId, int taskId, String description);

    void postponeDocument(int userId, int documentId);

    void sendPrecedent(int userId, int taskId, Precedent precedent);

    List<Document> getPostponedDocuments(int userId, int taskId);

    void finishTask(int userId, int taskId);
}
