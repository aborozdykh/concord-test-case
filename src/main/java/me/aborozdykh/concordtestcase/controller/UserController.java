package me.aborozdykh.concordtestcase.controller;

import javax.validation.Valid;
import lombok.AllArgsConstructor;
import me.aborozdykh.concordtestcase.dto.UserCreateDto;
import me.aborozdykh.concordtestcase.dto.UserRequestDto;
import me.aborozdykh.concordtestcase.dto.UserResponseDto;
import me.aborozdykh.concordtestcase.entity.User;
import me.aborozdykh.concordtestcase.mapper.UserMapper;
import me.aborozdykh.concordtestcase.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Andrii Borozdykh
 */

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<Integer> addUser(@Valid @RequestBody UserCreateDto userCreateDto) {
        LOGGER.info("Adding user with information: {}", userCreateDto);
        User user = userMapper.mapToUser(userCreateDto);
        User userDb = userService.add(user);
        LOGGER.info("User was added with information: {}", userDb);
        return ResponseEntity.ok(userDb.getId());
    }

    @PostMapping("/user")
    public UserResponseDto getUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        LOGGER.info("Request user by id with information: {}", userRequestDto);
        int id = userRequestDto.getId();
        User userById = userService.getUserById(id);
        UserResponseDto userResponseDto = userMapper.mapToDto(userById);
        LOGGER.info("The user was retrieved from the database with information: {}",
                    userResponseDto);
        return userResponseDto;
    }
}
