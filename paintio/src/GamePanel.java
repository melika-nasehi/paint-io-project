import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int tileSize = 8 ;
    final int scale = 3 ;
    public final int displayedTileSize = tileSize * scale ;
    public final int screenRow = 31 ;
    public final int screenCol = 55 ;
    final int screenWidth = displayedTileSize * screenCol ;
    final int screenHeight = displayedTileSize * screenRow ;



    Thread gameThread ;
    KeyHandler kh = new KeyHandler();
    MapUpdating mp = new MapUpdating() ;
    Player player = new Player(this , kh);
    CurrentMap currentMap = new CurrentMap(this , kh , mp) ;
    Enemy enemy = new Enemy(this);
    //Enemy enemy2 = new Enemy(this) ;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth , screenHeight));
        this.setBackground(Color.black);
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

        double drawInterval = 1000000000 / 5.5 ; // 60 = fps (frame per second)
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
        enemy.update();
       // enemy2.update();
        currentMap.update();
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics ;

        currentMap.draw(graphics2D); ////////////////////////////////////////////////

        player.draw(graphics2D);

        enemy.draw(graphics2D);
        //enemy2.draw(graphics2D);

        graphics2D.dispose();

    }
}
