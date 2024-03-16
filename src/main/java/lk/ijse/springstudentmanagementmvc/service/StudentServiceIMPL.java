package lk.ijse.springstudentmanagementmvc.service;

import jakarta.transaction.Transactional;
import lk.ijse.springstudentmanagementmvc.conversion.ConversionData;
import lk.ijse.springstudentmanagementmvc.dto.StudentDTO;
import lk.ijse.springstudentmanagementmvc.entity.StudentEntity;
import lk.ijse.springstudentmanagementmvc.exception.NotFoundException;
import lk.ijse.springstudentmanagementmvc.repository.StudentDao;
import lk.ijse.springstudentmanagementmvc.util.UtilMatters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceIMPL implements StudentService{
    
    @Autowired
    private StudentDao studentDao;
    
    @Autowired
    private ConversionData convert;

    @Override
    public boolean saveStudent(StudentDTO studentDTO) {
        studentDTO.setId(UtilMatters.generateId());
        StudentEntity studentEntity = convert.convertToStudentEntity(studentDTO);
        StudentEntity saveEntity = studentDao.save(studentEntity);
        return saveEntity.getId().equals(studentDTO.getId());
    }

    @Override
    public StudentDTO getStudent(String id) {
        if (studentDao.existsById(id)){
            return convert.convertToStudentDTO(studentDao.getReferenceById(id));
        }else{
            throw new NotFoundException("Student Not Found");
        }
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return convert.getStudentDTOList(studentDao.findAll());
    }

    @Override
    public boolean deleteStudent(String id) {
        if (studentDao.existsById(id)) {
            studentDao.deleteById(id);
            return !studentDao.existsById(id);
        }else{
            throw new NotFoundException("Student Id Not Exists");
        }
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) {
        StudentEntity studentEntity = convert.convertToStudentEntity(studentDTO);
        studentDao.flush();
        return true;
    }
}
