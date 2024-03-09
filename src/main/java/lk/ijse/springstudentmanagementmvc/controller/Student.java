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
    public void saveStudent(@Valid @RequestBody StudentDTO studentDTO, Errors errors){
        if(errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    errors.getFieldErrors().get(0).getDefaultMessage());
        }
        studentService.saveStudent(studentDTO);
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity</*Map<String,Object>*/StudentDTO> getStudent(@PathVariable ("id") String id){
        StudentDTO selectedStudent = studentService.getStudent(id);
        System.out.println(selectedStudent);
        /*Map<String,Object> response = new HashMap<>();
        if (student != null) {
            response.put("message", "Student Found");
            response.put("student", student);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Student Not Found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }*/

        return selectedStudent != null ? ResponseEntity.ok(selectedStudent) : ResponseEntity.noContent().build();
    }

    @GetMapping(produces = "application/json")
    public void getAllStudent(){
        List<StudentDTO> allStudents = studentService.getAllStudents();
        System.out.println(allStudents);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id:^S\\d{3}$}")
    public void deleteStudent(@PathVariable ("id") String id){
        boolean isDeleted = studentService.deleteStudent(id);
        if(isDeleted) {
            System.out.println("Student " + id + " is deleted.");
        }else{
            System.out.println("Delete unsuccessful !");
        }
    }
}
