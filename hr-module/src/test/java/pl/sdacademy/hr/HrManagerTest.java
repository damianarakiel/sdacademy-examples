package pl.sdacademy.hr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HrManagerTest {
	private HrManager hrManager = new HrManager();

	@DisplayName("should create non-null new allEmployees when is given name, last name and birth date")
	@Test
	void hrManagerTest0 (){
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
	void hrManagerTest1 (){
		//given
		String firstName = "Adam";
		String lastName = "Nowak";
		String birthDate = "01-12-1970";
		//when
		Employee employee = hrManager.create(firstName,lastName,birthDate);
		//then
		assertThat(employee.getFirstName()).isEqualTo(firstName);
		assertThat(employee.getLastName()).isEqualTo(lastName);
		assertThat(employee.getBirthDate()).isEqualTo(birthDate);
	}
	@DisplayName("should check if new allEmployees is added to the database")
	@Test
	void hrManagerTest2 (){
		//given
		String firstName = "Adam";
		String lastName = "Nowak";
		String birthDate = "01-12-1970";
		Employee newEmployee = hrManager.create(firstName,lastName,birthDate);
		//when
		List<Employee> allEmployees = hrManager.findAll();
		//then
		assertThat(allEmployees).containsOnly(newEmployee);
	}
	@DisplayName("should check if two new allEmployees is added to the database")
	@Test
	void hrManagerTest3 (){
		//given
		Employee adam = hrManager.create("Adam","Nowak","01-12-1970");
		Employee george = hrManager.create("George","Smith","13-01-1976");
		//when
		List<Employee> allEmployees = hrManager.findAll();
		//then
		assertThat(allEmployees).containsOnly(adam, george);
	}
}
