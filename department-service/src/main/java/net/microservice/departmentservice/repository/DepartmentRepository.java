package net.microservice.departmentservice.repository;

import net.microservice.departmentservice.dto.DepartmentDto;
import net.microservice.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findByDepartmentCode(String departmentCode);
}
