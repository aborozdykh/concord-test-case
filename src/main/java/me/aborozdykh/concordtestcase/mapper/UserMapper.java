package me.aborozdykh.concordtestcase.mapper;

import lombok.AllArgsConstructor;
import me.aborozdykh.concordtestcase.dto.UserCreateDto;
import me.aborozdykh.concordtestcase.dto.UserResponseDto;
import me.aborozdykh.concordtestcase.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author Andrii Borozdykh
 */

@Component
@AllArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;

    public User mapToUser(UserResponseDto userResponseDto) {
        return modelMapper.map(userResponseDto, User.class);
    }

    public User mapToUser(UserCreateDto userCreateDto) {
        return modelMapper.map(userCreateDto, User.class);
    }

    public UserResponseDto mapToDto(User user) {
        if (user == null) {
            return null;
        }
        return modelMapper.map(user, UserResponseDto.class);
    }
}
