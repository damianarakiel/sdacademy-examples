package pl.sdacademy.hr;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.table.DefaultTableModel;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HrManagerSwingAdapterTest {

	@DisplayName("should add to empty tableModel new row matching employee created by HrManager given Adam Nowak")
	@Test
	void adapterTest1() {
		//given
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Birth Date");
		HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(fakeCreateHrManager());
		//when
		adapter.addNewEmployee(tableModel, "Adam", "Nowak", "01-12-1970");
		//then
		Object firstNameFromTableModel = tableModel.getValueAt(0, 0);
		assertThat(firstNameFromTableModel).isEqualTo("Zoltan");
		Object lastNameFromTableModel = tableModel.getValueAt(0, 1);
		assertThat(lastNameFromTableModel).isEqualTo("Bloodhammer");
		Object birthDateFromTableModel = tableModel.getValueAt(0, 2);
		assertThat(birthDateFromTableModel).isEqualTo("11-10-1210");
	}

	private HrManager fakeCreateHrManager() {
		return new HrManager() {
			@Override
			Employee create(String firstName, String lastName, String birthDate) {
				if (firstName.equals("Adam") && lastName.equals("Nowak") && birthDate.equals("01-12-1970")) {
					return new Employee("Zoltan", "Bloodhammer", "11-10-1210");
				}
				throw new IllegalArgumentException("Błąd argumenta");
			}
		};
	}

	@DisplayName("Should add to empty Table Model exactly two rows returned by HRManager when used sort")
	@Test
	void adapterTest2() {
		//given
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Birth Date");
		HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(fakeSortHrManager());
		//when
		adapter.sortByLastName(tableModel);
		//then
		//row0
		Object firstNameFromTableModel = tableModel.getValueAt(0, 0);
		assertThat(firstNameFromTableModel).isEqualTo("Tomek");
		Object lastNameFromTableModel = tableModel.getValueAt(0, 1);
		assertThat(lastNameFromTableModel).isEqualTo("Morda");
		Object birthDateFromTableModel = tableModel.getValueAt(0, 2);
		assertThat(birthDateFromTableModel).isEqualTo("10-10-1910");
		//row1
		Object firstNameFromTableModel2 = tableModel.getValueAt(1, 0);
		assertThat(firstNameFromTableModel2).isEqualTo("Krzysztof");
		Object lastNameFromTableModel2 = tableModel.getValueAt(1, 1);
		assertThat(lastNameFromTableModel2).isEqualTo("Ryj");
		Object birthDateFromTableModel2 = tableModel.getValueAt(1, 2);
		assertThat(birthDateFromTableModel2).isEqualTo("11-11-1911");
	}

	private HrManager fakeSortHrManager() {
		return new HrManager() {
			@Override
			public List<Employee> sortByLastName() {
				return Arrays.asList(new Employee("Tomek", "Morda", "10-10-1910"), new Employee("Krzysztof",
					"Ryj", "11-11-1911"));
			}
		};
	}

	@DisplayName("zakladajac ze tableModel nie jest pusty, powinien zostac zastapiony tableModel-em zwroconym przez " +
		"metode sort z HrManagera")
	@Test
	void adapterTest3(){
		//given
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Birth Date");
		tableModel.addRow(new Object[]{"Waldemar", "Wolski", "01-01-1901"});
		HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(fakeSortHrManager());
		//when
		adapter.sortByLastName(tableModel);
		//then
		//row0
		Object firstNameFromTableModel = tableModel.getValueAt(0, 0);
		assertThat(firstNameFromTableModel).isEqualTo("Tomek");
		Object lastNameFromTableModel = tableModel.getValueAt(0, 1);
		assertThat(lastNameFromTableModel).isEqualTo("Morda");
		Object birthDateFromTableModel = tableModel.getValueAt(0, 2);
		assertThat(birthDateFromTableModel).isEqualTo("10-10-1910");
		//row1
		Object firstNameFromTableModel2 = tableModel.getValueAt(1, 0);
		assertThat(firstNameFromTableModel2).isEqualTo("Krzysztof");
		Object lastNameFromTableModel2 = tableModel.getValueAt(1, 1);
		assertThat(lastNameFromTableModel2).isEqualTo("Ryj");
		Object birthDateFromTableModel2 = tableModel.getValueAt(1, 2);
		assertThat(birthDateFromTableModel2).isEqualTo("11-11-1911");
	}

}