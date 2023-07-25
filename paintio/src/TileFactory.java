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

    public TileFactory(GamePanel gp) {
        this.gp = gp ;
        tilePicsArray = new Tile[15];
        mapTileNum = new int[gp.screenCol][gp.screenRow] ;

        getTileImage();
        loadMap();
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

    public void loadMap(){

        try{
            InputStream inputStream = getClass().getResourceAsStream("/text/map_25.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)) ;

            int col ;
            int row ;

            for (row = 0  ; row < gp.screenRow ; row ++ ) {
                String line = br.readLine();

                for (col = 0 ; col < gp.screenCol ; col ++) {

                    String numbers[] = line.split(" " );
                    int num = Integer.parseInt(numbers[col]) ;
                    mapTileNum[col][row] = num ;
                }
            }
            br.close();

        }catch (Exception e) {}


    }

    public void draw (Graphics2D graphics2D) {
        int x = 0 ;
        int y = 0;
        int row ;
        int col ;

        for ( row = 0 ; row < gp.screenRow ; row ++ ) {

            for (col = 0 ; col < gp.screenCol ; col ++) {

                int tileNum = mapTileNum[row][col] ;

                    graphics2D.drawImage(tilePicsArray[tileNum].tileImage, x, y,
                            gp.displayedTileSize, gp.displayedTileSize, null);

                x = x + gp.displayedTileSize ;
            }
            y = y + gp.displayedTileSize ;
            x = 0 ;
        }

    }
}
