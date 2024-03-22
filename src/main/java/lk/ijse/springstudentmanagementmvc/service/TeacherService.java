package lk.ijse.springstudentmanagementmvc.service;

import lk.ijse.springstudentmanagementmvc.dto.StudentDTO;
import lk.ijse.springstudentmanagementmvc.dto.TeacherDTO;

import java.util.List;

public interface TeacherService{
    void saveTeacher(TeacherDTO teacherDTO);
    TeacherDTO getTeacher(String id);
    List<TeacherDTO> getAllTeachers();
    void deleteTeacher(String id);
    void updateTeacher(String id,TeacherDTO teacherDTO);
}
