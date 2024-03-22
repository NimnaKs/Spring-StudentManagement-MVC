package lk.ijse.springstudentmanagementmvc.conversion;

import lk.ijse.springstudentmanagementmvc.dto.StudentDTO;
import lk.ijse.springstudentmanagementmvc.dto.TeacherDTO;
import lk.ijse.springstudentmanagementmvc.entity.StudentEntity;
import lk.ijse.springstudentmanagementmvc.entity.TeacherEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConversionData {
    final private ModelMapper modelMapper;

    public ConversionData(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //Student Obj mapping
    public StudentDTO convertToStudentDTO(StudentEntity student){
       return modelMapper.map(student,StudentDTO.class);
    }

    public StudentEntity convertToStudentEntity(StudentDTO student){
        return modelMapper.map(student,StudentEntity.class);
    }

    public List<StudentDTO> getStudentDTOList(List<StudentEntity> studentEntities){
        return modelMapper.map(studentEntities,List.class);
    }

    public List<StudentEntity> getStudentEntityList(List<StudentEntity> studentDtos){
        return modelMapper.map(studentDtos,List.class);
    }

    public TeacherDTO convertToTeacherEntity(TeacherDTO teacherDTO){
        return modelMapper.map(teacherDTO, TeacherDTO.class);
    }

    public TeacherEntity convertToTeacherDto(TeacherEntity teacherEntity){
        return modelMapper.map(teacherEntity, TeacherEntity.class);
    }

    public List<StudentEntity> getStudentEntityList(ArrayList<StudentDTO> studentDTOS){
        return modelMapper.map(studentDTOS, List.class);
    }

    public  List<StudentDTO> getStudentDtoList(ArrayList<StudentEntity> studentEntities){
        return modelMapper.map(studentEntities, List.class);
    }
}
