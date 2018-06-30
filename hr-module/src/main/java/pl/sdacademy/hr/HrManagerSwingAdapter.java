package pl.sdacademy.hr;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.List;

public class HrManagerSwingAdapter {
	private HrManager hrManager;

	public HrManagerSwingAdapter(HrManager hrManager) {

		   this.hrManager = hrManager;
	}
	public void addNewEmployee(DefaultTableModel tableModel, String firstName, String lastName, String birthDate){
		Employee newEmployee = hrManager.create(firstName,lastName,birthDate);
		addRow(tableModel,newEmployee);
	}

	private void addRow(DefaultTableModel tableModel, Employee newEmployee){
		tableModel.addRow(new Object[]{newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee
			.getBirthDate()});
	}

	public void sortByLastName(DefaultTableModel tableModel) {
		tableModel.getDataVector().clear();
		List<Employee> sortedEmployees = hrManager.sortByLastName();
		for (Employee employee: sortedEmployees){
			addRow(tableModel, employee);
		}
	}
}
