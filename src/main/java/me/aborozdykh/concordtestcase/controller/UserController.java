package me.aborozdykh.concordtestcase.controller;

import lombok.AllArgsConstructor;
import me.aborozdykh.concordtestcase.dto.UserCreateDto;
import me.aborozdykh.concordtestcase.dto.UserRequestDto;
import me.aborozdykh.concordtestcase.dto.UserResponseDto;
import me.aborozdykh.concordtestcase.entity.User;
import me.aborozdykh.concordtestcase.exception.UserNotFound;
import me.aborozdykh.concordtestcase.mapper.UserMapper;
import me.aborozdykh.concordtestcase.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author Andrii Borozdykh
 */

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<Integer> addUser(@Valid @RequestBody UserCreateDto userCreateDto) {
        User user = userMapper.mapToUser(userCreateDto);
        User userDb = userService.add(user);
        return ResponseEntity.ok(userDb.getId());
    }

    @PostMapping("/user")
    public UserResponseDto getUserByDto(@RequestBody @Valid UserRequestDto userRequestDto) {
        int id = userRequestDto.getId();
        User userById = userService.getUserById(id);
        return userMapper.mapToDto(userById);
    }
}
