package windowsbuilderguided;

// guided no.5

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class AgeSelection {

    private JFrame frmJspinnerExample;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AgeSelection window = new AgeSelection();
                window.frmJspinnerExample.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public AgeSelection() {
        initialize();
    }

    private void initialize() {
        frmJspinnerExample = new JFrame();
        frmJspinnerExample.setTitle("JSpinner Example");
        frmJspinnerExample.setBounds(100, 100, 289, 211);
        frmJspinnerExample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmJspinnerExample.getContentPane().setLayout(null);

        JLabel lblAge = new JLabel("Select Age:");
        lblAge.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblAge.setBounds(30, 30, 100, 30);
        frmJspinnerExample.getContentPane().add(lblAge);

        // Spinner with range 1 to 100, starting at 1
        JSpinner spnAge = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        spnAge.setFont(new Font("Tahoma", Font.PLAIN, 12));
        spnAge.setBounds(100, 30, 50, 30);
        frmJspinnerExample.getContentPane().add(spnAge);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSubmit.setBounds(30, 80, 100, 30);
        frmJspinnerExample.getContentPane().add(btnSubmit);

        JLabel lblResult = new JLabel("<output here>");
        lblResult.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblResult.setBounds(30, 130, 200, 30);
        frmJspinnerExample.getContentPane().add(lblResult);

        // Action Listener para makuha ang value mula sa JSpinner
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int age = (int) spnAge.getValue();
                lblResult.setText("Selected Age: " + age);
            }
        });
    }
}