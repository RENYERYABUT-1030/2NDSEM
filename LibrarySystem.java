import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibrarySystem extends JFrame {

    private JTextField titleField;
    private JTextField authorField;
    private DefaultListModel<String> bookListModel;
    private JList<String> bookList;

    public LibrarySystem() {
        setTitle("Library System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ===== INPUT PANEL =====
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));

        JLabel titleLabel = new JLabel("Book Title:");
        titleField = new JTextField();

        JLabel authorLabel = new JLabel("Author:");
        authorField = new JTextField();

        JButton addButton = new JButton("Add Book");
        JButton removeButton = new JButton("Remove Selected");

        inputPanel.add(titleLabel);
        inputPanel.add(titleField);
        inputPanel.add(authorLabel);
        inputPanel.add(authorField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        // ===== BOOK LIST =====
        bookListModel = new DefaultListModel<>();
        bookList = new JList<>(bookListModel);

        JScrollPane scrollPane = new JScrollPane(bookList);

        // ===== BUTTON ACTIONS =====
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeBook();
            }
        });

        // ===== MAIN LAYOUT =====
        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void addBook() {
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();

        if (title.isEmpty() || author.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter both title and author.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        bookListModel.addElement(title + " by " + author);
        titleField.setText("");
        authorField.setText("");
    }

    private void removeBook() {
        int selectedIndex = bookList.getSelectedIndex();

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this,
                    "Please select a book to remove.",
                    "Selection Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        bookListModel.remove(selectedIndex);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibrarySystem().setVisible(true);
            }
        });
    }
}
