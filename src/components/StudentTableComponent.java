package components;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.Student;

public class StudentTableComponent extends JScrollPane{
	
	private JTable studentTable;
	private DefaultTableModel studentTM;
	
	public StudentTableComponent(Student[] students) {
		
		studentTM = new DefaultTableModel();
		studentTM.addColumn("ID");
		studentTM.addColumn("Name");
		studentTM.addColumn("Email");
		
        for(int i = 0; i < students.length; i++) {
        	Student student = students[i];
            studentTM.addRow(new Object[] {
            		student.getID(), 
            		student.getStudentName(), 
            		student.getEmail()
            });
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
	
	public void setData(Student[] students) {
	    DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
	    model.setRowCount(0); // clear rows

	    for (Student s : students) {
	        model.addRow(new Object[]{
	            s.getID(),
	            s.getStudentName(),
	            s.getEmail(),
	        });
	    }
	}

}
