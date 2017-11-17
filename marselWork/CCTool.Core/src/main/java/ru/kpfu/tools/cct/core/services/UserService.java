package ru.kpfu.tools.cct.core.services;

import ru.kpfu.tools.cct.core.services.models.User;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
public interface UserService {
    User getUser(String email);
}
