import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int tileSize = 16 ;
    final int scale = 3 ;
    public final int displayedTileSize = tileSize * scale ;
    final int screenRow = 10 ;
    final int screenCol = 10 ;
    final int screenWidth = displayedTileSize * screenCol ;
    final int screenHeight = displayedTileSize * screenRow ;

    Thread gameThread ;
    KeyHandler kh = new KeyHandler();
    Player player = new Player(this , kh);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth , screenHeight));
        this.setBackground(Color.green);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / 60 ; // 60 = fps (frame per second)
        double delta = 0 ;
        long lastTime = System.nanoTime();
        long currentTime ;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval ;
            lastTime = currentTime ;
            if (delta >= 1) {
                update();
                repaint();
                delta -- ;
            }

        }

    }

    public void update () {
        player.update();
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics ;

        player.draw(graphics2D);

        graphics2D.dispose();

    }
}
