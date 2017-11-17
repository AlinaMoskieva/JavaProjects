package ru.kpfu.tools.cct.core.services.dao.documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.tools.cct.core.services.dao.DaoArgumentsVerifier;
import ru.kpfu.tools.cct.core.services.dao.jdbc.utils.ParamsMapper;
import ru.kpfu.tools.cct.core.services.dao.jdbc.utils.SqlQueryExecutor;
import ru.kpfu.tools.cct.core.services.models.Document;

import org.springframework.jdbc.core.RowMapper;

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
public class DocumentsDaoJdbcImpl implements DocumentsDao {

    @Autowired
    DaoArgumentsVerifier verifier;

    @Autowired
    ParamsMapper paramsMapper;

    @Autowired
    SqlQueryExecutor sqlQueryExecutor;

    //language=SQL
    private static final String SQL_GET_DOCUMENTS_OF_TASK =
            "SELECT * FROM documents WHERE (task_id = :taskId)";

    //language=SQL
    private static final String SQL_GET_DOCUMENT_BY_ID = "SELECT * FROM documents WHERE (id = :documentId)";

    private final RowMapper<Document> DOCUMENT_ROW_MAPPER = new RowMapper<Document>() {
        @Override
        public Document mapRow(ResultSet resultSet, int i) throws SQLException {
            try {
                return new Document(resultSet.getInt("id"),resultSet.getInt("task_id"),resultSet.getString("file_name"),
                        resultSet.getString("type"), resultSet.getString("folder_name"), resultSet.getInt("size"),
                        new URL(resultSet.getString("url")));
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException(e);
            }
        }
    };

    @Override
    public List<Document> getDocuments(int taskId) {
        verifier.verifyTask(taskId);
        Map<String, Object> paramMap = paramsMapper.asMap(asList("taskId"), asList(taskId));
        return sqlQueryExecutor.queryForObjects(SQL_GET_DOCUMENTS_OF_TASK, paramMap, DOCUMENT_ROW_MAPPER);
    }

    @Override
    public Document getDocument(int documentId) {
        verifier.verifyDocument(documentId);
        Map<String, Object> paramMap = paramsMapper.asMap(asList("documentId"), asList(documentId));
        return sqlQueryExecutor.queryForObject(SQL_GET_DOCUMENT_BY_ID, paramMap, DOCUMENT_ROW_MAPPER);
    }

    @Override
    public void postponeDocument(int userId, int documentId) {

    }

    @Override
    public List<Document> getPostponedDocuments(int userId, int taskId) {
        return null;
    }
}
