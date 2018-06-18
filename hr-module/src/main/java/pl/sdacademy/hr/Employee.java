package pl.sdacademy.hr;

class Employee {
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
}
