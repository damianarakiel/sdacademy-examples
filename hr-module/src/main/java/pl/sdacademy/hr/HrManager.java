package pl.sdacademy.hr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	public List<Employee> searchByLastName(String lastName) {
/*		List<Employee> foundEmployees = new ArrayList<>();
		for (Employee employee : allEmployees) {
			if (employee.getLastName().equals(lastName)) {
				foundEmployees.add(employee);
			}
		}
		return foundEmployees;*/
		return allEmployees.stream().filter(employee -> employee.getLastName().contains(lastName)).collect
			(Collectors.toList());
	}

	public List<Employee> searchByPhrase(String phrase) {
		return allEmployees.stream().filter(employee -> employee.matches(phrase))
			/* employee.getFirstName().contains(phrase)
			|| employee.getLastName().contains(phrase)
			|| employee.getBirthDate().contains(phrase))*/
//			przeniesione do metody matches w klasie Employee
			.collect(Collectors.toList());

	}
}
