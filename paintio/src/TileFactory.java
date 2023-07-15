import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileFactory {
    GamePanel gp ;
    Tile [] tileArray ;

    public TileFactory(GamePanel gp) {
        this.gp = gp ;
        tileArray = new Tile[15];
        getTileImage();
    }
    public void getTileImage() {
        tileArray[0] = new Tile() ;
        tileArray[1] = new Tile() ;
        try {

            tileArray[0].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/gary tile.png")) ;

            tileArray[1].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/white tile.png")) ;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void draw (Graphics2D graphics2D) {
        int x = 0 ;
        int y = 0;
        int row ;
        int col ;
        boolean isGray = true ;

        for ( row = 0 ; row < gp.screenRow ; row ++ ) {

            for (col = 0 ; col < gp.screenCol ; col ++) {

                if (isGray) {
                    graphics2D.drawImage(tileArray[0].tileImage, x, y,
                            gp.displayedTileSize, gp.displayedTileSize, null);
                    isGray = false ;
                }
                else {
                    graphics2D.drawImage(tileArray[1].tileImage, x, y,
                            gp.displayedTileSize, gp.displayedTileSize, null);
                    isGray = true ;
                }
                x = x + gp.displayedTileSize ;
            }
            y = y + gp.displayedTileSize ;
            x = 0 ;
        }

    }
}
