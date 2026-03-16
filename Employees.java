package windowsbuilderguided;

// guided no.11



import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Employees extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Employees window = new Employees();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Employees() {
        setTitle("TRANSACTION");
        initialize();
    }

    private void initialize() {
        // Frame setup
        new JFrame("Employee Table");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Table Model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Position");

        // Adding Rows
        model.addRow(new Object[]{"101", "Darrel", "23", "Developer"});
        model.addRow(new Object[]{"102", "Raine", "18", "Designer"});
        model.addRow(new Object[]{"103", "Railynne", "20", "QA Specialist"});
        model.addRow(new Object[]{"104", "Dorie", "25", "Supervisor"});
        model.addRow(new Object[]{"105", "Roel", "30", "Manager"});

        // Creating JTable with model
        JTable tblEmployee = new JTable(model);

        // Adding JTable to JScrollPane
        JScrollPane sp = new JScrollPane(tblEmployee);
        getContentPane().add(sp);

        // Make frame visible
        setVisible(true);
    }
}