package me.aborozdykh.concordtestcase.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Andrii Borozdykh
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Override
    public String toString() {
        return "UserCreateDto{"
                + "firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + '}';
    }
}
