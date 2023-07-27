import java.awt.image.BufferedImage;

public class Tile {
    public int tileX ;
    public int tileY ;
    public int tileNumber ;
    BufferedImage tileImage ;
    TileStates tileState ;

    public Tile (int tileX , int tileY , int tileNumber , TileStates tileState) {
        this.tileX = tileX ;
        this.tileY = tileY ;
        this.tileNumber = tileNumber ;
        this.tileState = tileState ;
    }

    public Tile () {

    }
}
