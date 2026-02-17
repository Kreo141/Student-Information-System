package main;

import java.util.*;

import java.io.*;
import javax.swing.*;

import windows.*;
import functions.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	
	static Password ops_password = new Password();
	
	public static boolean authenticateUser(String username, String password) {
		
		String loginAs = loginUser.loginRole;
		FileOperations f;
		
		if(loginAs.equals("user")) {
			f = new FileOperations(ApplicationConfig.studentAccountCreds);			
		}else if(loginAs.equals("admin")){
			f = new FileOperations(ApplicationConfig.adminCreds);
		} else if((new File(ApplicationConfig.studentAccountCreds)).exists() || (new File(ApplicationConfig.adminCreds)).exists()) {
			System.out.println("Credential files not initialized");
			return false;
		} else {
			return false;
		}
		
		// Store account credentials to 2d Array
		final String[][] credentials = f.to2dArray(2, "₷", "₪");
		TwoDArrayOperations<String> credentialsOps = new TwoDArrayOperations<>(credentials);
		
		// Find account
		int index = credentialsOps.findInColumn(username, 0);
		if(index == -1) {
			return false;
		}
		
		// Verify login
		if(ops_password.verifyPassword(password, credentials[index][1])) {
			System.out.println("Login succesfuly for user: " + username);
			return true;
		}else {
			System.out.println("Login failed for user: " + username);
			return false;
		}
	}
	
	public static boolean initFiles() {
		try {
			File infoFile = new File(ApplicationConfig.adminCreds);
			if(!infoFile.exists()) {
				infoFile.createNewFile();
				FileWriter writer = new FileWriter(infoFile);
				writer.write("admin₷" + ops_password.hashPassword(ApplicationConfig.getAdminDefaultPassword()));
				writer.close();
			} 
			
			infoFile = new File(ApplicationConfig.studentAccountCreds);
			if(!infoFile.exists()) {
				infoFile.createNewFile();
			} 
			
			infoFile = new File(ApplicationConfig.studentInformation);
			if(!infoFile.exists()) {
				infoFile.createNewFile();
			} 
			
			infoFile = new File(ApplicationConfig.nextID);
			if(!infoFile.exists()) {
				infoFile.createNewFile();
				FileWriter writer = new FileWriter(infoFile);
				writer.write("000001");
				writer.close();
			} 
			
		}catch(IOException e) {
			
		}
		return true;
	}
	
	static LoginUser loginUser = new LoginUser();
	public static void main(String[] args) {
		initFiles();
		// Developing AdminWindow
		AdminWindow adminWindow = new AdminWindow(loginUser.themeMode, "admin1");
		adminWindow.setVisible(true);
//		loginUser.setVisible(true);
//
//		loginUser.loginBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String username = loginUser.usernameField.getText();
//				String password =  new String(loginUser.pwField.getPassword()).trim();
//				
//				// No operation if one of the fields are empty
//				if(username.isEmpty() || password.isEmpty()) {
//					return;
//				}
//				
//				boolean isAuthenticated = authenticateUser(username, password);
//				
//				if(isAuthenticated) {
//					String loginAs = loginUser.loginRole;
//					if(loginAs.equals("user")) {
//						
//					}else if(loginAs.equals("admin")) {
//						AdminWindow adminWindow = new AdminWindow(loginUser.themeMode, username);
//						loginUser.dispose();
//						try {Thread.sleep(1000);} catch (InterruptedException ie) {ie.printStackTrace();}
//						adminWindow.setVisible(isAuthenticated);						
//					}
//					
//					
//				} else {
//					JDialog dialog = new JDialog(loginUser, "Alert", true);
//					dialog.setSize(220, 100);
//					dialog.add(new JLabel("Incorrect username or password"));
//					dialog.setLocationRelativeTo(null);
//					dialog.setVisible(true);
//				}
//			}
//		});
	}

}
