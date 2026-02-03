package main;

public class Student {
	private String studentName;
	private String ID;
	private String email;
	private String program;
	private String yearLevel;
	
	Student(String studentName, String ID, String email, String program, String yearLevel){
		this.studentName = studentName;
		this.ID = ID;
		this.email = email;
		this.program = program;
		this.yearLevel = yearLevel;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getYearLevel() {
		return yearLevel;
	}

	public void setYearLevel(String yearLevel) {
		this.yearLevel = yearLevel;
	}
	
	
}
