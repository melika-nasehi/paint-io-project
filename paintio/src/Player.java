import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gamePanel ;
    KeyHandler keyHandler ;

    public final int screenX ;
    public final int screenY ;

    public Player (GamePanel gamePanel , KeyHandler keyHandler){
        this.gamePanel = gamePanel ;
        this.keyHandler = keyHandler ;

        screenX = gamePanel.displayedTileSize * 12 ;
        screenY = gamePanel.displayedTileSize * 12 ;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        mapX = gamePanel.displayedTileSize * 12 ;
        mapY = gamePanel.displayedTileSize * 12 ;
        speed = 2 ;
    }

    public void getPlayerImage(){

        try {

            img1 = ImageIO.read(getClass().getResourceAsStream("/images/crimson.png")) ;

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update(){
         /* if (keyHandler.upPressed || keyHandler.isGoingUp) {
            mapY -= speed;
        }
        else if (keyHandler.downPressed || keyHandler.isGoingDown)
            mapY += speed ;
        else if (keyHandler.rightPressed || keyHandler.isGoingRight)
            mapX += speed ;
        else if (keyHandler.leftPressed || keyHandler.isGoingLeft)
            mapX -= speed ; */
    }
    public void draw(Graphics2D graphics2D){
       // graphics2D.setColor(Color.red);
       // graphics2D.fillRect(screenX , screenY , gamePanel.displayedTileSize , gamePanel.displayedTileSize);

        graphics2D.drawImage(img1 , screenX , screenY ,
                gamePanel.displayedTileSize , gamePanel.displayedTileSize , null );

    }
}
