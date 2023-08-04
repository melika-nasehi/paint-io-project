import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileFactory {
    GamePanel gp ;
    Tile [] tilePicsArray ;
    int mapTileNum[][] ;

    static int contrastTile = 1 ;

    public TileFactory(GamePanel gp) {
        this.gp = gp ;
        tilePicsArray = new Tile[15];
        mapTileNum = new int[gp.screenCol][gp.screenRow] ;

        getTileImage();
    }
    public void getTileImage() {
        tilePicsArray[0] = new Tile() ;
        tilePicsArray[1] = new Tile() ;
        try {

            tilePicsArray[0].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/gary tile.png")) ;

            tilePicsArray[1].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/white tile.png")) ;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
