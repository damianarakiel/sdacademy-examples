package pl.sdacademy.hr;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandLineRunnerTest {

	@DisplayName("should reject input data when 3 arguments is given and firstName is not given")
	@Test
	void commandLineRunnerTest0() {
		//given
		String[] args = {"lastName=Nowak", "birthDate=01-12-1970", "enything"};
		HrManager hrManager = new HrManager();
		//CommandLineRunner clr = new CommandLineRunner();
		//when
		assertThatThrownBy(() -> CommandLineRunner.load(args, hrManager))
			//then
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("should reject input data when 3 arguments is given and lastName is not given")
	@Test
	void commandLineRunnerTest1() {
		//given
		String[] args = {"firstName=Adam", "birthDate=01-12-1970", "enything"};
		HrManager hrManager = new HrManager();
		//when
		assertThatThrownBy(() -> CommandLineRunner.load(args, hrManager))
			//then
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("should reject input data when 3 arguments is given and birthDate is not given")
	@Test
	void commandLineRunnerTest2() {
		//given
		String[] args = {"firstName=Adam", "lastName=Nowak", "enything"};
		HrManager hrManager = new HrManager();
		//when
		assertThatThrownBy(() -> CommandLineRunner.load(args, hrManager))
			//then
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("should check if firstName, lastName and birthDate is given then database isn't empty")
	@Test
	void commandLineRunnerTest3() {
		//given
		String[] args = {"firstName=Adam", "lastName=Nowak", "birthDate=01-12-1970"};
		HrManager hrManager = new HrManager();
		//when
		CommandLineRunner.load(args, hrManager);
		//then
		assertThat(hrManager.findAll()).isNotEmpty();
	}

	@DisplayName("should check if firstName, lastName and birthDate isn't empty and than database contains single"
		+ " employee with the same firstName, lastName and birthDate")
	@Test
	void commandLineRunnerTest4() {
		//given
		String[] args = {"firstName=Adam", "lastName=Nowak", "birthDate=01-12-1970"};
		HrManager hrManager = new HrManager();
		//when
		CommandLineRunner.load(args, hrManager);
		//then
		Employee employee = hrManager.findAll().get(0);
		assertThat(employee.getFirstName()).isEqualTo("Adam");
		assertThat(employee.getLastName()).isEqualTo("Nowak");
		assertThat(employee.getBirthDate()).isEqualTo("01-12-1970");
	}

	@DisplayName("should return list of test representation of all employees from database")
	@Test
	void commandLineRunnerTest5() {
		//given
		String[] args = {"firstName=Adam", "lastName=Nowak", "birthDate=01-12-1970"};
		HrManager hrManager = new HrManager();
		CommandLineRunner.load(args, hrManager);
		//when
		List<String> allEmployees = CommandLineRunner.list(hrManager);
		//then
		assertThat(allEmployees).containsOnly("Adam Nowak, 01-12-1970");
	}
}
