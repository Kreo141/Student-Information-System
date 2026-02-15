package windows;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import components.*;
import main.ApplicationConfig;
import main.Student;
import functions.FileOperations;
import functions.StudentOperation;

public class AdminWindow extends JFrame {

    // =====================================================
    // FIELDS
    // =====================================================
    int themeMode;

    StudentOperation ops_Student = new StudentOperation();

    StudentTableComponent studentTable;
    TableRowSorter<DefaultTableModel> sorter;

    
    // ---------- NORTH PANEL ----------
    JPanel northPanel = new JPanel();

        JPanel innerNorthPanelLeft = new JPanel();
            JTextField searchField = new JTextField(20);
            JButton searchBtn = new JButton("Search");
            
        JPanel innerNorthPanelCenter = new JPanel();
        	JButton registerStudentBtn = new JButton("Register Student");

        JPanel innerNorthPanelRight = new JPanel();
            JButton editBtn = new JButton("Edit");
            JButton deleteBtn = new JButton("Delete");
            JButton logoutBtn = new JButton("Logout");

    // ---------- CENTER PANEL ----------
    JPanel centerPanel = new JPanel();

        JPanel innerLeftCenterPanel = new JPanel();
        JPanel innerRightCenterPanel = new JPanel();

            DrawImagePanel image = new DrawImagePanel();

            JLabel nameLabel = new JLabel("Null, Null N.");
            JLabel idLabel = new JLabel("569784");
            JLabel emailLabel = new JLabel("null@example.coms");
            JLabel programLabel = new JLabel("NULL");
            JLabel yearLabel = new JLabel("NULL");

        JSplitPane centerPanelSplit = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                innerLeftCenterPanel,
                innerRightCenterPanel
        );

    // ---------- SOUTH PANEL ----------
    JPanel southPanel = new JPanel();


    // =====================================================
    // CONSTRUCTOR
    // =====================================================
    public AdminWindow(int themeMode, String signedInAs) {

        setMainFrameProperties(signedInAs);

        // Debugging colors
        northPanel.setBackground(Color.RED);
        centerPanel.setBackground(Color.BLUE);

        // =================================================
        // NORTH PANEL
        // =================================================
        {
            northPanel.setLayout(new BorderLayout());

            searchField.setToolTipText("ID, name, or email");
            innerNorthPanelLeft.add(searchField);
            innerNorthPanelLeft.add(searchBtn);

            // CENTER
            {
            	registerStudentBtn.addActionListener(e -> {
            		ops_Student.register("Cjay", "x.example@umindanao.edu.ph", "BS Information Technology", "1st Year");
            		
            		refreshStudentTable();
            	});
            }
            innerNorthPanelCenter.add(registerStudentBtn);
            
            innerNorthPanelRight.add(editBtn);
            innerNorthPanelRight.add(deleteBtn);
            innerNorthPanelRight.add(new JLabel("     "));
            innerNorthPanelRight.add(logoutBtn);

            northPanel.add(innerNorthPanelRight, BorderLayout.EAST);
            northPanel.add(innerNorthPanelCenter, BorderLayout.CENTER);
            northPanel.add(innerNorthPanelLeft, BorderLayout.WEST);
        }

        // =================================================
        // CENTER PANEL
        // =================================================
        {
            // Debugging colors
            innerLeftCenterPanel.setBackground(Color.CYAN);
            innerRightCenterPanel.setBackground(Color.MAGENTA);

            centerPanel.setLayout(new GridLayout());
            centerPanelSplit.setResizeWeight(.05);
            centerPanelSplit.setDividerSize(0);

            // =============================================
            // LEFT CENTER (TABLE)
            // =============================================
            {
                innerLeftCenterPanel.setLayout(new GridLayout());

                Student[] students = ops_Student.get();
                studentTable = new StudentTableComponent(students);

                innerLeftCenterPanel.add(studentTable);

                sorter = new TableRowSorter<>(studentTable.getModel());

                studentTable.getTable().setRowSorter(sorter);

                // Search button filter
                searchBtn.addActionListener(e -> {
                    String text = searchField.getText();

                    if (text.trim().length() == 0)
                        sorter.setRowFilter(null);
                    else
                        sorter.setRowFilter(
                                RowFilter.regexFilter("(?i)" + Pattern.quote(text))
                        );
                });

                // Live search filter
                searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                    public void insertUpdate(javax.swing.event.DocumentEvent e) { filter(); }
                    public void removeUpdate(javax.swing.event.DocumentEvent e) { filter(); }
                    public void changedUpdate(javax.swing.event.DocumentEvent e) { filter(); }

                    private void filter() {
                        String text = searchField.getText();

                        if (text.trim().length() == 0)
                            sorter.setRowFilter(null);
                        else
                            sorter.setRowFilter(
                                    RowFilter.regexFilter("(?i)" + Pattern.quote(text))
                            );
                    }
                });

                // Row click → display student info
                studentTable.getTable().addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    	int viewRow = studentTable.getTable().getSelectedRow();

                    	if (viewRow != -1) {

                    	    int modelRow = studentTable.getTable()
                    	                               .convertRowIndexToModel(viewRow);

                    	    String id = studentTable.getTable()
                    	                            .getModel()
                    	                            .getValueAt(modelRow, 0)
                    	                            .toString();

                    	    Student student = ops_Student.search(id);

                    	    idLabel.setText(id);
                    	    nameLabel.setText(student.getStudentName());
                    	    emailLabel.setText(student.getEmail());
                    	    programLabel.setText(student.getProgram());
                    	    yearLabel.setText(student.getYearLevel());
                    	}

                    }
                });
            }

            // =============================================
            // RIGHT CENTER (DETAILS)
            // =============================================
            {
                innerRightCenterPanel.setLayout(new BorderLayout(0, 10));
                innerRightCenterPanel.setBackground(Color.WHITE);
                innerRightCenterPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

                // -------- TOP PANEL --------
                {
                    JPanel topPanel = new JPanel(new BorderLayout(40, 0));
                    topPanel.setOpaque(false);

                    topPanel.add(image, BorderLayout.WEST);

                    innerRightCenterPanel.add(topPanel, BorderLayout.NORTH);
                }

                // -------- BOTTOM PANEL --------
                {
                    JPanel botPanel = new JPanel(new GridBagLayout());

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.anchor = GridBagConstraints.NORTHWEST;
                    gbc.insets = new Insets(20, 20, 10, 10);
                    gbc.weightx = 1;
                    gbc.weighty = 1;

                    gbc.gridx = 0; gbc.gridy = 0;
                    botPanel.add(new JLabel("Name: "), gbc);

                    gbc.gridx = 1;
                    botPanel.add(nameLabel, gbc);

                    gbc.gridx = 0; gbc.gridy = 1;
                    botPanel.add(new JLabel("ID: "), gbc);

                    gbc.gridx = 1;
                    botPanel.add(idLabel, gbc);

                    gbc.gridx = 0; gbc.gridy = 2;
                    botPanel.add(new JLabel("EMAIL: "), gbc);

                    gbc.gridx = 1;
                    botPanel.add(emailLabel, gbc);

                    gbc.gridx = 0; gbc.gridy = 3;
                    botPanel.add(new JLabel("Program: "), gbc);

                    gbc.gridx = 1;
                    botPanel.add(programLabel, gbc);

                    gbc.gridx = 0; gbc.gridy = 4;
                    botPanel.add(new JLabel("Year: "), gbc);

                    gbc.gridx = 1;
                    botPanel.add(yearLabel, gbc);

                    Font botPanelFont = new Font("Arial", Font.BOLD, 20);

                    for (Component c : botPanel.getComponents()) {
                        if (c instanceof JLabel) {
                            c.setFont(botPanelFont);
                        }
                    }

                    innerRightCenterPanel.add(botPanel, BorderLayout.CENTER);
                }
            }

            centerPanel.add(centerPanelSplit);
        }

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }


    // =====================================================
    // FRAME SETTINGS
    // =====================================================
    public void setMainFrameProperties(String signedInAs) {
        this.themeMode = themeMode;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        setTitle("Signed in as: " + signedInAs);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    private void refreshStudentTable() {
    	ops_Student = new StudentOperation();
        Student[] students = ops_Student.get();
        studentTable.setData(students);

        sorter.setModel(studentTable.getModel()); 
    }


}


// =========================================================
// IMAGE PANEL
// =========================================================
class DrawImagePanel extends JPanel {
    Image img = new ImageIcon("E:\\ChromeDownload\\SCHOOL FILES\\images.png").getImage();

    public DrawImagePanel() {
        setPreferredSize(new Dimension(180, 180));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
