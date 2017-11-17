package ru.kpfu.tools.cct.core.services.dao;

import org.springframework.stereotype.Repository;
import ru.kpfu.tools.cct.core.services.models.Precedent;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
@Repository
public class PrecedentsDaoJdbcImpl implements PrecedentsDao {
    @Override
    public void sendPrecedent(int userId, int taskId, Precedent precedent) {

    }
}
