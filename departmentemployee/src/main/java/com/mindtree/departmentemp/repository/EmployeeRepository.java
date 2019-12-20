package com.mindtree.departmentemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.departmentemp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//	@Query(value = "Select * from employee where count(salary)>5000000", nativeQuery = true)
//	List<Employee> countemp();
}
//department_dept_id