package me.aborozdykh.concordtestcase.service;

import java.util.Optional;
import lombok.AllArgsConstructor;
import me.aborozdykh.concordtestcase.entity.User;
import me.aborozdykh.concordtestcase.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author Andrii Borozdykh
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).isPresent() ? userRepository.findById(id).get() : null;
    }
}
