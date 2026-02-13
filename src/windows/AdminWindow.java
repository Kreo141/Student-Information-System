package windows;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import components.*;
import main.ApplicationConfig;
import functions.FileOperations;

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
			JPanel infoCardPanel = new JPanel();
				
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
			
			searchField.setToolTipText("ID, name, or email");
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
			centerPanelSplit.setResizeWeight(.05);
			centerPanelSplit.setDividerSize(0);
			
			// Inner Left Center Panel
			{
				innerLeftCenterPanel.setLayout(new GridLayout());
				FileOperations fo = new FileOperations(ApplicationConfig.studentInformation);
				String[][] studentArray = fo.to2dArray(3, "\\|", "&&");
				
				for(String[] student : studentArray) {
					System.out.println(student[0] + " " + student[1] + " " + student[2]);
				}
				
				StudentTableComponent studentTable = new StudentTableComponent(studentArray);
				innerLeftCenterPanel.add(studentTable);
				
				TableRowSorter<DefaultTableModel> sorter =
				        new TableRowSorter<>(studentTable.getModel());
				
				studentTable.getTable().setRowSorter(sorter);
				
				searchBtn.addActionListener(e -> {
					String text = searchField.getText();
					System.out.println("WHYYY");
					if(text.trim().length() == 0) {
						sorter.setRowFilter(null);
					} else {
						System.out.println("Searching");
						sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(text)));
					}
				});
				
				searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
				    public void insertUpdate(javax.swing.event.DocumentEvent e){ filter(); }
				    public void removeUpdate(javax.swing.event.DocumentEvent e){ filter(); }
				    public void changedUpdate(javax.swing.event.DocumentEvent e){ filter(); }
	
				    private void filter() {
				        String text = searchField.getText();
	
				        if (text.trim().length() == 0)
				            sorter.setRowFilter(null);
				        else
				            sorter.setRowFilter(RowFilter.regexFilter(
				                "(?i)" + Pattern.quote(text)
				            ));
				    }
				});
				
				studentTable.getTable().addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						int row = studentTable.getTable().getSelectedRow();
						
						if(row != -1) {
							String id = studentTable.getTable().getValueAt(row, 0).toString();
							String name = studentTable.getTable().getValueAt(row, 1).toString();
							String email = studentTable.getTable().getValueAt(row, 2).toString();
							
							System.out.printf("Displaying: %s %s %s\n", id, name, email);
							System.out.printf("Row visual: %d\n", row);
						}
					}
				});
			}
			
			
			// INNER RIGHT CENTER
			{
				innerRightCenterPanel.setLayout(new GridLayout(1,5));
				innerRightCenterPanel.add(new DrawImagePanel());
				innerRightCenterPanel.add(new DrawImagePanel());
				innerRightCenterPanel.add(new DrawImagePanel());
				innerRightCenterPanel.add(new DrawImagePanel());
			}
			
			
			
			
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


class DrawImagePanel extends JPanel {
    Image img = new ImageIcon("E:\\ChromeDownload\\SCHOOL FILES\\images.png").getImage();

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 70, 70, this); // x, y position
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Image");
        frame.add(new DrawImagePanel());
        frame.setBackground(Color.BLACK);
        
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

