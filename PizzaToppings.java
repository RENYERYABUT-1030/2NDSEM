package windowsbuilderguided; // guided no.4



import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class PizzaToppings {

    private JFrame frmJcheckboxExample;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PizzaToppings window = new PizzaToppings();
                window.frmJcheckboxExample.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PizzaToppings() {
        initialize();
    }

    private void initialize() {
        frmJcheckboxExample = new JFrame();
        frmJcheckboxExample.setTitle("JCheckBox Example");
        frmJcheckboxExample.setBounds(100, 100, 400, 300);
        frmJcheckboxExample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmJcheckboxExample.getContentPane().setLayout(null);

        JCheckBox chkCheese = new JCheckBox("Cheese");
        chkCheese.setFont(new Font("Tahoma", Font.PLAIN, 12));
        chkCheese.setBounds(50, 50, 100, 30);
        frmJcheckboxExample.getContentPane().add(chkCheese);

        JCheckBox chkPepperoni = new JCheckBox("Pepperoni");
        chkPepperoni.setFont(new Font("Tahoma", Font.PLAIN, 12));
        chkPepperoni.setBounds(50, 100, 100, 30);
        frmJcheckboxExample.getContentPane().add(chkPepperoni);

        JCheckBox chkMushrooms = new JCheckBox("Mushrooms");
        chkMushrooms.setFont(new Font("Tahoma", Font.PLAIN, 12));
        chkMushrooms.setBounds(50, 150, 100, 30);
        frmJcheckboxExample.getContentPane().add(chkMushrooms);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSubmit.setBounds(200, 50, 100, 30);
        frmJcheckboxExample.getContentPane().add(btnSubmit);

        JLabel lblResult = new JLabel("<output here>");
        lblResult.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblResult.setBounds(50, 200, 300, 30);
        frmJcheckboxExample.getContentPane().add(lblResult);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder toppings = new StringBuilder("Selected Toppings: ");
                if (chkCheese.isSelected()) toppings.append("Cheese ");
                if (chkPepperoni.isSelected()) toppings.append("Pepperoni ");
                if (chkMushrooms.isSelected()) toppings.append("Mushrooms ");
                lblResult.setText(toppings.toString());
            }
        });
    }
}