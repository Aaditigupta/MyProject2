package com.mindtree.departmentemp.exceptionhandler.service;

import com.mindtree.departmentemp.exceptionhandler.DepartmentApplicationException;

public class DepartmentServiceException extends DepartmentApplicationException {

	public DepartmentServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public DepartmentServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public DepartmentServiceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DepartmentServiceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
