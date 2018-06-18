package pl.sdacademy.hr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HrManager {
	private List<Employee> allEmployees = new ArrayList<>();
	Employee create(String firstName, String lastName, String birthDate) {
		Employee employee = new Employee(firstName, lastName, birthDate);
		allEmployees.add(employee);
		return employee;
	}
	List<Employee> findAll() {
		return allEmployees;
	}
}
