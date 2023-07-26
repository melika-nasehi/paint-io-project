import java.awt.image.BufferedImage;

public class Tile {

    public BufferedImage tileImage ;
    public TileStates tileState ;
    public int tileNumber ;
    public int tileX ;
    public int tileY ;



    public BufferedImage getTileImage() {
        return tileImage;
    }

    public void setTileImage(BufferedImage tileImage) {
        this.tileImage = tileImage;
    }
}
