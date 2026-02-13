package components;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentTableComponent extends JScrollPane{
	
	private JTable studentTable;
	private DefaultTableModel studentTM;
	
	public StudentTableComponent(String[][] students) {
		studentTM = new DefaultTableModel();
		studentTM.addColumn("ID");
		studentTM.addColumn("Name");
		studentTM.addColumn("Email");
		
        for(int i = 0; i < students.length; i++) {
            studentTM.addRow(students[i]);
        }
		
		studentTable = new JTable(studentTM);
		
		setViewportView(studentTable);
	}
	
	public JTable getTable() {
		return studentTable;
	}
	
	public DefaultTableModel getModel() {
		return studentTM;
	}
}
