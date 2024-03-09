package lk.ijse.springstudentmanagementmvc.conversion;

import lk.ijse.springstudentmanagementmvc.dto.StudentDTO;
import lk.ijse.springstudentmanagementmvc.entity.StudentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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
}
