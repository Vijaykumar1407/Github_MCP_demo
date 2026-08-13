import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private UserData userData;

    public LoginScreen(UserData userData) {
        this.userData = userData;

        setTitle("Login Screen");
        setSize(300, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(this::onNext);
        panel.add(new JLabel());
        panel.add(nextButton);

        add(panel);
    }

    private void onNext(ActionEvent e) {
        userData.setUsername(usernameField.getText());
        userData.setPassword(new String(passwordField.getPassword()));

        new DetailsScreen(userData).setVisible(true);
        this.dispose();
    }
}
