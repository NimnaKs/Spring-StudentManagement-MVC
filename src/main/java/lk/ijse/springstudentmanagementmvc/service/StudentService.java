package lk.ijse.springstudentmanagementmvc.service;

import lk.ijse.springstudentmanagementmvc.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    boolean saveStudent(StudentDTO studentDTO);

    StudentDTO getStudent(String id);

    List<StudentDTO> getAllStudents();

    void deleteStudent(String id);

    void updateStudent(StudentDTO studentDTO);
}
