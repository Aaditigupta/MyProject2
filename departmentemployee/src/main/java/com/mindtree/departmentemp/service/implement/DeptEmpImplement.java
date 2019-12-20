package com.mindtree.departmentemp.service.implement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.departmentemp.dto.DepartmentDTO;
import com.mindtree.departmentemp.dto.EmployeeDTO;
import com.mindtree.departmentemp.entity.Department;
import com.mindtree.departmentemp.entity.Employee;
import com.mindtree.departmentemp.exceptionhandler.service.DepartmentServiceException;
import com.mindtree.departmentemp.exceptionhandler.service.NoSuchDepartmentFoundException;
import com.mindtree.departmentemp.repository.DepartmentRepository;
import com.mindtree.departmentemp.repository.EmployeeRepository;
import com.mindtree.departmentemp.service.DeptEmp;

@Service
public class DeptEmpImplement implements DeptEmp {
	@Autowired
	DepartmentRepository deprepo;
	@Autowired
	EmployeeRepository emprepo;

	@Override
	public String sendDetailsToService(DepartmentDTO departmentDTO) {
		// TODO Auto-generated method stub
		Department department = new Department();
		List<EmployeeDTO> employees = departmentDTO.getEmployees();
		List<Employee> employees1 = new ArrayList<>();
		department.setDeptId(departmentDTO.getDeptId());
		department.setDeptName(departmentDTO.getDeptName());

		for (EmployeeDTO employee : employees) {
			Employee employee1 = new Employee();
			employee1.setEmpId(employee.getEmpId());
			employee1.setEmpName(employee.getEmpName());
			employee1.setExperience(employee.getExperience());
			employee1.setSalary(employee.getExperience() * 200000);
			employees1.add(employee1);
			// emprepo.saveAll(employees1);
		}
		department.setEmployees(employees1);
		department.getEmployees().addAll(employees1);

		for (Employee employee : employees1) {
			employee.setDepartment(department);
		}

		deprepo.saveAndFlush(department);
		return "INSERTED SUCCESSFULLY";
	}

	@Override
	public List<DepartmentDTO> getAllDetails() throws DepartmentServiceException {
		List<Department> departments = deprepo.findAll();
		List<Department> result = new ArrayList<>();
		for (Department department : departments) {
			List<Employee> employees = department.getEmployees();
			int depSalary = 0;
			for (Employee employee : employees) {
				depSalary += employee.getSalary();
			}
			if (depSalary > 50000) {
				result.add(department);
			}
		}
		if (result.size() == 0) {
			 throw new NoSuchDepartmentFoundException("No such department exists");
			//System.out.println("no dept found");
		}
		List<DepartmentDTO> dtodepts = new ArrayList<>();
		for (Department department : result) {
			List<Employee> employees = department.getEmployees();
			List<EmployeeDTO> dtoemps = new ArrayList<>();
			for (Employee employee : employees) {
				EmployeeDTO employeedto = new EmployeeDTO();
				employeedto.setEmpId(employee.getEmpId());
				employeedto.setEmpName(employee.getEmpName());
				employeedto.setExperience(employee.getExperience());
				employeedto.setSalary(employee.getSalary());
				dtoemps.add(employeedto);
			}
			dtodepts.add(new DepartmentDTO(department.getDeptId(), department.getDeptName(), dtoemps));
		}
		return dtodepts;
	}

}
