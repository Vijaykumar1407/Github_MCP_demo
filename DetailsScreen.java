import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DetailsScreen extends JFrame {

    private JTextField fullNameField;
    private JTextField emailField;
    private UserData userData;

    public DetailsScreen(UserData userData) {
        this.userData = userData;

        setTitle("Details Screen");
        setSize(300, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("Full Name:"));
        fullNameField = new JTextField();
        panel.add(fullNameField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this::onSubmit);
        panel.add(new JLabel());
        panel.add(submitButton);

        add(panel);
    }

    private void onSubmit(ActionEvent e) {
        userData.setFullName(fullNameField.getText());
        userData.setEmail(emailField.getText());

        new OutputScreen(userData).setVisible(true);
        this.dispose();
    }
}
