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
    Weapon weapon = new Weapon();

    int contrastTile = TileFactory.contrastTile ;

    public MapUpdating (){
        demo.tileX = 0 ;
        demo.tileY = 0 ;
        demo.tileNumber = 3 ;
        demo.tileState = TileStates.occupied ;
        coloredTiles.add(demo) ;
    }


    public void goingUP () {
        up = true ;
        int num = 0;
        boolean isEmpty ;

        for (int i = 30; i > 0; i--) {
            for (int j = 0; j < 55; j++) {
                CurrentMap.currentScreen[i][j] = CurrentMap.currentScreen[i - 1][j];
            }
        }


            for (int x = playerX - 27; x <= playerX + 27 ; x++) {
                isEmpty = true ;
                for (Tile tile : coloredTiles) {
                    if (tile.tileY == playerY + 16 && tile.tileX == x) {
                        CurrentMap.currentScreen[0][num] = tile.tileNumber;
                        num++;
                        isEmpty = false ;
                        break;
                    }
                }
                if (isEmpty) {
                    if ((Math.abs(x) + Math.abs(playerY + 16)) % 2 == 0) {
                        CurrentMap.currentScreen[0][num] = contrastTile;
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

        for (int i = 0 ; i < 30 ; i ++) {
            for (int j = 0 ; j < 55 ; j ++) {
                CurrentMap.currentScreen[i][j] = CurrentMap.currentScreen[i+1][j] ;
            }
        }

            for (int x = playerX - 27 ; x <= playerX + 27 ; x ++) {
                isEmpty =true ;
                for(Tile tile : coloredTiles) {
                    if (tile.tileY == playerY - 16 && tile.tileX == x) {
                        CurrentMap.currentScreen[30][num] = tile.tileNumber;
                        num++;
                        isEmpty = false ;
                        break;
                    }
                }
                if (isEmpty) {
                    if ( (Math.abs(x) + Math.abs(playerY - 16))  % 2 == 0 ) {
                        CurrentMap.currentScreen[30][num] = contrastTile;
                        num ++ ;
                    }
                    else {
                        CurrentMap.currentScreen[30][num] = 1;
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

        for (int j = 0 ; j < 54 ; j ++) {
            for (int i = 0 ; i < 31 ; i ++) {
                CurrentMap.currentScreen[i][j] = CurrentMap.currentScreen[i][j+1] ;
            }
        }

            for (int y = playerY + 15 ; y >= playerY -15 ; y--) {
                isEmpty = true ;
                for(Tile tile : coloredTiles) {
                    if (tile.tileX == playerX + 27 && tile.tileY == y) {
                        CurrentMap.currentScreen[num][54] = tile.tileNumber;
                        num++;
                        isEmpty = false ;
                        break;
                    }
                }
                if (isEmpty) {
                    if ( (Math.abs(y) + Math.abs(playerX + 28))  % 2 == 0 ) {
                        CurrentMap.currentScreen[num][54] = contrastTile;
                        num ++ ;
                    }
                    else {
                        CurrentMap.currentScreen[num][54] = 1;
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

        for (int j = 54 ; j > 0 ; j --) {
            for (int i = 0 ; i < 31 ; i++) {
                CurrentMap.currentScreen[i][j] = CurrentMap.currentScreen[i][j-1] ;
            }
        }

            for (int y = playerY + 15 ; y >= playerY -15 ; y--) {
                isEmpty = true ;
                for(Tile tile : coloredTiles) {
                    if (tile.tileX == playerX - 28 && tile.tileY == y) {
                        CurrentMap.currentScreen[num][0] = tile.tileNumber;
                        num++;
                        isEmpty = false ;
                        break;
                    }
                }
                if (isEmpty) {
                    if ( (Math.abs(y) + Math.abs(playerX - 28))  % 2 == 0 ) {
                        CurrentMap.currentScreen[num][0] = contrastTile;
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
