package windows;

import java.awt.*;
import javax.swing.*;
import components.*;
import main.ApplicationConfig;
import main.FileOperations;

public class AdminWindow extends JFrame{	
	int themeMode;
	
	JPanel northPanel = new JPanel();
		JPanel innerNorthPanelLeft = new JPanel();
			JTextField searchField = new JTextField(20);
			JButton searchBtn = new JButton("Search");
			
		JPanel innerNorthPanelRight = new JPanel();
			JButton editBtn = new JButton("Edit");
			JButton deleteBtn = new JButton("Delete");
			JButton logoutBtn = new JButton("Logout");
		
	JPanel centerPanel = new JPanel();
		JPanel innerLeftCenterPanel = new JPanel();
		JPanel innerRightCenterPanel = new JPanel();
		JSplitPane centerPanelSplit = new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT,
				innerLeftCenterPanel,
				innerRightCenterPanel
		);
				
	JPanel southPanel = new JPanel();
	
	public AdminWindow(int themeMode, String signedInAs){
		setMainFrameProperties(signedInAs);
		
		// 								Debugging Purpose
		northPanel.setBackground(Color.RED);
		centerPanel.setBackground(Color.BLUE);
		// 								Debugging Purpose
		
		{// NorthPanel
			northPanel.setLayout(new BorderLayout());
			
			innerNorthPanelLeft.add(searchField);
			innerNorthPanelLeft.add(searchBtn);
			
			innerNorthPanelRight.add(editBtn);
			innerNorthPanelRight.add(deleteBtn);
			innerNorthPanelRight.add(new JLabel("     "));
			innerNorthPanelRight.add(logoutBtn);

			
			northPanel.add(innerNorthPanelRight, BorderLayout.EAST);
			northPanel.add(innerNorthPanelLeft, BorderLayout.WEST);
		}
		
		{// Center Panel 
			// Debugging Only
			innerLeftCenterPanel.setBackground(Color.CYAN);
			innerRightCenterPanel.setBackground(Color.MAGENTA);
			// Debugging Only
			
			centerPanel.setLayout(new GridLayout());
			centerPanelSplit.setResizeWeight(.10);
			centerPanelSplit.setDividerSize(0);
			
			// Inner Left Center Panel
			innerLeftCenterPanel.setLayout(new GridLayout());
			FileOperations fo = new FileOperations(ApplicationConfig.studentInformation);
			String[][] studentArray = fo.to2dArray(3, "\\|", "&&");
			
			for(String[] student : studentArray) {
				System.out.println(student[0] + " " + student[1] + " " + student[2]);
			}
			
			StudentTableComponent studentTable = new StudentTableComponent(studentArray);
			innerLeftCenterPanel.add(studentTable);
			
			centerPanel.add(centerPanelSplit);
		}
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		//add(southPanel, BorderLayout.SOUTH);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setMainFrameProperties(String signedInAs) {
		this.themeMode = themeMode;
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setTitle("Signed in as: " + signedInAs);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
