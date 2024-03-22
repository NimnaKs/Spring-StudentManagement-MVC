package lk.ijse.springstudentmanagementmvc.controller;

import lk.ijse.springstudentmanagementmvc.conversion.ConversionData;
import lk.ijse.springstudentmanagementmvc.service.TeacherService;
import lk.ijse.springstudentmanagementmvc.service.TeacherServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/teacher")
public class Teacher {
    @Autowired
    TeacherService teacherService;

    @Autowired
    ConversionData conversionData;

    @GetMapping("/status")
    public String CheckTeacherStatus(){
        return "Teacher Available";
    }

    @PostMapping

}
