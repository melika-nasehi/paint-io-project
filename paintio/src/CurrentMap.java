import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class CurrentMap {

    public int screenX ;
    public int screenY ;
    public static ArrayList<Tile> tilesOnScreen = new ArrayList<Tile>();   // 625 tiles display at a moment
    GamePanel gamePanel ;

    Tile [] tilePicsArray ;

    public CurrentMap (GamePanel gamePanel) {
        this.gamePanel = gamePanel ;
        tilePicsArray = new Tile[15];
        getTileImage();
    }

    public void getTileImage() {
        tilePicsArray[0] = new Tile() ;
        tilePicsArray[1] = new Tile() ;
        tilePicsArray[2] = new Tile() ;
        try {

            tilePicsArray[0].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/gary tile.png")) ;

            tilePicsArray[1].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/white tile.png")) ;
            tilePicsArray [2].tileImage = ImageIO.read(getClass().getResourceAsStream("/images/blue.png")) ;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(){

    }

    public void draw (Graphics2D graphics2D) {

        int x = 0 ;
        int y = 0;
        int row ;
        int col ;
        boolean isGray = true ;
        BufferedImage tilePic ;
        Tile upTile = new Tile() ;
        Tile downTile = new Tile();
        Tile rightTile = new Tile() ;
        Tile leftTile = new Tile() ;

        for ( row = -12 ; row <= 12 ; row ++ ) {

            for (col = 12 ; col >= -12 ; col --) {

                if (isGray) {
                    graphics2D.drawImage(tilePicsArray[0].tileImage, x, y,
                            gamePanel.displayedTileSize, gamePanel.displayedTileSize, null);
                    isGray = false ;
                    tilePic = tilePicsArray[0].tileImage ;
                }
                else {
                    graphics2D.drawImage(tilePicsArray[1].tileImage, x, y,
                            gamePanel.displayedTileSize, gamePanel.displayedTileSize, null);
                    isGray = true ;
                    tilePic = tilePicsArray[1].tileImage ;
                }

                x = x + gamePanel.displayedTileSize ;
                Tile thisTile = new Tile() ;
                initializeNeighborTiles(thisTile , upTile , downTile , rightTile , leftTile);
                thisTile = new Tile(tilePic , TileStates.empty , row , col ,upTile , downTile , rightTile , leftTile) ;
                tilesOnScreen.add(thisTile);

            }
            y = y + gamePanel.displayedTileSize ;
            x = 0 ;

        }

    }

    public void initializeNeighborTiles(Tile tile , Tile upTile , Tile downTile , Tile rightTile , Tile leftTile) {

        upTile.tileX = tile.tileX ;
        upTile.tileY = tile.tileY + 1 ;

        downTile.tileX = tile.tileX ;
        downTile.tileY = tile.tileY - 1 ;

        rightTile.tileX = tile.tileX + 1 ;
        rightTile.tileY = tile.tileY ;

        leftTile.tileX = tile.tileX - 1 ;
        leftTile.tileY = tile.tileY ;

    }

}
