package lk.ijse.springstudentmanagementmvc.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class TeacherDTO implements SuperDTO{
    @Null(message = "Generate by program")
    private String id;
    @NotNull(message = "First Name cannot be null")
    private String firstName;
    @NotNull(message = "Last Name cannot be null")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Salary cannot be null")
    @Positive(message = "Salary must be positive")
    private double salary;

    @NotBlank(message = "Address is required")
    @Size(max = 100, message = "Address must be less than 100 characters")
    private String address;

    @Past(message = "Join date must be in the past")
    private LocalDate joinDate;

    @NotNull(message = "Propic cannot be null")
    private String proPic;
}
