import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserData userData = new UserData();
            new LoginScreen(userData).setVisible(true);
        });
    }
}
