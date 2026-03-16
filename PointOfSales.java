package posystm;



import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// 1. Requirement: Use extends Frame (JFrame) at implement ActionListener
public class PointOfSales extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    // Components
    private JComboBox<String> cmbItems;
    private JSpinner spinnerQty;
    private JTable table;
    private DefaultTableModel model;
    private JLabel lblTotal;
    private JButton btnAdd, btnRemove, btnCalculate;

   
    private String[] fruits = {"Apple", "Banana", "Orange", "Mango", "Grapes", "Watermelon"};
    private double[] prices = {25.00, 10.00, 20.00, 50.00, 100.00, 75.00};

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PointOfSales frame = new PointOfSales();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PointOfSales() {
        initialize();
    }

    private void initialize() {
        setTitle("Point of Sales (POS) System");
       
        getContentPane().setLayout(null);
        setBounds(100, 100, 650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // --- LABELS & INPUTS ---
        JLabel lblSelect = new JLabel("Select Item:");
        lblSelect.setBounds(30, 30, 80, 25);
        getContentPane().add(lblSelect);

        // ComboBox for Fruits
        cmbItems = new JComboBox<>(fruits);
        cmbItems.setBounds(110, 30, 150, 25);
        getContentPane().add(cmbItems);

        JLabel lblQty = new JLabel("Quantity:");
        lblQty.setBounds(30, 70, 80, 25);
        getContentPane().add(lblQty);

        // Spinner for Quantity (Start at 1, Min 1, Max 100, Step 1)
        spinnerQty = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        spinnerQty.setBounds(110, 70, 60, 25);
        getContentPane().add(spinnerQty);

        // --- BUTTONS ---
        btnAdd = new JButton("Add Item");
        btnAdd.setBounds(30, 120, 100, 30);
        btnAdd.addActionListener(this); // Register Listener
        getContentPane().add(btnAdd);

        btnRemove = new JButton("Remove Item");
        btnRemove.setBounds(140, 120, 120, 30);
        btnRemove.addActionListener(this); // Register Listener
        getContentPane().add(btnRemove);

        btnCalculate = new JButton("Calculate Total");
        btnCalculate.setBounds(270, 120, 130, 30);
        btnCalculate.addActionListener(this); // Register Listener
        getContentPane().add(btnCalculate);

        // --- TABLE ---
        // Columns: Item, Unit Price, Quantity, Price
        String[] columns = {"Item", "Unit Price", "Quantity", "Price"};
        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 170, 560, 150);
        getContentPane().add(scrollPane);

        // --- TOTAL LABEL ---
        lblTotal = new JLabel("Total: Php 0.0");
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTotal.setBounds(30, 340, 300, 25);
        getContentPane().add(lblTotal);
    }

    // Requirement: Handle button events via ActionListener interface
    @Override
    public void actionPerformed(ActionEvent e) {

        // --- ADD ITEM LOGIC ---
        if (e.getSource() == btnAdd) {
            int index = cmbItems.getSelectedIndex();

            // Get Data based on selection
            String itemName = fruits[index];
            double unitPrice = prices[index];
            int qty = (int) spinnerQty.getValue();

            // Calculate row total
            double rowPrice = unitPrice * qty;

            // Add to table
            model.addRow(new Object[]{itemName, unitPrice, qty, rowPrice});
        }

        // --- REMOVE ITEM LOGIC ---
        else if (e.getSource() == btnRemove) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Please select an item in the table to remove.");
            }
        }

        // --- CALCULATE TOTAL LOGIC ---
        else if (e.getSource() == btnCalculate) {
            double totalAmount = 0.0;

            // Loop through all rows in the table
            for (int i = 0; i < model.getRowCount(); i++) {
                // Column 3 is the "Price" column
                double val = (double) model.getValueAt(i, 3);
                totalAmount += val;
            }

            lblTotal.setText("Total: Php " + totalAmount);
        }
    }
}