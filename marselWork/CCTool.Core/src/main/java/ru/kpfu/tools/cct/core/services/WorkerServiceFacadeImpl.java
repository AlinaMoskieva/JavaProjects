package ru.kpfu.tools.cct.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.tools.cct.core.services.dao.tasks.TasksDao;
import ru.kpfu.tools.cct.core.services.models.Precedent;
import ru.kpfu.tools.cct.core.services.models.Task;
import ru.kpfu.tools.cct.core.services.dao.documents.DocumentsDao;
import ru.kpfu.tools.cct.core.services.dao.PrecedentsDao;
import ru.kpfu.tools.cct.core.services.models.Document;

import java.util.List;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
@Service
public class WorkerServiceFacadeImpl implements WorkerServiceFacade {

    @Autowired
    TasksDao tasksDao;

    @Autowired
    DocumentsDao documentsDao;

    @Autowired
    PrecedentsDao precedentsDao;

    @Override
    public List<Task> getAvailableTasks() {
        return tasksDao.getAvailableTasks();
    }

    @Override
    public Task getTask(int taskId) {
        return tasksDao.getTask(taskId);
    }

    @Override
    public void taskAssign(int userId, int taskId) {
        tasksDao.taskAssign(userId, taskId);
    }

    @Override
    public List<Document> getDocuments(int taskId) {
        return documentsDao.getDocuments(taskId);
    }

    @Override
    public Document getDocument(int documentId) {
        return documentsDao.getDocument(documentId);
    }

    @Override
    public void complaintToTask(int userId, int taskId, String description) {
        tasksDao.complaintToTask(userId, taskId, description);
    }

    @Override
    public void postponeDocument(int userId, int documentId) {
        documentsDao.postponeDocument(userId, documentId);
    }

    @Override
    public void sendPrecedent(int userId, int taskId, Precedent precedent) {
        precedentsDao.sendPrecedent(userId, taskId, precedent);
    }

    @Override
    public List<Document> getPostponedDocuments(int userId, int taskId) {
        return documentsDao.getPostponedDocuments(userId, taskId);
    }

    @Override
    public void finishTask(int userId, int taskId) {
        tasksDao.finishTask(userId, taskId);
    }
}
