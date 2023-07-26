import java.awt.*;
import java.util.ArrayList;

public class MapUpdating {

    public int centerPlayerX = 0 ;
    public int centerPlayerY = 0 ;   // when the game starts player is on (0,0)

    public ArrayList<Tile> coloredTiles = new ArrayList<>() ;

    public void goingUP (){

        for (int i = 0 ; i < 24 ; i ++) {
            for (int j = 0 ; j < 25 ; j ++) {
                CurrentMap.currentScreen[i+1][j] = CurrentMap.currentScreen[i][j] ;
            }
        }

        for(Tile tile : coloredTiles) {
            for (int i = -12 ; i <= 12 ; i ++) {
                if (tile.tileY == centerPlayerY + 13 && tile.tileX == i) {
                    CurrentMap.currentScreen[0][tile.tileX + 12] = tile.tileNumber;
                }
                else {
                    if ( (tile.tileX + tile.tileY) % 2 == 0 )
                        CurrentMap.currentScreen[0][tile.tileX + 12] = 0 ;
                    else
                        CurrentMap.currentScreen[0][tile.tileX + 12] = 2 ;
                }

            }

        }

    }

    public void goingDown (){

    }

    public void goingRight (){

    }

    public void goingLeft (){

    }


}
