package windowsbuilderguided; /// guided no.2

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class DemoSwing3 extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField txtName;
    private JButton btnTest, btnClose;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // FIXED: Changed 'frame' to 'window' para tumugma sa 'window.setVisible'
                    DemoSwing3 window = new DemoSwing3();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DemoSwing3() {
        getContentPane().setFont(new Font("TAHOMA", Font.PLAIN, 20));
        initialize();
    }
    // FIXED: Tinanggal ang "}" dito. Dapat sa dulo pa matapos ang Class.

    private void initialize() {
        setBounds(100, 100, 450, 411);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Enter your name:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(133, 47, 204, 39);
        getContentPane().add(lblNewLabel);

        // FIXED: Added 'new' keyword
        txtName = new JTextField();
        txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtName.setColumns(10);
        txtName.setBounds(133, 98, 204, 39);
        getContentPane().add(txtName);

        btnTest = new JButton("TEST");
        btnTest.setBounds(77, 159, 157, 39);
        // FIXED: Typo 'getContentPanel' -> 'getContentPane'
        getContentPane().add(btnTest);

        btnClose = new JButton("CLOSE");
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnClose.setBounds(244, 159, 157, 39);
        getContentPane().add(btnClose);

        btnTest.addActionListener(this);
        btnClose.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO AUTO-generated method stub
        if (e.getSource() == btnTest) {
            JOptionPane.showMessageDialog(null, "Hello " + txtName.getText());
        } else if (e.getSource() == btnClose) {
            // FIXED: Added '()' to getText
            JOptionPane.showMessageDialog(null, "Bye " + txtName.getText());
            dispose();
        }
    }
} // FIXED: Dito nilagay ang closing brace ng Class.