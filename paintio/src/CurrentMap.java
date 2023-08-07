import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class CurrentMap {
    public static int[][] currentScreen = new int[31][55];
    GamePanel gamePanel ;
    KeyHandler keyHandler ;
    MapUpdating mapUpdating ;
    TileFactory tileFactory = new TileFactory();



    public CurrentMap (GamePanel gamePanel , KeyHandler keyHandler , MapUpdating mapUpdating) {
        this.gamePanel = gamePanel ;
        this.keyHandler = keyHandler ;
        this.mapUpdating = mapUpdating ;
        tileFactory.getTileImage();
        firstScreen();
    }


    public void update(){
        if (KeyHandler.upPressed || KeyHandler.isGoingUp)
            mapUpdating.goingUP();
        else if (KeyHandler.downPressed || KeyHandler.isGoingDown)
            mapUpdating.goingDown();

        else if (KeyHandler.rightPressed || KeyHandler.isGoingRight)
            mapUpdating.goingRight();

        else if (KeyHandler.leftPressed || KeyHandler.isGoingLeft)
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
                graphics2D.drawImage(tileFactory.tilePicsArray[tileNum].tileImage, x, y,
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
                    currentScreen[row][col] = tileFactory.contrastTile ;
                    isWhite = true ;
                }
            }
        }

        for (row = 13 ; row < 18 ; row++) {
            for (col = 25 ; col < 30 ; col++) {
                currentScreen[row][col] =  3 ;  // coloring a 5*5 square at the start point

                // add to the colored tiles list
                Tile newTile = new Tile( col -27 , row - 15 , 3 , TileStates.occupied ) ;
                MapUpdating.coloredTiles.add(newTile) ;

            }
        }


    }

}
