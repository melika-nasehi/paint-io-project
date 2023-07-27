import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class CurrentMap {

    public int screenX ;
    public int screenY ;
    public static ArrayList<Tile> tilesOnScreen = new ArrayList<Tile>();   // 625 tiles display at a moment

    public static int currentScreen[][] = new int[25][25];
    GamePanel gamePanel ;
    KeyHandler keyHandler ;
    MapUpdating mapUpdating ;

    Tile [] tilePicsArray ;

    public CurrentMap (GamePanel gamePanel , KeyHandler keyHandler , MapUpdating mapUpdating) {
        this.gamePanel = gamePanel ;
        this.keyHandler = keyHandler ;
        this.mapUpdating = mapUpdating ;
        tilePicsArray = new Tile[15];
        getTileImage();
        firstScreen();
    }

    public void getTileImage() {
        tilePicsArray[0] = new Tile() ;
        tilePicsArray[1] = new Tile() ;
        tilePicsArray[2] = new Tile() ;
        tilePicsArray[3] = new Tile() ;
        tilePicsArray[4] = new Tile() ;
        try {

            tilePicsArray[0].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/gray.png")) ;
            tilePicsArray[1].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/white tile.png")) ;
            tilePicsArray[2].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/blue.png")) ;
            tilePicsArray[3].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/light red.png")) ;
            tilePicsArray[4].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/red.png")) ;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(){
        if (keyHandler.upPressed || keyHandler.isGoingUp)
            mapUpdating.goingUP();
        else if (keyHandler.downPressed || keyHandler.isGoingDown)
            mapUpdating.goingDown();

        else if (keyHandler.rightPressed || keyHandler.isGoingRight)
            mapUpdating.goingRight();

        else if (keyHandler.leftPressed || keyHandler.isGoingLeft)
            mapUpdating.goingLeft();

    }

    public void draw (Graphics2D graphics2D) {
        int x = 0 ;
        int y = 0;
        int row ;
        int col ;


        for ( row = 0 ; row < gamePanel.screenRow ; row ++ ) {

            for (col = 0 ; col < gamePanel.screenCol ; col ++) {

                int tileNum = currentScreen[row][col] ;
                graphics2D.drawImage(tilePicsArray[tileNum].tileImage, x, y,
                        gamePanel.displayedTileSize, gamePanel.displayedTileSize, null);

                x = x + gamePanel.displayedTileSize ;
            }
            y = y + gamePanel.displayedTileSize ;
            x = 0 ;
        }

    }

    public void firstScreen () {

        int row ;
        int col ;
        boolean isWhite = false ;

        for (row = 0 ; row < gamePanel.screenRow ; row++) {
            for (col = 0 ; col < gamePanel.screenCol ; col++) {

                if (isWhite) {   //white
                 currentScreen[row][col] = 1 ;
                 isWhite = false ;
                }
                else {           // gray
                    currentScreen[row][col] = 0 ;
                    isWhite = true ;
                }
            }
        }

        for (row = 10 ; row < 15 ; row++) {
            for (col = 10 ; col < 15 ; col++) {
                currentScreen[row][col] =  4 ;  // coloring a 5*5 square at the start point

            }
        }


    }

}
