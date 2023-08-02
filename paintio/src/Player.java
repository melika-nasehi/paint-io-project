import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

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

    }
    public void draw(Graphics2D graphics2D){

        graphics2D.drawImage(img , xPosition , yPosition ,
                gamePanel.displayedTileSize , gamePanel.displayedTileSize , null );

    }
}
