package lk.ijse.springstudentmanagementmvc.service;

import jakarta.transaction.Transactional;
import lk.ijse.springstudentmanagementmvc.dto.StudentDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class StudentServiceIMPL implements StudentService{

    List<StudentDTO> studentDTOS = new ArrayList<>();
    @Override
    public List<StudentDTO> saveStudent(StudentDTO studentDTO) {
        studentDTOS.add(studentDTO);
        System.out.println(studentDTO);
        return studentDTOS;
    }

    @Override
    public StudentDTO getStudent(String id) {
        for (StudentDTO selectedStudent:studentDTOS) {
            if(selectedStudent.getId().equals(id)){
                return selectedStudent;
            }
        }
        return null;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentDTOS;
    }

    @Override
    public boolean deleteStudent(String id) {
        Iterator<StudentDTO> iterator = studentDTOS.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
