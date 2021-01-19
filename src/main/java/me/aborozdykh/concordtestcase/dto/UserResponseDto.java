package me.aborozdykh.concordtestcase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Andrii Borozdykh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private String firstName;
    private String lastName;
}
