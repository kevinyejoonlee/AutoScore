package cp317;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.SwingUtilities;

public class ArmAssemblyPage extends JFrame implements ActionListener {
    JButton button1;
    JButton button2;
    JButton goBackButton;
    JButton processButton;
    JButton button3;
    JTextField assignmentNameField;

    // method returns the name of the assignment as event
    private String getAssignmentName() {
        return assignmentNameField.getText();
    }

    // constructor for page
    public ArmAssemblyPage() {
        this.setTitle("AutoScore");
        this.getContentPane().setBackground(Color.DARK_GRAY);

        this.setLayout(new GridBagLayout());

        // PANEL for title and go back button
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.DARK_GRAY);

        // go back
        goBackButton = new JButton("Go Back");
        goBackButton.addActionListener(this);
        titlePanel.add(goBackButton);

        // title
        JLabel title = new JLabel("ARM");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(title);

        // add titlePanel to the frame
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(30, 10, 10, 10);
        this.add(titlePanel, gbc);

        // panel for buttons on left
        JPanel filePanel = new JPanel();
        filePanel.setLayout(new GridBagLayout());
        filePanel.setBackground(Color.DARK_GRAY);

        // file selec 1
        button1 = new JButton("Step 1: Student .zip");
        button1.addActionListener(this);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        filePanel.add(button1, gbc);

        // file selec 2
        button2 = new JButton("Step 2: Answers .zip");
        button2.addActionListener(this);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        filePanel.add(button2, gbc);

        // file selec 3 empty folders
        button3 = new JButton("Step 3: Empty Calculations Folder");
        button3.addActionListener(this);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        filePanel.add(button3, gbc);

        // textbox attributes
        assignmentNameField = new JTextField(20);
        assignmentNameField.setText("Assignment Name");
        assignmentNameField.setForeground(Color.GRAY);
        assignmentNameField.addFocusListener(new FocusListener() {

            // clears textbox when clicked method
            @Override
            public void focusGained(FocusEvent e) {

                if (assignmentNameField.getText().equals("Assignment Name")) {
                    assignmentNameField.setText("");
                    assignmentNameField.setForeground(Color.BLACK);
                }
            }

            // method for when you click off the textbox
            @Override
            public void focusLost(FocusEvent e) {

                if (assignmentNameField.getText().isEmpty()) {
                    assignmentNameField.setText("Assignment Name");
                    assignmentNameField.setForeground(Color.GRAY);
                }
            }
        });

        assignmentNameField.setBackground(Color.WHITE);
        assignmentNameField.setHorizontalAlignment(JTextField.CENTER);

        // adds textbox to left frame
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        filePanel.add(assignmentNameField, gbc);

        // process
        processButton = new JButton("Process");
        processButton.addActionListener(this);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        filePanel.add(processButton, gbc);

        // add the filePanel to the frame
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(filePanel, gbc);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(500, 300);
        this.setVisible(true);
    }

    // ACTIONS
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("ZIP Files", "zip"));

        if (e.getSource() == button1) {
            int response = fileChooser.showOpenDialog(this);
            if (response == JFileChooser.APPROVE_OPTION) {
                // PRINTS dir student zip location
                File file = fileChooser.getSelectedFile();
                System.out.println(file);

            }
        } else if (e.getSource() == button2) {
            int response = fileChooser.showOpenDialog(this);
            if (response == JFileChooser.APPROVE_OPTION) {
                // PRINTS dir answers zip
                File file = fileChooser.getSelectedFile();
                System.out.println(file); //
            }
        } else if (e.getSource() == button3) {

            JFileChooser folderChooser = new JFileChooser();
            folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int response = folderChooser.showOpenDialog(this);
            if (response == JFileChooser.APPROVE_OPTION) {
                // PRINTS empty folders for assignments
                File folder = folderChooser.getSelectedFile();
                System.out.println(folder); //
            }
        } else if (e.getSource() == processButton) {
            // ASSSIGNMENT NAME FOR EXCEL
            String assignmentName = getAssignmentName();

            System.out.println(assignmentName);

            dispose();
        } else if (e.getSource() == goBackButton) {
            new CodeLanguageSelection();
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JavaPage());
    }
}
