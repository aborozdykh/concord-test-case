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
public class UserRequestDto {

    @NotNull
    private int id;
}
