import java.awt.*;
import java.util.ArrayList;

public class MapUpdating {

    public static int playerX = 0 ;
    public static int playerY = 0 ;   // when the game starts player is on (0,0)
                                      // player is always on center

    public static ArrayList<Tile> coloredTiles = new ArrayList<>() ;
    public static boolean up , down , right , left = false;
    Tile demo = new Tile() ;
    Coloring coloring = new Coloring();

    public MapUpdating (){
        demo.tileX = 1000000000 ;
        demo.tileY = 1000000000 ;
        coloredTiles.add(demo) ;
    }


    public void goingUP () {
        up = true ;
        int num = 0;
        boolean isEmpty ;

        for (int i = 24; i > 0; i--) {
            for (int j = 0; j < 25; j++) {
                CurrentMap.currentScreen[i][j] = CurrentMap.currentScreen[i - 1][j];
            }
        }


            for (int x = playerX - 12; x <= playerX + 12; x++) {
                isEmpty = true ;
                for (Tile tile : coloredTiles) {
                    if (tile.tileY == playerY + 13 && tile.tileX == x) {
                        CurrentMap.currentScreen[0][num] = tile.tileNumber;
                        num++;
                        isEmpty = false ;
                        break;
                    }
                }
                if (isEmpty) {
                    if ((Math.abs(x) + Math.abs(playerY + 13)) % 2 == 0) {
                        CurrentMap.currentScreen[0][num] = 0;
                        num++;
                    } else {
                        CurrentMap.currentScreen[0][num] = 1;
                        num++;
                    }
                }


            }

        coloring.paintTail();
        coloring.paintTailArea(playerX , playerY);
        playerY ++ ;
        up = false ;
    }

    public void goingDown (){
        down = true ;
        int num = 0 ;
        boolean isEmpty ;

        for (int i = 0 ; i < 24 ; i ++) {
            for (int j = 0 ; j < 25 ; j ++) {
                CurrentMap.currentScreen[i][j] = CurrentMap.currentScreen[i+1][j] ;
            }
        }

            for (int x = playerX -12 ; x <= playerX + 12 ; x ++) {
                isEmpty =true ;
                for(Tile tile : coloredTiles) {
                    if (tile.tileY == playerY - 13 && tile.tileX == x) {
                        CurrentMap.currentScreen[24][num] = tile.tileNumber;
                        num++;
                        isEmpty = false ;
                        break;
                    }
                }
                if (isEmpty) {
                    if ( (Math.abs(x) + Math.abs(playerY - 13))  % 2 == 0 ) {
                        CurrentMap.currentScreen[24][num] = 0;
                        num ++ ;
                    }
                    else {
                        CurrentMap.currentScreen[24][num] = 1;
                        num ++ ;
                    }
                }

            }

        coloring.paintTail();
        coloring.paintTailArea(playerX , playerY);
        playerY -- ;
        down = false ;
    }

    public void goingRight (){
        right = true ;
        int num = 0 ;
        boolean isEmpty ;

        for (int i = 0 ; i < 24 ; i ++) {
            for (int j = 0 ; j < 25 ; j ++) {
                CurrentMap.currentScreen[j][i] = CurrentMap.currentScreen[j][i+1] ;
            }
        }

            for (int y = playerY +12 ; y >= playerY -12 ; y--) {
                isEmpty = true ;
                for(Tile tile : coloredTiles) {
                    if (tile.tileX == playerX + 13 && tile.tileY == y) {
                        CurrentMap.currentScreen[num][24] = tile.tileNumber;
                        num++;
                        isEmpty = false ;
                        break;
                    }
                }
                if (isEmpty) {
                    if ( (Math.abs(y) + Math.abs(playerX + 13))  % 2 == 0 ) {
                        CurrentMap.currentScreen[num][24] = 0;
                        num ++ ;
                    }
                    else {
                        CurrentMap.currentScreen[num][24] = 1;
                        num ++;
                    }
                }

            }

        coloring.paintTail();
        coloring.paintTailArea(playerX , playerY);
        playerX ++ ;
        right = false ;
    }

    public void goingLeft (){
        left = true ;
        int num = 0 ;
        boolean isEmpty ;

        for (int i = 24 ; i > 0 ; i --) {
            for (int j = 0 ; j < 25 ; j ++) {
                CurrentMap.currentScreen[j][i] = CurrentMap.currentScreen[j][i-1] ;
            }
        }

            for (int y = playerY + 12 ; y >= playerY -12 ; y--) {
                isEmpty = true ;
                for(Tile tile : coloredTiles) {
                    if (tile.tileX == playerX - 13 && tile.tileY == y) {
                        CurrentMap.currentScreen[num][0] = tile.tileNumber;
                        num++;
                        isEmpty = false ;
                        break;
                    }
                }
                if (isEmpty) {
                    if ( (Math.abs(y) + Math.abs(playerX - 13))  % 2 == 0 ) {
                        CurrentMap.currentScreen[num][0] = 0;
                        num ++ ;
                    }
                    else {
                        CurrentMap.currentScreen[num][0] = 1;
                        num ++ ;
                    }
                }

            }

        coloring.paintTail();
        coloring.paintTailArea(playerX , playerY);
        playerX -- ;
        left = false ;

    }


}
