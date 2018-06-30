package pl.sdacademy.hr;

import java.util.Comparator;
import java.util.Objects;

class Employee implements Comparable<Employee> {
	private final String firstName;
	private final String lastName;
	private final String birthDate;

	public Employee(String firstName, String lastName, String birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getBirthDate() {return birthDate;}

	@Override
	public String toString() {
		return firstName + " " + lastName + " " + birthDate;
	}

	public boolean matches(String phrase) {
		return firstName.contains(phrase)
			|| lastName.contains(phrase)
			|| birthDate.contains(phrase);
	}

	@Override
	public int compareTo(Employee other) {
		return firstName.compareTo(other.firstName);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Employee employee = (Employee) o;
		return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) &&
			Objects.equals(birthDate, employee.birthDate);
	}

	@Override
	public int hashCode() {

		return Objects.hash(firstName, lastName, birthDate);
	}
}
