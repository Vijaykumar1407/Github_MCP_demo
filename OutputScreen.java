import javax.swing.*;
import java.awt.*;

public class OutputScreen extends JFrame {

    public OutputScreen(UserData userData) {
        setTitle("Output Screen");
        setSize(300, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("Username: " + userData.getUsername()));
        panel.add(new JLabel("Password: " + userData.getPassword()));
        panel.add(new JLabel("Full Name: " + userData.getFullName()));
        panel.add(new JLabel("Email: " + userData.getEmail()));

        add(panel);
    }
}
