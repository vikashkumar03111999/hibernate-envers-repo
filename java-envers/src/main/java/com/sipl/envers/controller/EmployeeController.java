package com.sipl.envers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sipl.envers.entity.Employee;
import com.sipl.envers.repository.EmployeeRepository;

@RestController
@EnableJpaRepositories
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
		
	}
	
	@PutMapping("/update/{id}/{salary}")
	public String updateEmployee(@PathVariable int id, @PathVariable int salary) {
		Employee employee = employeeRepository.findById(id).get();
		employee.setSalary(salary);
		employeeRepository.save(employee);
		return "Employee updated";
		
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeRepository.deleteById(id);
		return "employee deleted";
		
	}
	

}
