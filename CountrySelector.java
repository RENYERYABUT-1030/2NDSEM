package windowsbuilderguided; // guided no.6



import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class CountrySelector {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CountrySelector window = new CountrySelector();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public CountrySelector() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("JComboBox Example");
        frame.setBounds(100, 100, 300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblSelectCountry = new JLabel("Select a Country:");
        lblSelectCountry.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblSelectCountry.setBounds(20, 20, 120, 30);
        frame.getContentPane().add(lblSelectCountry);

        // JComboBox with list of countries
        JComboBox<String> cboCountry = new JComboBox<>(new String[] {"Philippines", "Singapore", "Canada", "Australia", "USA"});
        cboCountry.setFont(new Font("Dialog", Font.PLAIN, 12));
        cboCountry.setBounds(140, 20, 120, 30);
        frame.getContentPane().add(cboCountry);

        JLabel lblResult = new JLabel("<output here>");
        lblResult.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblResult.setBounds(20, 80, 240, 30);
        frame.getContentPane().add(lblResult);

        // Action Listener para sa selection update
        cboCountry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCountry = (String) cboCountry.getSelectedItem();
                lblResult.setText("Selected Country: " + selectedCountry);
            }
        });
    }
}
