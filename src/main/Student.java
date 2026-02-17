package main;

public class Student {
	private String studentName;
	private String ID;
	private String email;
	private String college;
	private String program;
	private String yearLevel;
	
	public Student(String ID, String studentName, String email, String college, String program, String yearLevel){
		this.ID = ID;
		this.studentName = studentName;
		this.email = email;
		this.college = college;
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
	
	public String getCollege() {
		return college;
	}
	
	public void setCollege(String college) {
		this.college = college;
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
