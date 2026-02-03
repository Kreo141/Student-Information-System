package windows;

import java.awt.*;
import javax.swing.*;

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
