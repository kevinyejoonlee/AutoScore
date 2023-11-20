package cp317;

import javax.swing.*;
import java.awt.*;

public class FileInputIncorrectPage extends JFrame {
    public FileInputIncorrectPage() {
        setTitle("ERROR 444");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel("Something went wrong");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 24));
        messageLabel.setForeground(Color.RED);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(messageLabel, BorderLayout.CENTER);

        getContentPane().setBackground(Color.DARK_GRAY);

        Dimension preferredSize = new Dimension(300, 150);
        getContentPane().setPreferredSize(preferredSize);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}