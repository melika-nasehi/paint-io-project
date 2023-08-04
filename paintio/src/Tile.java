import java.awt.image.BufferedImage;

public class Tile {
    public int tileX ;
    public int tileY ;
    public int tileNumber ;
    BufferedImage tileImage ;
    TileStates tileState = TileStates.empty;

    public Tile (int tileX , int tileY , int tileNumber , TileStates tileState) {
        this.tileX = tileX ;
        this.tileY = tileY ;
        this.tileNumber = tileNumber ;
        this.tileState = tileState ;
    }

    public Tile () {

    }

    public void setTileNumber(int tileNumber) {
        this.tileNumber = tileNumber;
    }

    public void setTileState(TileStates tileState) {
        this.tileState = tileState;
    }

    public void setTileX(int tileX) {
        this.tileX = tileX;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
    }

    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public int getTileNumber() {
        return tileNumber;
    }
}
