package pl.sdacademy.hr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HrManagerTest {
	private HrManager hrManager = new HrManager();

	@DisplayName("should create non-null new allEmployees when is given name, last name and birth date")
	@Test
	void hrManagerTest0() {
		//given
		String firstName = "Adam";
		String lastName = "Nowak";
		String birthDate = "01-12-1970";
		//when
		Employee employee = hrManager.create(firstName, lastName, birthDate);
		//then
		assertThat(employee).isNotNull();
	}

	@DisplayName("should create a new allEmployees with ALL fields: name, last name and birth date")
	@Test
	void hrManagerTest1() {
		//given
		String firstName = "Adam";
		String lastName = "Nowak";
		String birthDate = "01-12-1970";
		//when
		Employee employee = hrManager.create(firstName, lastName, birthDate);
		//then
		assertThat(employee.getFirstName()).isEqualTo(firstName);
		assertThat(employee.getLastName()).isEqualTo(lastName);
		assertThat(employee.getBirthDate()).isEqualTo(birthDate);
	}

	@DisplayName("should check if new allEmployees is added to the database")
	@Test
	void hrManagerTest2() {
		//given
		String firstName = "Adam";
		String lastName = "Nowak";
		String birthDate = "01-12-1970";
		Employee newEmployee = hrManager.create(firstName, lastName, birthDate);
		//when
		List<Employee> allEmployees = hrManager.findAll();
		//then
		Assertions.assertThat(allEmployees).containsOnly(newEmployee);
	}

	@DisplayName("should check if two new allEmployees is added to the database")
	@Test
	void hrManagerTest3() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-12-1970");
		Employee george = hrManager.create("George", "Smith", "13-01-1976");
		//when
		List<Employee> allEmployees = hrManager.findAll();
		//then
		Assertions.assertThat(allEmployees).containsOnly(adam, george);
	}

	@DisplayName("should find single employee with given lastName")
	@Test
	void hrManagerTest4() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-12-1970");
		Employee jerzy = hrManager.create("Jerzy", "Borg", "13-01-1976");
		//Employee stefan = hrManager.create("Stefan","Borg","17-07-19768");
		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("Borg");
		//then
		Assertions.assertThat(foundEmployees).containsOnly(jerzy);
	}

	@DisplayName("should find every employee with given lastName")
	@Test
	void hrManagerTest5() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-12-1970");
		Employee jerzy = hrManager.create("Jerzy", "Borg", "13-01-1976");
		Employee stefan = hrManager.create("Stefan", "Borg", "17-07-19768");
		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("Borg");
		//then
		Assertions.assertThat(foundEmployees).containsOnly(jerzy, stefan);
	}

	@DisplayName("should find no employee there is no employee with given lastName")
	@Test
	void hrManagerTest6() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-12-1970");
		Employee jerzy = hrManager.create("Jerzy", "Borg", "13-01-1976");
		Employee stefan = hrManager.create("Stefan", "Borg", "17-07-19768");
		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("Kowalski");
		//then
		Assertions.assertThat(foundEmployees).isEmpty();
	}

	@DisplayName("should find two employee with firstName matching given search phrase")
	@Test
	void hrManagerTest7() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-12-1970");
		Employee jerzy = hrManager.create("Jerzy", "Borg", "13-01-1976");
		Employee stefanBorg = hrManager.create("Stefan", "Borg", "17-07-1978");
		Employee stefanGarda = hrManager.create("Stefan", "Garda", "17-07-1978");
		//when
		List<Employee> foundEmployees = hrManager.searchByPhrase("Stefan");
		//then
		Assertions.assertThat(foundEmployees).containsOnly(stefanBorg, stefanGarda);
	}

	@DisplayName("should find two employee with lastName matching given search phrase")
	@Test
	void hrManagerTest8() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-12-1970");
		Employee jerzy = hrManager.create("Jerzy", "Borg", "13-01-1976");
		Employee stefanBorg = hrManager.create("Stefan", "Borg", "17-07-1978");
		Employee stefanGarda = hrManager.create("Stefan", "Garda", "17-07-1978");
		//when
		List<Employee> foundEmployees = hrManager.searchByPhrase("Borg");
		//then
		Assertions.assertThat(foundEmployees).containsOnly(jerzy, stefanBorg);
	}

	@DisplayName("should find two employee with birthDate matching given search phrase")
	@Test
	void hrManagerTest9() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-12-1970");
		Employee jerzy = hrManager.create("Jerzy", "Borg", "13-01-1976");
		Employee stefanBorg = hrManager.create("Stefan", "Borg", "17-07-1978");
		Employee stefanGarda = hrManager.create("Stefan", "Garda", "13-01-1976");
		//when
		List<Employee> foundEmployees = hrManager.searchByPhrase("13-01-1976");
		//then
		Assertions.assertThat(foundEmployees).containsOnly(jerzy, stefanGarda);
	}

	@DisplayName("should sort by firstName ascending")
	@Test
	void hrManagerTest10() {
		//given
		Employee jerzy = hrManager.create("Jerzy", "Borg", "13-01-1976");
		Employee adam = hrManager.create("Adam", "Nowak", "01-12-1970");
		Employee stefanBorg = hrManager.create("Stefan", "Borg", "17-07-1978");
		//Employee stefanGarda = hrManager.create("Stefan", "Garda", "13-01-1976");
		//when
		List<Employee> sortEmployees = hrManager.sortByFirstName();
		//then
		Assertions.assertThat(sortEmployees).containsExactly(adam, jerzy, stefanBorg);
	}

	@DisplayName("should sort 2 employee by firstName descending with Bubblesort")
	@Test
	void hrManagerTest11() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-12-1970");
		Employee jerzy = hrManager.create("Jerzy", "Borg", "13-01-1976");
		//		Employee stefanBorg = hrManager.create("Stefan", "Borg", "17-07-1978");
		//		Employee stefanGarda = hrManager.create("Stefan", "Garda", "13-01-1976");
		//when
		List<Employee> sortEmployees = hrManager.sortByFirstNameWithBubble();
		//then
		Assertions.assertThat(sortEmployees).containsExactly(jerzy, adam);
	}

	@DisplayName("should sort 3 employee by firstName descending with Bubblesort")
	@Test
	void hrManagerTest12() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-12-1970");
		Employee jerzy = hrManager.create("Jerzy", "Borg", "13-01-1976");
		Employee stefan = hrManager.create("Stefan", "Borg", "17-07-1978");
		//when
		List<Employee> sortEmployees = hrManager.sortByFirstNameWithBubble();
		//then
		Assertions.assertThat(sortEmployees).containsExactly(stefan, jerzy, adam);
	}

	@DisplayName("should sort 4 employee by firstName descending with Bubblesort")
	@Test
	void hrManagerTest13() {
		//given
		Employee adam = hrManager.create("Adam", "Nowak", "01-12-1970");
		Employee jerzy = hrManager.create("Jerzy", "Borg", "13-01-1976");
		Employee stefanBorg = hrManager.create("Stefan", "Borg", "17-07-1978");
		Employee stefanGarda = hrManager.create("Stefanek", "Garda", "13-01-1976");
		//when
		List<Employee> sortEmployees = hrManager.sortByFirstNameWithBubble();
		//then
		Assertions.assertThat(sortEmployees).containsExactly(stefanGarda, stefanBorg, jerzy, adam);
	}

	@DisplayName("should sort by lastName ascending") //QUICKSORT
	@Test
	void hrManagerTest14() {
		//given
		Employee jerzy = hrManager.create("Jerzy", "Borg", "13-01-1976");
		Employee adam = hrManager.create("Adam", "Nowak", "01-12-1970");
		//Employee stefanBorg = hrManager.create("Stefan", "Borg", "17-07-1978");
		Employee stefanGarda = hrManager.create("Stefan", "Garda", "13-01-1976");
		//when
		List<Employee> sortEmployees = hrManager.sortByLastName();
		//then
		Assertions.assertThat(sortEmployees).containsExactly(jerzy, stefanGarda, adam);
	}
}
