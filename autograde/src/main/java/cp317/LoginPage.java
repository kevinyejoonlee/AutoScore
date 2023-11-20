package cp317;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    public LoginPage() {
        setTitle("AutoScore - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(500, 300);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.DARK_GRAY);

        // AutoScore Title
        JLabel titleLabel = new JLabel("AutoScore");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        JTextField usernameTextField = new JTextField(20);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        JPasswordField passwordField = new JPasswordField(20);

        // Enter Button
        JButton enterButton = new JButton("Enter");

        // When you click enter set action
        ActionListener loginButtonActionListener = new LoginButtonActionListener(usernameTextField, passwordField);
        enterButton.addActionListener(loginButtonActionListener);

        // Panel allignment
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(titleLabel, gbc);

        gbc.gridy = 1;
        panel.add(usernameLabel, gbc);

        gbc.gridy = 2;
        panel.add(usernameTextField, gbc);

        gbc.gridy = 3;
        panel.add(passwordLabel, gbc);

        gbc.gridy = 4;
        panel.add(passwordField, gbc);

        gbc.gridy = 5;
        panel.add(enterButton, gbc);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}

class LoginButtonActionListener implements ActionListener {
    private JTextField usernameTextField;
    private JPasswordField passwordField;

    public LoginButtonActionListener(JTextField usernameTextField, JPasswordField passwordField) {
        this.usernameTextField = usernameTextField;
        this.passwordField = passwordField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameTextField.getText();
        String password = new String(passwordField.getPassword()); // Get the password as a string

        // Check if both fields are not empty
        if (!username.isEmpty() && !password.isEmpty()) {
            new CodeLanguageSelection();
            ((JFrame) usernameTextField.getTopLevelAncestor()).dispose(); // Close the login page
        } else {
            System.out.println("Error: Username and password cannot be empty.");
        }
    }
}
