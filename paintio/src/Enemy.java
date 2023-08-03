import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Player{
    String imagePath = "/images/player blue.png" ;
    GamePanel gamePanel ;
    Coloring coloring  = new Coloring() ;
    Random random = new Random() ;
    private int[] colors = {6 , 9 , 12 , 15} ;  // different color codes
    int playerColor ;
    boolean goingUp , goingDown , goingRight , goingLeft ;
    int tileX = 0 , tileY = 0 ;

    public Enemy (GamePanel gamePanel) {
        this.gamePanel = gamePanel ;
        setDefaultValues();
        //getPlayerImage(this.imagePath);

    }

    @Override
    public void update() {
        moving();
    }

    @Override
    public void getPlayerImage(String imagePath) {
        try {

            this.img = ImageIO.read(getClass().getResourceAsStream(imagePath)) ;

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void draw(Graphics2D graphics2D) {
        // graphics2D.drawImage(this.img , xPosition , yPosition ,gamePanel.displayedTileSize , gamePanel.displayedTileSize , null );

    }

    @Override
    public void setDefaultValues() {

        int rand1 = random.nextInt(10);
        int rand2 = random.nextInt(10);

        xPosition = rand1 * gamePanel.displayedTileSize ;
        yPosition = rand2 * gamePanel.displayedTileSize ;

        System.out.println(rand1); System.out.println(rand2);

        int rand = random.nextInt(colors.length) ;
        playerColor = colors[rand] ;

        CurrentMap.currentScreen[rand2][rand1] = playerColor ;

        Tile playerTile = new Tile(rand1 - 27 ,  -rand2 + 15 , playerColor , TileStates.playerONIt) ;
        MapUpdating.coloredTiles.add(playerTile) ;

         for (int i = rand ; i < colors.length -1 ; i++)  // To avoid duplicate colors
             colors[i] = colors[i+1] ;




    }

    public void moving () {
        int rand = random.nextInt(100) ;
        changePlace(goingUp , goingDown , goingRight , goingLeft);

        if (rand <= 5) {  // up
           goingUp = true ;
           goingDown = goingRight = goingLeft = false ;
        }

        else if (rand <= 10) {  // down
            goingDown = true ;
            goingUp = goingRight = goingLeft = false ;
        }

        else if (rand <= 15) {  // right
            goingRight = true ;
            goingUp = goingDown = goingLeft = false ;
        }

        else if (rand <= 20) { // left
            goingLeft = true ;
            goingUp = goingDown = goingRight = false ;
        }

    }

    public void changePlace (boolean up , boolean down , boolean right , boolean left ) {
        int direction = 0  ;
        int minI = 0 ;
        int minJ = 0 ;
        int maxI = 0 ;
        int maxJ = 0 ;
        int m = 0 ;
        int n = 0 ;
        if (up) {
            direction = 1 ;
            minI = 1 ;
            maxI = 31 ;
            minJ = 0 ;
            maxJ = 55 ;
            m = -1 ;
        }
        else if (down) {
            direction = -1 ;
            minI = 0 ;
            maxI = 30 ;
            minJ = 0 ;
            maxJ = 55 ;
            m = 1 ;
        }
        else if (right) {
            direction = 1;
            minI = 0 ;
            maxI = 31 ;
            minJ = 0 ;
            maxJ = 54 ;
            n = 1 ;
        }
        else if (left) {
            direction = - 1 ;
            minI = 0 ;
            maxI = 31 ;
            minJ = 1 ;
            maxJ = 55 ;
            n = -1 ;
        }

        for (Tile tile : MapUpdating.coloredTiles) {
            if (tile.tileNumber == playerColor) {
                int x = tile.getTileX();
                int y = tile.getTileY() ;
                if (up || down)
                    tile.setTileY(y + direction);
                else if (right || left)
                    tile.setTileX(x + direction);
                tileX = tile.getTileX() ;
                tileY = tile.getTileY() ;
                break;
            }
        }

        //checking if it is in visible area and change the current screen array

        if ((tileX <= MapUpdating.playerX + 27 && tileX >= MapUpdating.playerX - 27) &&
                (tileY <= MapUpdating.playerY + 15 && tileY >= MapUpdating.playerY - 15)) {

            boolean found = false ;
            for (int i = minI ; i < maxI ; i++) {
                for (int j = minJ ; j < maxJ ; j++) {
                    if (CurrentMap.currentScreen[i][j] == playerColor ) {
                        CurrentMap.currentScreen[i+m][j+n] = playerColor ;
                        drawEmpty(i, j);
                        found = true ;
                        break;
                    }
                }
                if (found)
                    break;
            }
        }

    }

    private void drawEmpty(int i, int j) {
        if ((Math.abs(MapUpdating.playerX) + Math.abs(MapUpdating.playerY)) % 2 == 0 ) {
            if ((i + j) % 2 == 0)
                CurrentMap.currentScreen[i][j] = playerColor - 2 ;
            else
                CurrentMap.currentScreen[i][j] = playerColor - 2 ;
        }
        else{
            if ((i + j) % 2 == 0)
                CurrentMap.currentScreen[i][j] = playerColor - 2 ;
            else
                CurrentMap.currentScreen[i][j] = playerColor - 2 ;
        }
    }

    public void paintTail() {

        boolean isPlayerOnArea = coloring.isPlayerOnArea(xPosition/gamePanel.displayedTileSize ,
                yPosition/ gamePanel.displayedTileSize , 5 ) ;

        if (! isPlayerOnArea ) {
             /* if () {     // going up

             }

            else if () {  // going down

            }

            else if () {   // going right


            }
            else if () {  // going left

            } */
        }

    }


}
