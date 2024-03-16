package lk.ijse.springstudentmanagementmvc.controller;

import jakarta.validation.Valid;
import lk.ijse.springstudentmanagementmvc.dto.StudentDTO;
import lk.ijse.springstudentmanagementmvc.service.StudentService;
import lk.ijse.springstudentmanagementmvc.service.StudentServiceIMPL;
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
    StudentService studentService=new StudentServiceIMPL();

    @GetMapping("/health")
    public String healthCheckStudent(){
        return "Health Check Student";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveStudent(@Valid @RequestBody StudentDTO studentDTO, Errors errors) {
        if (errors.hasFieldErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    errors.getFieldErrors().get(0).getDefaultMessage());
        }

        if (studentService.saveStudent(studentDTO)) {
            return ResponseEntity.ok("Successfully Saved");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Save Unsuccessful !");
        }
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
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@Valid @RequestBody StudentDTO studentDTO, Errors errors) {
        if (errors.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    errors.getAllErrors().get(0).getDefaultMessage());
        }else{
            studentService.updateStudent(studentDTO);
        }
    }
}
