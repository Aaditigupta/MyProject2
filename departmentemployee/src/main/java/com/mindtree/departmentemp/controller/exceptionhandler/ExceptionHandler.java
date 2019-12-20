package com.mindtree.departmentemp.controller.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.mindtree.departmentemp.exceptionhandler.service.NoSuchDepartmentFoundException;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	protected ResponseEntity<Map<String, Object>> handleConflict(NoSuchDepartmentFoundException e) {
     Map<String, Object> response=new HashMap<String, Object>();
     response.put("Message", e.getMessage());
     response.put("Status", HttpStatus.BAD_REQUEST);
     response.put("Body", null);
     response.put("Error", true);
     return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
}
