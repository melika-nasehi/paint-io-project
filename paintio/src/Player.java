import java.awt.*;

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
    }

    public void setDefaultValues(){
        mapX = gamePanel.displayedTileSize * 12 ;
        mapY = gamePanel.displayedTileSize * 12 ;
        speed = 2 ;
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
        graphics2D.setColor(Color.red);
        graphics2D.fillRect(screenX , screenY , gamePanel.displayedTileSize , gamePanel.displayedTileSize);

    }
}
