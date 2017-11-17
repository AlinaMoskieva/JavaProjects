package ru.kpfu.tools.cct.core.services.dao.jdbc.utils;

import java.util.List;
import java.util.Map;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
public interface ParamsMapper {
    Map<String, Object> asMap(List<String> keys, List<?> values);
}
