package ru.kpfu.tools.cct.core.services.dao;

import ru.kpfu.tools.cct.core.services.models.Precedent;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
public interface PrecedentsDao {
    void sendPrecedent(int userId, int taskId, Precedent precedent);
}
