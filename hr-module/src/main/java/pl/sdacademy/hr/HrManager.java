package pl.sdacademy.hr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class HrManager {
	private List<Employee> allEmployees = new ArrayList<>();
	private static final Path PATH = Paths.get("employees.txt");

	Employee create(String firstName, String lastName, String birthDate) {
		Employee employee = new Employee(firstName, lastName, birthDate);
		allEmployees.add(employee);
		try {
			Files.write(PATH, allEmployees.stream().map(Employee::toString).collect(Collectors.toList()));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return employee;
	}

	/*Employee create(String firstName, String lastName, String birthDate) {
		Employee employee = new Employee(firstName, lastName, birthDate);
		allEmployees.add(employee);
		return employee;
	}*/

	List<Employee> findAll() {
		try {
			return Files.readAllLines(PATH).stream().map((line) -> {
				String[] splitline = line.split(" ");
				Employee employee = new Employee(splitline[0], splitline[1], splitline[2]);
				return employee;
			}).collect(Collectors.toList());
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
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

	public List<Employee> sortByFirstName() {
		return allEmployees.stream().sorted().collect(Collectors.toList());
	}

	public List<Employee> sortByFirstNameWithBubble() {
		for (int j = 0; j < allEmployees.size() - 1; j++) {
			for (int i = 0; i < allEmployees.size() - 1 - j; i++) {
				if (allEmployees.get(i).getFirstName().compareTo(allEmployees.get(i + 1).getFirstName()) < 0) {
					Employee temp = allEmployees.get(i);
					allEmployees.set(i, allEmployees.get(i + 1));
					allEmployees.set(i + 1, temp);
				}
			}
		}
		return allEmployees;
	}

	// SORTOWANIE QUICKSORT:

	public List<Employee> sortByLastName() {
		/*return allEmployees.stream().sorted(Comparator.comparing(Employee::getFirstName)).collect
		(Collectors.toList()); */
		// return allEmployees.stream().sorted().collect(Collectors.toList());
		//QuickSort
		List<Employee> allEmployees = findAll();
		quickSort(allEmployees, 0, allEmployees.size() - 1);


		return allEmployees;
	}


	public List<Employee> quickSort(List<Employee> employees, int low, int high) {
		if (low < high) {
			int pi = partition(employees, low, high);

			quickSort(employees, low, pi - 1);
			quickSort(employees, pi + 1, high);
		}
		return employees;
	}

	private int partition(List<Employee> employees, int low, int high) {
		Employee pivot = employees.get(high);
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (employees.get(j).getLastName().compareTo(pivot.getLastName()) <= 0) {
				i++;
				Employee temp = employees.get(j);
				employees.set(j, employees.get(i));
				employees.set(i, temp);
			}
		}
		Employee temp = employees.get(i + 1);
		employees.set(i + 1, employees.get(high));
		employees.set(high, temp);
		return i + 1;
	}
}