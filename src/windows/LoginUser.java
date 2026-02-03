package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import components.ImageButton;

public class LoginUser extends JFrame{
	public String loginRole = "user";
	
	public int themeMode = 0;
	Color lightColor = Color.decode("#e6e1e1");
	Color darkColor = Color.decode("#212020");
	String btnSwitchRoleText = "Admin";
	
																																				JLabel empty = new JLabel();
	
	JPanel panel1 = new JPanel();
		JLabel header = new JLabel("STUDENT INFORMATION SYSTEM");
		
	JPanel panel2 = new JPanel();
		JPanel innerPanelLeft = new JPanel();
		
		JPanel innerPanelCenter = new JPanel();
			JPanel row1CellPanel = new JPanel(new GridBagLayout());
				JLabel loginHeader = new JLabel("Please Login");
				
			JPanel row2CellPanel = new JPanel(new GridBagLayout());
				public JTextField usernameField = new JTextField();
				
			JPanel row3CellPanel = new JPanel(new GridBagLayout());
				public JPasswordField pwField = new JPasswordField("");
				
			JPanel row4CellPanel = new JPanel(new BorderLayout());
				JLabel forgotPw = new JLabel("Forgot Password?");
			
			JPanel row5CellPanel = new JPanel(new GridBagLayout());
				public JButton loginBtn = new JButton("Login as Student");
				
			JPanel row6CellPanel = new JPanel(new GridBagLayout());
				
		JPanel innerPanelRight = new JPanel();
		
		JSplitPane innerSplit1 = new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT,
				innerPanelLeft,
				innerPanelCenter
		);
		
		JSplitPane innerSplit2 = new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT,
				innerSplit1,
				innerPanelRight
		);
	
	JPanel panel3 = new JPanel(new GridLayout(2,1));
		JPanel p3InnerPanel = new JPanel(new FlowLayout());
		JButton switchRoleBtn = new JButton("Admin");
		JButton switchTheme = new JButton("Light");
			
		    
	JSplitPane split1 = new JSplitPane(
			JSplitPane.VERTICAL_SPLIT,
			panel1,
			panel2
	);
	
	JSplitPane split2 = new JSplitPane(
			JSplitPane.VERTICAL_SPLIT,
			split1,
			panel3
	);
	
	public LoginUser(){
		toggleTheme();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBackground(Color.WHITE);
		setTitle("Login Window");
		
		panel1.setLayout(new GridBagLayout());
		{
			header.setFont(new Font("Inter", Font.BOLD, 60));
			panel1.add(header);
		}
		
		
		// Panel 1
		panel2.setLayout(new GridLayout());
		{
			// Inner Panel - Center
			innerPanelCenter.setLayout(new GridLayout(6, 1));
			innerPanelCenter.setBackground(Color.WHITE);
			{
				// Row 1 Cell Panel
				{
					row1CellPanel.setBackground(Color.white);
					
					loginHeader.setFont(new Font("Inter", Font.PLAIN, 36));
					row1CellPanel.add(loginHeader);
				}
				
				// Row 2 Cell Panel
				row2CellPanel.setBackground(Color.white);
				{
					usernameField.setFont(new Font("Inter", Font.PLAIN, 30));
					
					row2CellPanel.addComponentListener(new ComponentAdapter() {
						@Override
						public void componentResized(ComponentEvent e) {
							int width = (int) (row1CellPanel.getWidth() * 0.80);
							usernameField.setPreferredSize(new Dimension(width, 60));
							
							usernameField.revalidate();
						}
					});
					row2CellPanel.add(usernameField);
					row2CellPanel.add(usernameField);
				}

				// Row 3 Cell Panel
				row3CellPanel.setBackground(Color.white);
				{
					pwField.setFont(new Font("Inter", Font.PLAIN, 30));
					
					row3CellPanel.addComponentListener(new ComponentAdapter() {
						@Override
						public void componentResized(ComponentEvent e) {
							int width = (int) (row3CellPanel.getWidth() * 0.80);
							pwField.setPreferredSize(new Dimension(width, 60));
							
							pwField.revalidate();
						}
					});
					row3CellPanel.add(pwField);
				}

				// Row 4 Cell Panel
				row4CellPanel.setBackground(Color.white);
				{
					forgotPw.setBorder(BorderFactory.createEmptyBorder(0, 55, 0, 0));
					row4CellPanel.add(forgotPw, BorderLayout.WEST);
				}
				
				// Row 5 Cell Panel
				row5CellPanel.setBackground(Color.white);
				{
					loginBtn.addComponentListener(new ComponentAdapter() {
						@Override
						public void componentResized(ComponentEvent e) {
							int width = (int) (row5CellPanel.getWidth() * 0.30);
							loginBtn.setPreferredSize(new Dimension(width, 50));
							
							loginBtn.revalidate();
						}
					});
					
					row5CellPanel.add(loginBtn);
				}
				
				innerPanelCenter.add(row1CellPanel);
				innerPanelCenter.add(row2CellPanel);
				innerPanelCenter.add(row3CellPanel);
				innerPanelCenter.add(row4CellPanel);
				innerPanelCenter.add(row5CellPanel);
				innerPanelCenter.add(row6CellPanel);
			}
			
			// Inner Split 1
			innerSplit1.setResizeWeight(.70);
			innerSplit1.setDividerSize(0);
			
			// Inner Split 2
			innerSplit2.setResizeWeight(.59);
			innerSplit2.setDividerSize(0);
			
			panel2.add(innerSplit2);
		}
		
			// Inner Panel Right
		
		// Panel 3
		
		{	
			p3InnerPanel.add(switchRoleBtn);
			p3InnerPanel.add(switchTheme);
		}
		panel3.add(empty);
		panel3.add(p3InnerPanel);
		
		// Split 1
		split1.setResizeWeight(0.30);
		split1.setDividerSize(0);
		
		// Split 2
		split2.setResizeWeight(0.80);
		split2.setDividerSize(0);
		
		add(split2);
		
		// Component Listeners
		switchRoleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchLoginRole();
			}
		});
		
		switchTheme.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toggleTheme();
			}
		});
		
		// Other Initializations
		removeBorder();
		empty.setVisible(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void toggleTheme() {
		switch(themeMode) {
			case 0:
				setBackground(lightColor);
				panel1.setBackground(lightColor);
				header.setForeground(Color.BLACK);
			
				panel2.setBackground(lightColor);
				innerPanelLeft.setBackground(lightColor);
				innerPanelCenter.setBackground(lightColor);
				row6CellPanel.setBackground(lightColor);
				innerPanelRight.setBackground(lightColor);
				
				panel3.setBackground(lightColor);
				p3InnerPanel.setBackground(lightColor);
				
				themeMode = 1;
				break;

			case 1:
				setBackground(darkColor);
				panel1.setBackground(darkColor);
				header.setForeground(Color.WHITE);
			
				panel2.setBackground(darkColor);
				innerPanelLeft.setBackground(darkColor);
				innerPanelCenter.setBackground(darkColor);
				row6CellPanel.setBackground(darkColor);
				innerPanelRight.setBackground(darkColor);
				
				panel3.setBackground(darkColor);
				p3InnerPanel.setBackground(darkColor);
				
				themeMode = 0;
				break;
		}
	}
	
	void switchLoginRole() {
		switch(loginRole) {
			case "user":
				header.setText("SIS ADMIN");
				forgotPw.setVisible(false);
				loginBtn.setText("Login as Admin");
				switchRoleBtn.setText("Student");
				
				loginRole = "admin";
				break;
			case "admin":
				header.setText("STUDENT INFORMATION SYSTEM");
				forgotPw.setVisible(true);
				loginBtn.setText("Login as student");
				switchRoleBtn.setText("Admin");
				
				loginRole = "user";
				break;
		}
	}

	void removeBorder() {
		JComponent[] componentsToRemoveBorder = {innerPanelLeft, innerPanelCenter, innerPanelRight, row1CellPanel, row2CellPanel, row3CellPanel, split1, split2, innerSplit1, innerSplit2};
		for(JComponent component : componentsToRemoveBorder) {
			component.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		}
	}
}