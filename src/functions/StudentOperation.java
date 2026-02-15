package functions;

import main.*;
import functions.FileOperations;

public class StudentOperation {
	private Student[] students; 
	FileOperations ops_nextId;
	
	public StudentOperation(){
		FileOperations ops_studentInformation = new FileOperations(ApplicationConfig.studentInformation);
		ops_nextId = new FileOperations(ApplicationConfig.nextID);
		
		String[][] s = ops_studentInformation.to2dArray(5, "\\|", "&&");
		students = new Student[s.length];
		
		int index = 0;
		for(String[] innerS : s) {
			String id = innerS[0];
			String name = innerS[1];
			String email = innerS[2];
			String program = innerS[3];
			String year = innerS[4];
			
			Student student = new Student(id, name, email, program, year);
			students[index] = student;
			
			index++;
		}
	}
	
	public Student[] get() {
		return students;
	}
	
	public Student search(String id) {
		for(Student student : students) {
			if(student.getID() == id) {
				return student;
			}
		}
		
		return null;
	}
	
	public void register(String name, String email, String program, String year) {
		String nextId = ops_nextId.getString()[1];
		
		FileOperations fos_Student = new FileOperations(ApplicationConfig.studentInformation);
		fos_Student.newLine("&&", String.format("%s|%s|%s|%s|%s|", nextId, name, email, program, year));
		
		int nextNextId = Integer.parseInt(nextId) + 1;
		nextId = String.format("%06d", nextNextId);
		
		ops_nextId.newData(nextId);
	}
}
