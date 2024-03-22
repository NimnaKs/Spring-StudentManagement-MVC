package lk.ijse.springstudentmanagementmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class TeacherEntity implements SuperEntity{
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Double salary;
    private String address;
    private LocalDate joinDate;

    @Column(columnDefinition = "LONGTEXT")
    private String proPic;
}
