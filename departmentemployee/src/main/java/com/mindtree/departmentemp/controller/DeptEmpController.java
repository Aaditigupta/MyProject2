package com.mindtree.departmentemp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.departmentemp.dto.DepartmentDTO;
import com.mindtree.departmentemp.exceptionhandler.DepartmentApplicationException;
import com.mindtree.departmentemp.service.DeptEmp;

@RestController
public class DeptEmpController {
	@Autowired
	DeptEmp deptservice;

	@PostMapping("/addDetails")
	public String sendDetails(@RequestBody DepartmentDTO department) {
		String isPosted=deptservice.sendDetailsToService(department);
		return isPosted;		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Map<String, Object>> getAllEmployees() throws DepartmentApplicationException{
		List<DepartmentDTO> deptsDto;
		 deptsDto=deptservice.getAllDetails();
		  Map<String, Object> response=new HashMap<String, Object>();
		     response.put("Message", "Department is present");
		     response.put("Status", HttpStatus.BAD_REQUEST);
		     response.put("Body", deptsDto);
		     response.put("Error", false);
		     return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
}
