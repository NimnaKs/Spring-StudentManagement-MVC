package lk.ijse.springstudentmanagementmvc.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentDTO implements SuperDTO{
//    @NotNull(message = "Id cannot be null")
    private String id;
    @NotNull(message = "First Name cannot be null")
    private String firstName;
    @NotNull(message = "Last Name cannot be null")
    private String lastName;
    @NotNull(message = "Level cannot be null")
    private String level;

}
