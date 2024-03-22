package lk.ijse.springstudentmanagementmvc.service;

import jakarta.transaction.Transactional;
import lk.ijse.springstudentmanagementmvc.dto.TeacherDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class TeacherServiceIMPL implements TeacherService{
    @Override
    public void saveTeacher(TeacherDTO teacherDTO) {

    }

    @Override
    public TeacherDTO getTeacher(String id) {
        return null;
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return null;
    }

    @Override
    public void deleteTeacher(String id) {

    }

    @Override
    public void updateTeacher(String id, TeacherDTO teacherDTO) {

    }
}
