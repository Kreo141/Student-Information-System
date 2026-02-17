package functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
			System.out.println(e);
		}	
		
		return new String[] {
			result,
			resultSingleLine
		};
	}
	
	public String[][] to2dArray(int numOfColumns, String columnDivider, String rowDivider) {
		String[] rows = fileContentSingleLine.split(rowDivider);
		//String[][] result = new String[rows.length][numOfColumns];
		
		int validRows = 0;
		for(String row : rows) {
			if(!row.isEmpty()) validRows++;
		}
		
		String[][] result = new String[validRows][numOfColumns];
		int index = 0;
		
		for(int i = 0; i < rows.length; i++) {
			if (rows[i].isEmpty()) continue;
			
			String[] row = rows[i].split(columnDivider);
			for(int column = 0; column < numOfColumns; column++) {
				result[i][column] = row[column];				
			}
			index++;
		}
		
		return result;
	}
	
	public void newLine(String separator, String data) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
			writer.write(separator + "\n" + data);
			writer.close();
		}catch(IOException e) {
			
		}
	}
	
	public void newData(String data) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
			writer.write(data);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
