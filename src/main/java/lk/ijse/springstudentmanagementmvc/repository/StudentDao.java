package lk.ijse.springstudentmanagementmvc.repository;

import lk.ijse.springstudentmanagementmvc.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<StudentEntity,String> {
}
