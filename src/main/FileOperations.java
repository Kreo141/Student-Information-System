package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileOperations {
	String fileName;
	public String fileContent;
	public String fileContentSingleLine;
	
	public FileOperations(String fileName) {
		this.fileName = fileName;
		

		this.fileContent = getString()[0];
		this.fileContentSingleLine = getString()[1];
	}
	
	public String[] getString() {
		String result = "";
		String resultSingleLine = "";
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName));){
			String line;
			while((line = reader.readLine()) != null) {
				result += line + "\n";
				resultSingleLine += line;
			}
			
			reader.close();
		}catch(IOException e) {
			System.out.println();
		}	
		
		return new String[] {
			result,
			resultSingleLine
		};
	}
	
	public String[][] to2dArray(int numOfColumns, String columnDivider, String rowDivider) {
		String[] rows = fileContentSingleLine.split(rowDivider);
		String[][] result = new String[rows.length][numOfColumns];
		
		for(int i = 0; i < rows.length; i++) {
			String[] row = rows[i].split(columnDivider);
			for(int column = 0; column < numOfColumns; column++) {
				result[i][column] = row[column];				
			}
		}
		
		return result;
	}
}
