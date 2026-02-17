package main;

public class ApplicationConfig {

	public static final String DIR = "E:\\ChromeDownload\\SCHOOL FILES\\studentInformationSystem\\";
	public static final String photosDIR = DIR + "photos\\";
	
	public static final String adminCreds = DIR + "adminCreds.txt";
	public static final String studentAccountCreds = DIR + "studentAccountCreds.txt";
	public static final String studentInformation = DIR + "studentInformations.txt";
	public static final String nextID = DIR + "nextId.txt";
	public static final String defaultPfp = "src/assets/defaultPfp.png";
	public static final String editIcon = "src/assets/editIcon.png";
	
	private static final String defaultAdminPassword = "1234";
	
	
	public static String getAdminDefaultPassword() {
		return defaultAdminPassword;
	}
}
