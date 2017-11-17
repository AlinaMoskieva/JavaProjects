package ru.kpfu.tools.cct.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.tools.cct.core.services.models.User;

/**
 * @author Sidikov Marsel (Kazan Federal University)
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(String email) {
        User user = new User();
        user.setEmail(email);
        user.setFirstName("Marsel");
        user.setLastName("Sidikov");
        user.setPassword("1234");
        return user;
    }
}
