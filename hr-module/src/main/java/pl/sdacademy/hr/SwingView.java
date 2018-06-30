package pl.sdacademy.hr;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SwingView {

	private static final HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(new HrManager());
	private static DefaultTableModel tableModel = new DefaultTableModel();

	public static void main(String[] args) {
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Birth Date");
		adapter.sortByLastName(tableModel);


		SwingUtilities.invokeLater(() -> {

			// prepare the jframe
			final JFrame jFrame = new JFrame();
			LayoutManager layout = new GridLayout(3, 1);
			jFrame.setLayout(layout);
			jFrame.setTitle("HR Manager v");
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// content
			addFirstRow(jFrame);
			addSecondRow(jFrame);
			addThirdRow(jFrame);

			// pack and show
			jFrame.setPreferredSize(new Dimension(640, 480));
			jFrame.pack();
			jFrame.setVisible(true);
		});
	}

	private static void addThirdRow(JFrame jFrame) {
		// populate row
		JPanel row = new JPanel();
		LayoutManager layout = new GridLayout(3, 1);
		row.setLayout(layout);

		row.add(new JLabel("                                                         Filters:"));
		JPanel lastNameFilter = new JPanel();
		lastNameFilter.add(new JLabel("First Name:"));
		lastNameFilter.add(new JTextField("First Name"));
		lastNameFilter.add(new JButton("OK"));
		row.add(lastNameFilter);
		JPanel phraseFilter = new JPanel();
		phraseFilter.add(new JLabel("Phrase:     "));
		phraseFilter.add(new JTextField("   Phrase   "));
		phraseFilter.add(new JButton("OK"));
		row.add(phraseFilter);
		jFrame.add(row);

	}

	private static void addSecondRow(JFrame jFrame) {
		JTable table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		jFrame.add(scrollPane);
	}

	private static void addFirstRow(JFrame jFrame) {
		// populate row
		JPanel row = new JPanel();

		JButton addButton = new JButton("Add");
		JTextField firstNameTextField = new JTextField("First Name");
		JTextField lastNameTextField = new JTextField("Last Name");
		JTextField birthDateTextField = new JTextField("Birth Date");

		addButton.addActionListener(e->{
			adapter.addNewEmployee(tableModel, firstNameTextField.getText(), lastNameTextField.getText(),
				birthDateTextField.getText());
		});

		row.add(addButton);
		row.add(new JLabel("First Name"));
		row.add(firstNameTextField);
		row.add(new JLabel("Last Name"));
		row.add(lastNameTextField);
		row.add(new JLabel("Birth Date"));
		row.add(birthDateTextField);
		// add row to jFrame
		jFrame.add(row);
	}
}
