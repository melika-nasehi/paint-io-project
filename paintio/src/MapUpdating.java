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


    public void goingUP () {

        int num = 0;
        boolean isEmpty ;

        for (int i = 24; i > 0; i--) {
            for (int j = 0; j < 25; j++) {
                CurrentMap.currentScreen[i][j] = CurrentMap.currentScreen[i - 1][j];
            }
        }


            for (int x = centerPlayerX - 12; x <= centerPlayerX + 12; x++) {
                isEmpty = true ;
                for (Tile tile : coloredTiles) {
                    if (tile.tileY == centerPlayerY + 13 && tile.tileX == x) {
                        CurrentMap.currentScreen[0][num] = tile.tileNumber;
                        num++;
                        isEmpty = false ;
                        break;
                    }
                }
                if (isEmpty) {
                    if ((Math.abs(x) + Math.abs(centerPlayerY + 13)) % 2 == 0) {
                        CurrentMap.currentScreen[0][num] = 0;
                        num++;
                    } else {
                        CurrentMap.currentScreen[0][num] = 1;
                        num++;
                    }
                }


            }

        Tile newTile = new Tile(centerPlayerX , centerPlayerY , 3 , TileStates.isOccupying ) ;
        coloredTiles.add(newTile) ;
        CurrentMap.currentScreen[12][12] = 3 ;
        centerPlayerY ++ ;
    }

    public void goingDown (){

        int num = 0 ;
        boolean isEmpty ;

        for (int i = 0 ; i < 24 ; i ++) {
            for (int j = 0 ; j < 25 ; j ++) {
                CurrentMap.currentScreen[i][j] = CurrentMap.currentScreen[i+1][j] ;
            }
        }

            for (int x = centerPlayerX -12 ; x <= centerPlayerX + 12 ; x ++) {
                isEmpty =true ;
                for(Tile tile : coloredTiles) {
                    if (tile.tileY == centerPlayerY - 13 && tile.tileX == x) {
                        CurrentMap.currentScreen[24][num] = tile.tileNumber;
                        num++;
                        isEmpty = false ;
                        break;
                    }
                }
                if (isEmpty) {
                    if ( (Math.abs(x) + Math.abs(centerPlayerY - 13))  % 2 == 0 ) {
                        CurrentMap.currentScreen[24][num] = 0;
                        num ++ ;
                    }
                    else {
                        CurrentMap.currentScreen[24][num] = 1;
                        num ++ ;
                    }
                }

            }

        Tile newTile = new Tile(centerPlayerX , centerPlayerY , 3 , TileStates.isOccupying ) ;
        coloredTiles.add(newTile) ;
        CurrentMap.currentScreen[12][12] = 3 ;
        centerPlayerY -- ;
    }

    public void goingRight (){

        int num = 0 ;
        boolean isEmpty ;

        for (int i = 0 ; i < 24 ; i ++) {
            for (int j = 0 ; j < 25 ; j ++) {
                CurrentMap.currentScreen[j][i] = CurrentMap.currentScreen[j][i+1] ;
            }
        }

            for (int y = centerPlayerY +12 ; y >= centerPlayerY -12 ; y--) {
                isEmpty = true ;
                for(Tile tile : coloredTiles) {
                    if (tile.tileX == centerPlayerX + 13 && tile.tileY == y) {
                        CurrentMap.currentScreen[num][24] = tile.tileNumber;
                        num++;
                        isEmpty = false ;
                        break;
                    }
                }
                if (isEmpty) {
                    if ( (Math.abs(y) + Math.abs(centerPlayerX + 13))  % 2 == 0 ) {
                        CurrentMap.currentScreen[num][24] = 0;
                        num ++ ;
                    }
                    else {
                        CurrentMap.currentScreen[num][24] = 1;
                        num ++;
                    }
                }

            }

        Tile newTile = new Tile(centerPlayerX , centerPlayerY , 3 , TileStates.isOccupying ) ;
        coloredTiles.add(newTile) ;
        CurrentMap.currentScreen[12][12] = 3 ;
        centerPlayerX ++ ;
    }

    public void goingLeft (){

        int num = 0 ;
        boolean isEmpty ;

        for (int i = 24 ; i > 0 ; i --) {
            for (int j = 0 ; j < 25 ; j ++) {
                CurrentMap.currentScreen[j][i] = CurrentMap.currentScreen[j][i-1] ;
            }
        }

            for (int y = centerPlayerY + 12 ; y >= centerPlayerY -12 ; y--) {
                isEmpty = true ;
                for(Tile tile : coloredTiles) {
                    if (tile.tileX == centerPlayerX - 13 && tile.tileY == y) {
                        CurrentMap.currentScreen[num][0] = tile.tileNumber;
                        num++;
                        isEmpty = false ;
                        break;
                    }
                }
                if (isEmpty) {
                    if ( (Math.abs(y) + Math.abs(centerPlayerX - 13))  % 2 == 0 ) {
                        CurrentMap.currentScreen[num][0] = 0;
                        num ++ ;
                    }
                    else {
                        CurrentMap.currentScreen[num][0] = 1;
                        num ++ ;
                    }
                }

            }

        Tile newTile = new Tile(centerPlayerX , centerPlayerY , 3 , TileStates.isOccupying ) ;
        coloredTiles.add(newTile) ;
        CurrentMap.currentScreen[12][12] = 3 ;
        centerPlayerX -- ;

    }


}
