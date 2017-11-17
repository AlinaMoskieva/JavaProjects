package ru.kpfu.tools.cct.core.services.dao.jdbc.utils;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.Map;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
public interface SqlQueryExecutor {
    <T> List<T> queryForObjects(String sql, RowMapper<T> rowMapper);
    <T> List<T> queryForObjects(String sql, Map<String, Object> paramMap, RowMapper<T> rowMapper);
    <T> T queryForObject(String sql, Map<String, Object> paramMap, RowMapper<T> rowMapper);
    void updateQuery(String sql, Map<String, Object> paramMap);
    int queryForInt(String sql, Map<String, Object> paramMap);
    int queryForInt(String sql);
}
