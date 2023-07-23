import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed , downPressed , rightPressed , leftPressed ;
    public boolean  isGoingUp , isGoingRight , isGoingLeft , isGoingDown ;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) {
            isGoingRight = isGoingLeft = isGoingDown = false ;
            upPressed = true ;
        }
        if (code == KeyEvent.VK_RIGHT) {
            isGoingUp = isGoingDown = isGoingLeft = false ;
            rightPressed = true ;
        }
        if (code == KeyEvent.VK_LEFT) {
            isGoingRight = isGoingDown = isGoingUp = false ;
            leftPressed = true ;
        }
        if (code == KeyEvent.VK_DOWN) {
            isGoingLeft = isGoingRight = isGoingUp = false ;
            downPressed = true ;
        }

}

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) {
            upPressed = false ;
            isGoingUp = true ;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = false ;
            isGoingRight = true ;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed = false ;
            isGoingLeft = true ;
        }
        if (code == KeyEvent.VK_DOWN) {
            downPressed = false ;
            isGoingDown = true ;
        }

    }
}
