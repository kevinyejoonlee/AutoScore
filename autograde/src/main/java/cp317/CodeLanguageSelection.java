package cp317;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CodeLanguageSelection extends JFrame implements ActionListener {
    public CodeLanguageSelection() {

        setTitle("Language Selection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(1000, 500);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.DARK_GRAY);

        // course buttons
        JButton javaButton = new JButton("JAVA");
        javaButton.addActionListener(this);
        addButton(panel, javaButton, 0, 0);

        JButton armAssemblyButton = new JButton("ARM ASSEMBLY");
        armAssemblyButton.addActionListener(this);
        addButton(panel, armAssemblyButton, 0, 1);

        JButton cPlusPlusButton = new JButton("C/C++");
        cPlusPlusButton.addActionListener(this);
        addButton(panel, cPlusPlusButton, 0, 2);

        JButton pythonButton = new JButton("PYTHON");
        pythonButton.addActionListener(this);
        addButton(panel, pythonButton, 0, 3);

        JButton javaScriptButton = new JButton("JAVA SCRIPT");
        javaScriptButton.addActionListener(this);
        addButton(panel, javaScriptButton, 0, 4);

        // logout
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(this);
        addButton(panel, logoutButton, 0, 5);

        // align buttons
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;

        add(panel);

        setVisible(true);
    }

    // constraints
    private void addButton(JPanel panel, JButton button, int gridx, int gridy) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(button, constraints);
    }

    // ACTIONS
    @Override
    public void actionPerformed(ActionEvent e) {
        String courseName = e.getActionCommand();

        if (courseName.equals("JAVA")) {
            new JavaPage();
        } else if (courseName.equals("ARM ASSEMBLY")) {
            new ArmAssemblyPage();
        } else if (courseName.equals("C/C++")) {
            new LoginPage();
        } else if (courseName.equals("PYTHON")) {
            new LoginPage();
        } else if (courseName.equals("JAVA SCRIPT")) {
            new LoginPage();
        } else if (courseName.equals("Logout")) {
            new LoginPage();
        }

        dispose();
    }

}
