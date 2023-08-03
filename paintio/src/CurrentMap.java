import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class CurrentMap {

    public int screenX ;
    public int screenY ;
    public static ArrayList<Tile> tilesOnScreen = new ArrayList<Tile>();   // 625 tiles display at a moment

    public static int[][] currentScreen = new int[31][55];
    GamePanel gamePanel ;
    KeyHandler keyHandler ;
    MapUpdating mapUpdating ;

    Tile [] tilePicsArray ;

    public CurrentMap (GamePanel gamePanel , KeyHandler keyHandler , MapUpdating mapUpdating) {
        this.gamePanel = gamePanel ;
        this.keyHandler = keyHandler ;
        this.mapUpdating = mapUpdating ;
        tilePicsArray = new Tile[30];
        getTileImage();
        firstScreen();
    }

    public void getTileImage() {
        tilePicsArray[0] = new Tile() ;
        tilePicsArray[1] = new Tile() ;
        tilePicsArray[2] = new Tile() ;
        tilePicsArray[3] = new Tile() ;
        tilePicsArray[4] = new Tile() ;
        tilePicsArray[5] = new Tile() ;
        tilePicsArray[6] = new Tile() ;
        tilePicsArray[7] = new Tile() ;
        tilePicsArray[8] = new Tile() ;
        tilePicsArray[9] = new Tile() ;
        tilePicsArray[10] = new Tile() ;
        tilePicsArray[11] = new Tile() ;
        tilePicsArray[12] = new Tile() ;
        tilePicsArray[13] = new Tile() ;
        tilePicsArray[14] = new Tile() ;
        tilePicsArray[15] = new Tile() ;
        try {

            tilePicsArray[0].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/gray.png")) ;
            tilePicsArray[1].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/white tile.png")) ;
            tilePicsArray[2].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/light red 2.png")) ;
            tilePicsArray[3].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/red.png")) ;
            tilePicsArray[4].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/light blue.png")) ;
            tilePicsArray[5].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/blue.png")) ;
            tilePicsArray[6].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/player blue.png")) ;
            tilePicsArray[7].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/light pink.png")) ;
            tilePicsArray[8].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/pink.png")) ;
            tilePicsArray[9].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/player pink.png")) ;
            tilePicsArray[10].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/light green.png")) ;
            tilePicsArray[11].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/green.png")) ;
            tilePicsArray[12].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/player green.png")) ;
            tilePicsArray[13].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/light orange.png")) ;
            tilePicsArray[14].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/orange.png")) ;
            tilePicsArray[15].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/player orange.png")) ;




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
                    currentScreen[row][col] = TileFactory.contrastTile ;
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
