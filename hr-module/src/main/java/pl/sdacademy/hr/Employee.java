package pl.sdacademy.hr;

import java.util.Comparator;

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
		return firstName + " " + lastName + ", " + birthDate;
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
}
