package com.mindtree.departmentemp.service;

import java.util.List;

import com.mindtree.departmentemp.dto.DepartmentDTO;
import com.mindtree.departmentemp.exceptionhandler.service.DepartmentServiceException;

public interface DeptEmp {

	String sendDetailsToService(DepartmentDTO department);

	List<DepartmentDTO> getAllDetails() throws DepartmentServiceException;

}
