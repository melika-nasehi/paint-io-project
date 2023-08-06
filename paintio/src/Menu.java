import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    public Menu() {
        // Set up the frame properties
        setTitle("Game Menu");
        setSize( 1320  ,744);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the menu components
        JPanel panel = new JPanel();
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Transition to the game screen
                dispose(); // Close the menu screen
                GameScreen gameScreen = new GameScreen();
                gameScreen.startGame();
                //gameScreen.setVisible(true);
            }
        });
        JLabel titleLabel = new JLabel("Paint IO Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Add components to the panel
        panel.setLayout(new BorderLayout());
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(startButton, BorderLayout.CENTER);

        // Set the panel as the content pane of the frame
        setContentPane(panel);

    }

}
