package lk.ijse.springstudentmanagementmvc.service;

import lk.ijse.springstudentmanagementmvc.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> saveStudent(StudentDTO studentDTO);

    StudentDTO getStudent(String id);

    List<StudentDTO> getAllStudents();

    boolean deleteStudent(String id);
}
