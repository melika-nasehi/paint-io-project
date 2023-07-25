import java.awt.*;

public class Player extends Entity{
    GamePanel gamePanel ;
    KeyHandler keyHandler ;

    public Player (GamePanel gamePanel , KeyHandler keyHandler){
        this.gamePanel = gamePanel ;
        this.keyHandler = keyHandler ;
        setDefaultValues();
    }

    public void setDefaultValues(){
        X = gamePanel.displayedTileSize * 12 ;
        Y = gamePanel.displayedTileSize * 12 ;
        speed = 2 ;
    }

    public void update(){
         if (keyHandler.upPressed || keyHandler.isGoingUp) {
            Y -= speed;
        }
        else if (keyHandler.downPressed || keyHandler.isGoingDown)
            Y += speed ;
        else if (keyHandler.rightPressed || keyHandler.isGoingRight)
            X += speed ;
        else if (keyHandler.leftPressed || keyHandler.isGoingLeft)
            X -= speed ;
    }
    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(Color.red);
        graphics2D.fillRect(X , Y , gamePanel.displayedTileSize , gamePanel.displayedTileSize);

    }
}
