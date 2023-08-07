import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileFactory {
    Tile [] tilePicsArray ;
    static int contrastTile = 0 ;
    static String solidColor ;
    static String lightColor ;


    public TileFactory () {
        tilePicsArray = new Tile[30];
    }


    public void getTileImage() {
        tilePicsArray[0] = new Tile() ;
        tilePicsArray[1] = new Tile() ;
        tilePicsArray[2] = new Tile() ;
        tilePicsArray[3] = new Tile() ;
        tilePicsArray[4] = new Tile() ;
        tilePicsArray[5] = new Tile() ;
        tilePicsArray[6] = new Tile() ;
        tilePicsArray[7] = new Tile() ;
        tilePicsArray[8] = new Tile() ;
        tilePicsArray[9] = new Tile() ;
        tilePicsArray[10] = new Tile() ;
        tilePicsArray[11] = new Tile() ;
        tilePicsArray[12] = new Tile() ;
        tilePicsArray[13] = new Tile() ;
        tilePicsArray[14] = new Tile() ;
        tilePicsArray[15] = new Tile() ;
        tilePicsArray[16] = new Tile() ;
        tilePicsArray[17] = new Tile() ;
        tilePicsArray[18] = new Tile() ;
        tilePicsArray[19] = new Tile() ;
        tilePicsArray[20] = new Tile() ;
        tilePicsArray[21] = new Tile() ;
        tilePicsArray[22] = new Tile() ;
        tilePicsArray[27] = new Tile() ;
        tilePicsArray[28] = new Tile() ;
        try {

            tilePicsArray[0].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/gray.png")) ;
            tilePicsArray[1].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/white tile.png")) ;
            tilePicsArray[2].tileImage = ImageIO.read(getClass().getResourceAsStream(lightColor)) ;
            tilePicsArray[3].tileImage = ImageIO.read(getClass().getResourceAsStream(solidColor)) ;
            tilePicsArray[4].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/crimson.png")) ;
            tilePicsArray[5].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/light blue.png")) ;
            tilePicsArray[6].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/blue.png")) ;
            tilePicsArray[7].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/player blue.png")) ;
            tilePicsArray[8].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/light pink.png")) ;
            tilePicsArray[9].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/pink.png")) ;
            tilePicsArray[10].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/player pink.png")) ;
            tilePicsArray[11].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/light green.png")) ;
            tilePicsArray[12].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/green.png")) ;
            tilePicsArray[13].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/player green.png")) ;
            tilePicsArray[14].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/light orange.png")) ;
            tilePicsArray[15].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/orange.png")) ;
            tilePicsArray[16].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/player orange.png")) ;
            tilePicsArray[17].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/light purple.png")) ;
            tilePicsArray[18].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/purple.png")) ;
            tilePicsArray[19].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/purple player.png")) ;
            tilePicsArray[20].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/light yellow.png")) ;
            tilePicsArray[21].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/yellow.png")) ;
            tilePicsArray[22].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/player yellow.png")) ;
            tilePicsArray[27].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/pinkkk.png")) ;
            tilePicsArray[28].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/blueee.png")) ;





        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
