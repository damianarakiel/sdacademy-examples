package pl.sdacademy.hr;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.table.DefaultTableModel;

import static org.assertj.core.api.Assertions.*;

public class HrManagerSwingAdapterTest {

	@DisplayName("should add to tableModel new row matching employee created by Hrmanager given Adam Nowak " +
		"01-12-1970")
	@Test
	void adapterTest1(){
		//given
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Birth Date");
		HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(fakeHrManager());
		//when
		adapter.addNewEmployee(tableModel, "Adam","Nowak", "01-12-1970");
		//then
		Object firstNameFromTableModel = tableModel.getValueAt(0, 0);
		assertThat(firstNameFromTableModel).isEqualTo("Zoltan");
		Object lastNameFromTableModel = tableModel.getValueAt(0, 1);
		assertThat(lastNameFromTableModel).isEqualTo("Bloodhammer");
		Object birthDateFromTableModel = tableModel.getValueAt(0, 2);
		assertThat(birthDateFromTableModel).isEqualTo("11-10-1210");
	}

	private HrManager fakeHrManager() {
		return new HrManager(){
			@Override
			Employee create(String firstName, String lastName, String birthDate) {
				if(firstName.equals("Adam")&& lastName.equals("Nowak")&& birthDate.equals("01-12-1970"))
				return new Employee("Zoltan", "Bloodhammer", "11-10-1210");
				throw new IllegalArgumentException("Błąd argumenta");
			}
		};
	}
}
