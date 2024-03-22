package lk.ijse.springstudentmanagementmvc.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class StudentDTO implements SuperDTO{
    @Null(message = "Generate by program")
    private String id;
    @NotNull(message = "First Name cannot be null")
    private String firstName;
    @NotNull(message = "Last Name cannot be null")
    private String lastName;
    @NotNull(message = "Level cannot be null")
    private String level;
    @NotNull(message = "Propic cannot be null")
    private String proPic;

}
