package components;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentTableComponent extends JScrollPane{
	public StudentTableComponent(String[][] students) {
		DefaultTableModel studentTM = new DefaultTableModel();
		studentTM.addColumn("ID");
		studentTM.addColumn("Name");
		studentTM.addColumn("Email");
		
		for(int i = 0; i < students.length; i++) {
			Object[] studentInfo = new Object[students[i].length];
			
			for(int x = 0; x < studentInfo.length; x++) {
				studentInfo[x] = students[i][x];
			}
			
			System.out.println(studentInfo[0] + " " + studentInfo[1] + " " + studentInfo[2]);
			studentTM.addRow(studentInfo);
		}
		
		JTable studentTable = new JTable(studentTM);
		
		setViewportView(studentTable);
	}
}
