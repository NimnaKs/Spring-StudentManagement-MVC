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
        return studentDao.save(convert.convertToStudentEntity(studentDTO)).getId().equals(studentDTO.getId());
    }

    @Override
    public StudentDTO getStudent(String id) {
        if (!studentDao.existsById(id)){throw new NotFoundException("Student Not Found");}
        return convert.convertToStudentDTO(studentDao.getReferenceById(id));
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return convert.getStudentDTOList(studentDao.findAll());
    }

    @Override
    public void deleteStudent(String id) {
        if (!studentDao.existsById(id)) { throw new NotFoundException("Student Id Not Exists");}
        studentDao.deleteById(id);
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {
        Optional<StudentEntity> tmpStudent = studentDao.findById(studentDTO.getId());
        if (tmpStudent.isEmpty()) throw new NotFoundException("Student Not Found");
        tmpStudent.get().setFirstName(studentDTO.getFirstName());
        tmpStudent.get().setLastName(studentDTO.getLastName());
        tmpStudent.get().setLevel(studentDTO.getLevel());
    }
}
