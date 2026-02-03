package main;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;

import javax.swing.*;


public class GUI {

}

//class LoginUser extends JFrame{
//	int themeMode = 0;
//	Color lightColor = Color.decode("#e6e1e1");
//	Color darkColor = Color.decode("#212020");
//	String btnSwitchRoleText = "Admin";
//	
//	JPanel panel1 = new JPanel();
//		JLabel header = new JLabel("STUDENT INFORMATION SYSTEM");
//		
//	JPanel panel2 = new JPanel();
//		JPanel innerPanelLeft = new JPanel();
//		
//		JPanel innerPanelCenter = new JPanel();
//			JPanel row1CellPanel = new JPanel(new GridBagLayout());
//				JLabel loginHeader = new JLabel("Please Login");
//				
//			JPanel row2CellPanel = new JPanel(new GridBagLayout());
//				JTextField usernameField = new JTextField();
//				
//			JPanel row3CellPanel = new JPanel(new GridBagLayout());
//				JPasswordField pwField = new JPasswordField("");
//				
//			JPanel row4CellPanel = new JPanel(new BorderLayout());
//				JLabel forgotPw = new JLabel("Forgot Password?");
//			
//			JPanel row5CellPanel = new JPanel(new GridBagLayout());
//				JButton loginBtn = new JButton("LOGIN");
//				
//			JPanel row6CellPanel = new JPanel(new GridBagLayout());
//				
//		JPanel innerPanelRight = new JPanel();
//		
//		JSplitPane innerSplit1 = new JSplitPane(
//				JSplitPane.HORIZONTAL_SPLIT,
//				innerPanelLeft,
//				innerPanelCenter
//		);
//		
//		JSplitPane innerSplit2 = new JSplitPane(
//				JSplitPane.HORIZONTAL_SPLIT,
//				innerSplit1,
//				innerPanelRight
//		);
//	
//	JPanel panel3 = new JPanel(new BorderLayout());
//		JPanel p3InnerPanel = new JPanel(new GridLayout(2,1));
//			
//		    
//	JSplitPane split1 = new JSplitPane(
//			JSplitPane.VERTICAL_SPLIT,
//			panel1,
//			panel2
//	);
//	
//	JSplitPane split2 = new JSplitPane(
//			JSplitPane.VERTICAL_SPLIT,
//			split1,
//			panel3
//	);
//	
//	LoginUser(){
//		toggleTheme();
//		setSize(500000, 50000);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		setBackground(Color.WHITE);
//		
//		
//		panel1.setLayout(new GridBagLayout());
//		{
//			header.setFont(new Font("Inter", Font.BOLD, 60));
//			panel1.add(header);
//		}
//		
//		
//		// Panel 1
//		panel2.setLayout(new GridLayout());
//		{
//			// Inner Panel - Center
//			innerPanelCenter.setLayout(new GridLayout(6, 1));
//			innerPanelCenter.setBackground(Color.WHITE);
//			{
//				// Row 1 Cell Panel
//				{
//					row1CellPanel.setBackground(Color.white);
//					
//					loginHeader.setFont(new Font("Inter", Font.PLAIN, 36));
//					row1CellPanel.add(loginHeader);
//				}
//				
//				// Row 2 Cell Panel
//				row2CellPanel.setBackground(Color.white);
//				{
//					usernameField.setFont(new Font("Inter", Font.PLAIN, 30));
//					
//					row2CellPanel.addComponentListener(new ComponentAdapter() {
//						@Override
//						public void componentResized(ComponentEvent e) {
//							int width = (int) (row1CellPanel.getWidth() * 0.80);
//							usernameField.setPreferredSize(new Dimension(width, 60));
//							
//							usernameField.revalidate();
//						}
//					});			
//					row2CellPanel.add(usernameField);
//				}
//
//				// Row 3 Cell Panel
//				row3CellPanel.setBackground(Color.white);
//				{
//					pwField.setFont(new Font("Inter", Font.PLAIN, 30));
//					
//					row3CellPanel.addComponentListener(new ComponentAdapter() {
//						@Override
//						public void componentResized(ComponentEvent e) {
//							int width = (int) (row3CellPanel.getWidth() * 0.80);
//							pwField.setPreferredSize(new Dimension(width, 60));
//							
//							pwField.revalidate();
//						}
//					});
//					row3CellPanel.add(pwField);
//				}
//
//				// Row 4 Cell Panel
//				row4CellPanel.setBackground(Color.white);
//				{
//					forgotPw.setBorder(BorderFactory.createEmptyBorder(0, 55, 0, 0));
//					row4CellPanel.add(forgotPw, BorderLayout.WEST);
//				}
//				
//				// Row 5 Cell Panel
//				row5CellPanel.setBackground(Color.white);
//				{
//					loginBtn.addComponentListener(new ComponentAdapter() {
//						@Override
//						public void componentResized(ComponentEvent e) {
//							int width = (int) (row5CellPanel.getWidth() * 0.30);
//							loginBtn.setPreferredSize(new Dimension(width, 50));
//							
//							loginBtn.revalidate();
//						}
//					});
//					
//					row5CellPanel.add(loginBtn);
//				}
//				
//				innerPanelCenter.add(row1CellPanel);
//				innerPanelCenter.add(row2CellPanel);
//				innerPanelCenter.add(row3CellPanel);
//				innerPanelCenter.add(row4CellPanel);
//				innerPanelCenter.add(row5CellPanel);
//				innerPanelCenter.add(row6CellPanel);
//			}
//			
//			// Inner Split 1
//			innerSplit1.setResizeWeight(.80);
//			innerSplit1.setDividerSize(0);
//			
//			// Inner Split 2
//			innerSplit2.setResizeWeight(.59);
//			innerSplit2.setDividerSize(0);
//			
//			panel2.add(innerSplit2);
//		}
//		
//			// Inner Panel Right
//		
//		// Panel 3
//		
//		{
//			p3InnerPanel.setLayout(new BorderLayout());
//
//			
//			p3InnerPanel.add(new JLabel("KASDASD"));
//			
//		}
//		panel3.add(new JLabel());
//		panel3.add(p3InnerPanel);
//		
//		// Split 1
//		split1.setResizeWeight(0.30);
//		split1.setDividerSize(0);
//		
//
//		// Split 2
//		split2.setResizeWeight(0.80);
//		split2.setDividerSize(0);
//		
//		add(split2);
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		// TEMPORARY
//		forgotPw.addMouseListener(new MouseAdapter() {
//		    @Override
//		    public void mouseClicked(MouseEvent e) {
//		    	toggleTheme();
//		    }
//		});
//	}
//	
//	public void toggleTheme() {
//		switch(themeMode) {
//			case 0:
//				panel1.setBackground(lightColor);
//				header.setForeground(Color.BLACK);
//			
//				panel2.setBackground(lightColor);
//				innerPanelLeft.setBackground(lightColor);
//				innerPanelCenter.setBackground(lightColor);
//				row6CellPanel.setBackground(lightColor);
//				innerPanelRight.setBackground(lightColor);
//				
//				panel3.setBackground(lightColor);
//				
//				themeMode = 1;
//				break;
//
//			case 1:
//				panel1.setBackground(darkColor);
//				header.setForeground(Color.WHITE);
//			
//				panel2.setBackground(darkColor);
//				innerPanelLeft.setBackground(darkColor);
//				innerPanelCenter.setBackground(darkColor);
//				row6CellPanel.setBackground(darkColor);
//				innerPanelRight.setBackground(darkColor);
//				
//				panel3.setBackground(darkColor);
//				
//				themeMode = 0;
//				break;
//		}
//	}
//}