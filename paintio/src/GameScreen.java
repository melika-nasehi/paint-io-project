import javax.swing.*;

public class GameScreen extends JFrame {

    private GamePanel gamePanel;

    public GameScreen() {
        // Set up the frame properties
        //setTitle("Game");
       // setSize(800, 600);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the game panel but don't show it yet
        gamePanel = new GamePanel();
    }

    public void startGame() {
        // Add the game panel to the frame and display it
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Title");
        add(gamePanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        gamePanel.startGameThread();

    }

}
