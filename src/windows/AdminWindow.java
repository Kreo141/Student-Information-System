package windows;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;

public class AdminWindow extends JFrame{	
	int themeMode;
	
	JPanel northPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel southPanel = new JPanel();
	
	public AdminWindow(int themeMode, String signedInAs){
		setMainFrameProperties(signedInAs);
		
		northPanel.setBackground(Color.RED);
		centerPanel.setBackground(Color.BLUE);
		
		
		add(northPanel);
		add(centerPanel);
		add(southPanel);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setMainFrameProperties(String signedInAs) {
		this.themeMode = themeMode;
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setTitle("Signed in as: " + signedInAs);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
