package cp317;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeightingsPage extends JFrame {
    private String assignmentName;
    private String[] tasks;
    private double[] weights;
    private Boolean boolForCorrectCalculations = false;

    public WeightingsPage(String assignmentName, String[] tasks, double[] weights) {
        this.assignmentName = assignmentName;
        this.tasks = tasks;
        this.weights = weights;

        initComponents();
    }

    private void initComponents() {
        setTitle("Assignment Weightings");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.DARK_GRAY);

        JRootPane rootPane = this.getRootPane();
        rootPane.setBackground(Color.WHITE);

        JPanel headerPanel = new JPanel();
        JLabel assignmentLabel = new JLabel("Assignment Name: " + assignmentName);
        headerPanel.add(assignmentLabel);
        assignmentLabel.setForeground(Color.WHITE);
        headerPanel.setBackground(Color.DARK_GRAY);
        add(headerPanel, BorderLayout.NORTH);

        String[] columnNames = { "Tasks", "Weight" };
        Object[][] data = new Object[tasks.length][2];

        for (int i = 0; i < tasks.length; i++) {
            data[i][0] = tasks[i];
            data[i][1] = weights[i];
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);

        JTextField weightTextField = new JTextField();
        TableColumn weightColumn = table.getColumnModel().getColumn(1);
        weightColumn.setCellEditor(new DefaultCellEditor(weightTextField));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // ACTION
        JButton newPageButton = new JButton("Run and Download CSV");
        newPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weights = getUpdatedWeights(); // updated weights
                boolForCorrectCalculations = true;
                if (boolForCorrectCalculations == false) {
                    new FileInputIncorrectPage();
                } else {

                    boolForCorrectCalculations = true;
                    if (boolForCorrectCalculations) {
                        new DownloadingStartedPage();
                        control.controlPanel(assignmentName, tasks, weights);
                    }
                }

                dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newPageButton);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private double[] getUpdatedWeights() {
        double[] updatedWeights = new double[tasks.length];
        JTable table = (JTable) ((JScrollPane) getContentPane().getComponent(1)).getViewport().getView();

        for (int i = 0; i < tasks.length; i++) {
            Object value = table.getValueAt(i, 1);
            if (value instanceof String) {
                try {
                    updatedWeights[i] = Double.parseDouble((String) value);
                } catch (NumberFormatException ex) {

                    return null;
                }
            }
        }

        return updatedWeights;
    }
}
