import java.awt.*;
import java.util.ArrayList;

public class MapUpdating {

    public int centerPlayerX = 0 ;
    public int centerPlayerY = 0 ;   // when the game starts player is on (0,0)

    public ArrayList<Tile> coloredTiles = new ArrayList<>() ;
    Tile demo = new Tile() ;

    public MapUpdating (){
        demo.tileX = 1000000000 ;
        demo.tileY = 1000000000 ;
        coloredTiles.add(demo) ;
    }


    public void goingUP (){

        for (int i = 24 ; i > 0 ; i --) {
            for (int j = 0 ; j < 25 ; j ++) {
                CurrentMap.currentScreen[i][j] = CurrentMap.currentScreen[i-1][j] ;
            }
        }

        for(Tile tile : coloredTiles) {

            for (int x = -12 ; x <= 12 ; x ++) {
                if (tile.tileY == centerPlayerY + 13 && tile.tileX == x) {
                    CurrentMap.currentScreen[0][tile.tileX + 12] = tile.tileNumber;
                }
                else {
                    if ( (Math.abs(x) + Math.abs(centerPlayerY + 13))  % 2 == 0 )
                        CurrentMap.currentScreen[0][Math.abs(x + 12)] = 0 ;
                    else
                        CurrentMap.currentScreen[0][Math.abs(x + 12)] = 1 ;
                }

            }

        }
        centerPlayerY ++ ;
    }

    public void goingDown (){

        for (int i = 0 ; i < 24 ; i ++) {
            for (int j = 0 ; j < 25 ; j ++) {
                CurrentMap.currentScreen[i][j] = CurrentMap.currentScreen[i+1][j] ;
            }
        }

        for(Tile tile : coloredTiles) {

            for (int x = -12 ; x <= 12 ; x ++) {
                if (tile.tileY == centerPlayerY - 13 && tile.tileX == x) {
                    CurrentMap.currentScreen[0][tile.tileX + 12] = tile.tileNumber;
                }
                else {
                    if ( (Math.abs(x) + Math.abs(centerPlayerY - 13))  % 2 == 0 )
                        CurrentMap.currentScreen[24][Math.abs(x + 12)] = 0 ;
                    else
                        CurrentMap.currentScreen[24][Math.abs(x + 12)] = 1 ;
                }

            }

        }
        centerPlayerY -- ;
    }

    public void goingRight (){

        for (int i = 0 ; i < 24 ; i ++) {
            for (int j = 0 ; j < 25 ; j ++) {
                CurrentMap.currentScreen[j][i] = CurrentMap.currentScreen[j][i+1] ;
            }
        }

        for(Tile tile : coloredTiles) {

            for (int y = 12 ; y >= -12 ; y--) {
                if (tile.tileX == centerPlayerX + 13 && tile.tileY == y) {
                    CurrentMap.currentScreen[tile.tileY - 12][24] = tile.tileNumber;
                }
                else {
                    if ( (Math.abs(y) + Math.abs(centerPlayerX + 13))  % 2 == 0 )
                        CurrentMap.currentScreen[Math.abs(y-12)][24] = 0 ;
                    else
                        CurrentMap.currentScreen[Math.abs(y-12)][24] = 1 ;
                }

            }

        }
        centerPlayerX ++ ;
    }

    public void goingLeft (){

        for (int i = 24 ; i > 0 ; i --) {
            for (int j = 0 ; j < 25 ; j ++) {
                CurrentMap.currentScreen[j][i] = CurrentMap.currentScreen[j][i-1] ;
            }
        }

        for(Tile tile : coloredTiles) {

            for (int y = 12 ; y >= -12 ; y--) {
                if (tile.tileX == centerPlayerX - 13 && tile.tileY == y) {
                    CurrentMap.currentScreen[tile.tileY + 12][0] = tile.tileNumber;
                }
                else {
                    if ( (Math.abs(y) + Math.abs(centerPlayerX - 13))  % 2 == 0 )
                        CurrentMap.currentScreen[Math.abs(y+12)][0] = 0 ;
                    else
                        CurrentMap.currentScreen[Math.abs(y+12)][0] = 1 ;
                }

            }

        }
        centerPlayerX -- ;

    }


}
