import java.awt.image.BufferedImage;

public class Tile {

    public BufferedImage tileImage ;
    public TileStates tileState ;
    public int tileX ;
    public int tileY ;
    public Tile upTile ;
    public Tile downTile ;
    public Tile rightTile ;
    public Tile leftTile ;

    public Tile (){

    }

    public Tile (BufferedImage tileImage , TileStates tileState , int tileX , int tileY ,
                 Tile upTile , Tile downTile , Tile rightTile , Tile leftTile){
        this.tileImage = tileImage ;
        this.tileState = tileState ;
        tileState = TileStates.empty ;
        this.tileX = tileX ;
        this.tileY = tileY ;
        this.upTile = upTile ;
        this.downTile = downTile ;
        this.rightTile = rightTile ;
        this.leftTile = leftTile ;

    }
}
