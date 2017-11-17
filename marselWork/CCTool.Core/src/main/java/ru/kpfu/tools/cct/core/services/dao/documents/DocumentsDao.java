package ru.kpfu.tools.cct.core.services.dao.documents;

import ru.kpfu.tools.cct.core.services.models.Document;

import java.util.List;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
public interface DocumentsDao {
    List<Document> getDocuments(int taskId);

    Document getDocument(int documentId);

    void postponeDocument(int userId, int documentId);

    List<Document> getPostponedDocuments(int userId, int taskId);
}
