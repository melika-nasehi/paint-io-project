import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Player extends Entity{

    public int xPosition ;
    public int yPosition ;
    public BufferedImage img ;
    public int speed ;
    ArrayList<Tile> possessedTiles = new ArrayList<>();
    String imagePath = "/images/crimson.png" ;
    GamePanel gamePanel ;
    KeyHandler keyHandler ;

    public Player (GamePanel gamePanel , KeyHandler keyHandler){
        this.gamePanel = gamePanel ;
        this.keyHandler = keyHandler ;

        setDefaultValues();
        getPlayerImage(imagePath);
    }

    public Player () {

    }

    public void setDefaultValues(){
        xPosition = gamePanel.displayedTileSize * 27 ;
        yPosition = gamePanel.displayedTileSize * 15 ;
    }

    public void getPlayerImage(String imagePath){

        try {

            img = ImageIO.read(getClass().getResourceAsStream(imagePath)) ;

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update(){
        kill(MapUpdating.playerX , MapUpdating.playerY ,2);
    }
    public void draw(Graphics2D graphics2D){

        graphics2D.drawImage(img , xPosition , yPosition ,
                gamePanel.displayedTileSize , gamePanel.displayedTileSize , null );

    }

    public void kill (int playerX , int playerY , int tailColor) {
        Iterator<Tile> iterator = MapUpdating.coloredTiles.iterator();
        boolean collision = false ;
        int tileNumber = 0 ;
        for (Tile tile : MapUpdating.coloredTiles) {
            if (playerX == tile.tileX && playerY == tile.tileY &&
                    tile.tileState.equals(TileStates.isOccupying) && tile.tileNumber != tailColor ) {
                tileNumber = tile.getTileNumber();
                collision = true ;
                break;
            }
        }

        if (collision) {
            while (iterator.hasNext()) {
                Tile tile = iterator.next();
                if (tile.tileNumber == tileNumber || tile.tileNumber == tileNumber + 1 || tile.tileNumber == tileNumber + 2)
                    iterator.remove();
            }

            for (int i = 0 ; i < 31 ; i ++) {
                for (int j = 0 ; j < 55 ; j ++) {
                    if (CurrentMap.currentScreen[i][j] == tileNumber ||
                            CurrentMap.currentScreen[i][j] == tileNumber + 1  ||
                            CurrentMap.currentScreen[i][j] == tileNumber + 2 ) {

                        if ((Math.abs(MapUpdating.playerX) + Math.abs(MapUpdating.playerY)) % 2 == 0 ) {
                            if ((i + j) % 2 == 0)
                                CurrentMap.currentScreen[i][j] = TileFactory.contrastTile ;
                            else
                                CurrentMap.currentScreen[i][j] = 1 ;
                        }
                        else{
                            if ((i + j) % 2 == 0)
                                CurrentMap.currentScreen[i][j] = TileFactory.contrastTile ;
                            else
                                CurrentMap.currentScreen[i][j] = 1 ;
                        }
                    }
                }
            }
            int index = 0 ;
            for (Integer playerColor : gamePanel.usedColors) {
                if (playerColor == tileNumber + 2 ) {
                    switch (index){
                        case 0 :
                            gamePanel.enemy1 = null ;
                            break;
                        case 1 :
                            gamePanel.enemy2 = null ;
                            break;
                        case 2 :
                            gamePanel.enemy3 = null ;
                            break;
                        case 3 :
                            gamePanel.enemy4 = null ;
                            break;
                    }
                }
                index ++ ;
            }

        }
    }
}
