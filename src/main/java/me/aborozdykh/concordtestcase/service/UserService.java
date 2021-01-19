package me.aborozdykh.concordtestcase.service;

import java.util.Optional;
import me.aborozdykh.concordtestcase.entity.User;

/**
 * @author Andrii Borozdykh
 */
public interface UserService {

    User add(User user);

    User getUserById(int id);
}
