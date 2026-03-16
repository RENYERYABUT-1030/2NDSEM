package windowsbuilderguided; // guided no.7



import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class FruitSelector {

    private JFrame frmJlistExample;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FruitSelector window = new FruitSelector();
                window.frmJlistExample.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FruitSelector() {
        initialize();
    }

    private void initialize() {
        frmJlistExample = new JFrame();
        frmJlistExample.setTitle("JList Example");
        frmJlistExample.setBounds(100, 100, 400, 279);
        frmJlistExample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmJlistExample.getContentPane().setLayout(null);

        JLabel lblSelectFruits = new JLabel("Select Fruits:");
        lblSelectFruits.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSelectFruits.setBounds(20, 20, 100, 30);
        frmJlistExample.getContentPane().add(lblSelectFruits);

        // JList with multiple selection mode
        String[] fruits = {"Apple", "Banana", "Orange", "Mango", "Grape"};
        JList<String> lstFruits = new JList<>(fruits);
        lstFruits.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lstFruits.setBounds(20, 60, 150, 100);
        lstFruits.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        frmJlistExample.getContentPane().add(lstFruits);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSubmit.setBounds(200, 60, 100, 30);
        frmJlistExample.getContentPane().add(btnSubmit);

        JLabel lblResult = new JLabel("<output here>");
        lblResult.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblResult.setBounds(20, 180, 300, 30);
        frmJlistExample.getContentPane().add(lblResult);

        // Action Listener para makuha ang lahat ng napiling prutas
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<String> selectedFruits = lstFruits.getSelectedValuesList();
                lblResult.setText("Selected Fruits: " + String.join(", ", selectedFruits));
            }
        });
    }
}
