import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create and show the menu screen
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });


    }
}
