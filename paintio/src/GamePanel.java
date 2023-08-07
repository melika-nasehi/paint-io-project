import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {
    final int tileSize = 8 ;
    final int scale = 3 ;
    public final int displayedTileSize = tileSize * scale ;
    public final int screenRow = 31 ;
    public final int screenCol = 55 ;
    final int screenWidth = displayedTileSize * screenCol ;
    final int screenHeight = displayedTileSize * screenRow ;
    static double fps ;



    Thread gameThread ;
    KeyHandler kh = new KeyHandler();
    MapUpdating mp = new MapUpdating() ;
    Player player = new Player(this , kh);
    CurrentMap currentMap = new CurrentMap(this , kh , mp) ;
    int enemyCount = 0 ;
    static int userSelectedEnemyCount  ;
    ArrayList<Integer> usedColors = new ArrayList<>();
    Enemy enemy1 ;
    Enemy enemy2 ;
    Enemy enemy3 ;
    Enemy enemy4 ;

    public void setEnemyCount() {

        if (userSelectedEnemyCount >= 1)
            enemy1 = new Enemy(this);
        if (userSelectedEnemyCount >=2)
            enemy2 = new Enemy(this);
        if (userSelectedEnemyCount >=3)
            enemy3 = new Enemy(this);
        if (userSelectedEnemyCount >=4)
            enemy4 = new Enemy(this);

    }

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth , screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
        setEnemyCount();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / fps ; // = fps (frame per second)
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

        try {
            enemy1.update();
        }catch (NullPointerException e) {}
        try {
            enemy2.update();
        }catch (NullPointerException e) {}
        try {
            enemy3.update();
        }catch (NullPointerException e) {}
        try {
            enemy4.update();
        }catch (NullPointerException e) {}

        currentMap.update();
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics ;

        currentMap.draw(graphics2D); ////////////////////////////////////////////////

        player.draw(graphics2D);

        try {
            enemy1.draw(graphics2D);
        }catch (NullPointerException e){}
        try {
            enemy2.draw(graphics2D);
        }catch (NullPointerException e){}
        try {
            enemy3.draw(graphics2D);
        }catch (NullPointerException e){}
        try {
            enemy4.draw(graphics2D);
        }catch (NullPointerException e){}

        graphics2D.dispose();

    }
}
