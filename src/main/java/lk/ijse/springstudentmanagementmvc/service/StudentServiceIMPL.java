package lk.ijse.springstudentmanagementmvc.service;

import jakarta.transaction.Transactional;
import lk.ijse.springstudentmanagementmvc.conversion.ConversionData;
import lk.ijse.springstudentmanagementmvc.dto.StudentDTO;
import lk.ijse.springstudentmanagementmvc.entity.StudentEntity;
import lk.ijse.springstudentmanagementmvc.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class StudentServiceIMPL implements StudentService{
    
    @Autowired
    private StudentDao studentDao;
    
    @Autowired
    private ConversionData convert;

    @Override
    public boolean saveStudent(StudentDTO studentDTO) {
        StudentEntity studentEntity = convert.convertToStudentEntity(studentDTO);
        studentDao.save(studentEntity)
        return false;
    }

    @Override
    public StudentDTO getStudent(String id) {
        return null;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return null;
    }

    @Override
    public boolean deleteStudent(String id) {
        return false;
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) {
        return false;
    }
}
