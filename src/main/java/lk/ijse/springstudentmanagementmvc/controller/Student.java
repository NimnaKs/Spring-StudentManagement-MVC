package lk.ijse.springstudentmanagementmvc.controller;

import jakarta.validation.Valid;
import lk.ijse.springstudentmanagementmvc.dto.StudentDTO;
import lk.ijse.springstudentmanagementmvc.service.StudentService;
import lk.ijse.springstudentmanagementmvc.service.StudentServiceIMPL;
import lk.ijse.springstudentmanagementmvc.util.UtilMatters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/student")
public class Student {

    @Autowired
    StudentService studentService;

    @GetMapping("/health")
    public String healthCheckStudent(){
        return "Health Check Student";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void saveStudent(@Valid
                                @RequestPart ("firstName") String firstName,
                                @RequestPart ("lastName") String lastName,
                                @RequestPart ("level") String level,
                                @RequestPart ("proPic") String proPic,
                                Errors errors) {
        if (errors.hasFieldErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    errors.getFieldErrors().get(0).getDefaultMessage());
        }

        //Build Base64 image
        String base64Propic = UtilMatters.convertBase64(proPic);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFirstName(firstName);
        studentDTO.setLastName(lastName);
        studentDTO.setLevel(level);
        studentDTO.setProPic(base64Propic);

        studentService.saveStudent(studentDTO);

    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity</*Map<String,Object>*/StudentDTO> getStudent(@PathVariable ("id") String id){
        StudentDTO selectedStudent = studentService.getStudent(id);
        System.out.println(selectedStudent);
        return selectedStudent != null ? ResponseEntity.ok(selectedStudent) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity</*Map<String,Object>*/List<StudentDTO>> getAllStudent(){
        List<StudentDTO> allStudents = studentService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable ("id") String id){
        studentService.deleteStudent(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateStudent(@PathVariable ("id") String id,@Valid
                                  @RequestPart ("firstName") String firstName,
                                  @RequestPart ("lastName") String lastName,
                                  @RequestPart ("level") String level,
                                  @RequestPart ("proPic") String proPic,
                                  Errors errors) {
        String base64UpdatePropic = UtilMatters.convertBase64(proPic);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFirstName(firstName);
        studentDTO.setLastName(lastName);
        studentDTO.setLevel(level);
        studentDTO.setProPic(base64UpdatePropic);

        studentService.updateStudent(id , studentDTO);

    }
}
