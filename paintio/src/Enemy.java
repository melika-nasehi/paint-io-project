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

    public Enemy (GamePanel gamePanel) {
        this.gamePanel = gamePanel ;
        setDefaultValues();
        getPlayerImage(this.imagePath);

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

        Tile playerTile = new Tile(rand1 - 27 , rand2 + 15 , playerColor , TileStates.playerONIt) ;
        MapUpdating.coloredTiles.add(playerTile) ;

         for (int i = rand ; i < colors.length -1 ; i++)  // To avoid duplicate colors
             colors[i] = colors[i+1] ;




    }

    public void moving () {
        int tileX = 0 , tileY = 0 ;
        int rand = random.nextInt(100) ;

        if (rand <= 100) {  // up

            for (Tile tile : MapUpdating.coloredTiles) {
                if (tile.tileNumber == playerColor) {
                    tile.setTileY(tile.tileY ++);
                    tileX = tile.getTileX() ;
                    tileY = tile.getTileY() ;
                }
            }

            //checking if it is in visible area and change the current screen array

            if ((tileX <= MapUpdating.playerX + 27 && tileX >= MapUpdating.playerX - 27) &&
                    (tileY <= MapUpdating.playerY + 15 && tileY >= MapUpdating.playerY - 15)) {

                for (int i = 1 ; i < 31 ; i++) {
                    for (int j = 0 ; j < 55 ; j++) {
                        if (CurrentMap.currentScreen[i][j] == playerColor ) {
                            CurrentMap.currentScreen[i-1][j] = playerColor ;
                            if ((Math.abs(MapUpdating.playerX) + Math.abs(MapUpdating.playerY)) % 2 == 0 ) {
                                if ((i + j) % 2 == 0)
                                    CurrentMap.currentScreen[i][j] = 0 ;
                                else
                                    CurrentMap.currentScreen[i][j] = 1 ;
                            }
                            else{
                                if ((i + j) % 2 == 0)
                                    CurrentMap.currentScreen[i][j] = 1 ;
                                else
                                    CurrentMap.currentScreen[i][j] = 0 ;
                            }

                        }
                    }
                }

            }

        }


        else if (rand <= 10) {  // down

            for (Tile tile : MapUpdating.coloredTiles) {
                if (tile.tileNumber == 6) {
                    tile.setTileY(tile.tileY --);
                }
            }
        }


        else if (rand <= 15) {  // right

            for (Tile tile : MapUpdating.coloredTiles) {
                if (tile.tileNumber == 6) {
                    tile.setTileX(tile.tileX ++);
                }
            }
        }


        else if (rand <= 20) { // left

            for (Tile tile : MapUpdating.coloredTiles) {
                if (tile.tileNumber == 6) {
                    tile.setTileX(tile.tileX --);
                }
            }
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
