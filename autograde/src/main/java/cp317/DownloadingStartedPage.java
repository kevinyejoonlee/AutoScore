package cp317;

import javax.swing.*;
import java.awt.*;

public class DownloadingStartedPage extends JFrame {
    public DownloadingStartedPage() {
        setTitle("Complete");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel("Complete");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 24));
        messageLabel.setForeground(Color.GREEN);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(messageLabel, BorderLayout.CENTER);

        getContentPane().setBackground(Color.DARK_GRAY);

        Dimension preferredSize = new Dimension(500, 300);
        getContentPane().setPreferredSize(preferredSize);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
