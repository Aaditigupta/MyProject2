package com.mindtree.departmentemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.departmentemp.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
