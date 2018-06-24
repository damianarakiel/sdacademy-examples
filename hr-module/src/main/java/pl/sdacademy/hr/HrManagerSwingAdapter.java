package pl.sdacademy.hr;

import javax.swing.table.DefaultTableModel;

public class HrManagerSwingAdapter {
	private HrManager hrManager;

	public HrManagerSwingAdapter(HrManager hrManager) {
		this.hrManager = hrManager;
	}
	public void addNewEmployee(DefaultTableModel tableModel, String firstName, String lastName, String birthDate){
	Employee newEmployee = hrManager.create(firstName,lastName,birthDate);
	tableModel.setRowCount(0);
	tableModel.addRow(new Object[]{newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getBirthDate()});
	}
}
