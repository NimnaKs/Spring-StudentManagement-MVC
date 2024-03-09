package lk.ijse.springstudentmanagementmvc.repository;

import lk.ijse.springstudentmanagementmvc.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<StudentEntity,String> {
}
