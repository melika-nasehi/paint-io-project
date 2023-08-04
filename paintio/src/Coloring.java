import java.awt.*;
import java.util.ArrayList;

public class Coloring {

    KeyHandler keyHandler = new KeyHandler();
    ArrayList<Tile> tails = new ArrayList<>() ;

    public void paintTail () {

        boolean isPlayerOnArea = isPlayerOnArea(MapUpdating.playerX , MapUpdating.playerY , 3) ;

        if (! isPlayerOnArea) {

            Tile newTile = new Tile(MapUpdating.playerX, MapUpdating.playerY, 2, TileStates.isOccupying);
            MapUpdating.coloredTiles.add(newTile);
            tails.add(newTile) ;

            if (MapUpdating.up)
                CurrentMap.currentScreen[16][27] = 2;

            else if (MapUpdating.down)
                CurrentMap.currentScreen[14][27] = 2;

            else if (MapUpdating.right)
                CurrentMap.currentScreen[15][26] = 2;

            else if (MapUpdating.left)
                CurrentMap.currentScreen[15][28] = 2;
        }
    }


    public void paintTailArea (int x , int y) {   // x & y of player

        boolean hasReached = false ;  // checking if player has reached any of the colored tiles
        boolean isThereAnyTail = false ;

        for (Tile tile : MapUpdating.coloredTiles) {
            if (tile.tileX == x && tile.tileY == y &&
                    tile.tileNumber == 3) {

                hasReached = true ;
                break;
            }
        }

        for (Tile tile : MapUpdating.coloredTiles) {
            if (tile.tileNumber == 2) {
                isThereAnyTail = true ;
                break;
            }
        }

        if (hasReached && isThereAnyTail) {  // coloring the tail character made (changing light colors into occupied colors)

            paintInsideArea(2 , 3 , 80);

            for (Tile tile : MapUpdating.coloredTiles) {
                if (tile.tileNumber == 2) {
                    tile.setTileState(TileStates.occupied);
                    tile.setTileNumber(3);
                }
            }

            for (int i = 0 ; i < 31 ; i ++ ) {
                for (int j = 0 ; j < 55 ; j ++) {
                    if (CurrentMap.currentScreen[i][j] == 2)  // checking if it is light color

                        CurrentMap.currentScreen[i][j] = 3 ;
                }
            }

        }

    }




    public void paintInsideArea (int lightNum , int colorNum , int playerColor) {

        for (int i = 0 ; i < 31 ; i ++) {
            for (int j = 0 ; j < 55 ; j ++) {
                if (CurrentMap.currentScreen[i][j] == lightNum || CurrentMap.currentScreen[i][j] == colorNum ) {
                    for (int k = j+1 ; k < 55 ; k ++) {
                        if (CurrentMap.currentScreen[i][k] == lightNum || CurrentMap.currentScreen[i][k] == colorNum ) {
                            for (int t = k-1 ; t > j ; t --) {
                                if (CurrentMap.currentScreen[i][t] != playerColor)
                                    CurrentMap.currentScreen[i][t] = colorNum ;
                            }
                            break;
                        }
                    }
                }
            }
        }

        int maxY = 0 ;
        int minY = 0 ;
        int minX = 0 ;
        int maxX = 0 ;
        boolean alreadyAdded = false;
        boolean doOnce = true ;
        boolean doOnce2 = true ;
        boolean doOnce3 = true ;
        boolean doOnce4 = true ;

        for (Tile tile : MapUpdating.coloredTiles) {
            if (tile.tileNumber == lightNum || tile.tileNumber == colorNum) {
                if (doOnce) {
                    maxY = tile.tileY;
                    doOnce = false;
                }
                if (tile.tileY > maxY) {
                    maxY = tile.tileY;
                }
            }
        }

        for (Tile tile : MapUpdating.coloredTiles) {
            if (tile.tileNumber == lightNum || tile.tileNumber == colorNum) {
                if (doOnce2) {
                    minY = tile.tileY;
                    doOnce2 = false;
                }
                if (tile.tileY < minY) {
                    minY = tile.tileY;
                }
            }
        }


        for (int y = maxY ; y >= minY ; y-- ) {

            doOnce3 = doOnce4 = true ;

            for (Tile tile : MapUpdating.coloredTiles) {
                if (tile.tileNumber == lightNum || tile.tileNumber == colorNum) {
                    if (tile.tileY == y) {
                        if (doOnce3) {
                            minX = tile.tileX;
                            doOnce3 = false;
                        }
                        if (tile.tileX < minX)
                            minX = tile.tileX;
                    }
                }
            }

            for (Tile tile : MapUpdating.coloredTiles) {
                if (tile.tileNumber == lightNum || tile.tileNumber == colorNum) {
                    if (tile.tileY == y) {
                        if (doOnce4) {
                            maxX = tile.tileX;
                            doOnce4 = false;
                        }
                        if (tile.tileX > maxX)
                            maxX = tile.tileX;
                    }
                }
            }

            for (int x = minX ; x < maxX ; x ++) {

                for (Tile tile : MapUpdating.coloredTiles) {
                    if (tile.tileNumber == lightNum || tile.tileNumber == colorNum) {
                        if (tile.tileX == x && tile.tileY == y) {
                            alreadyAdded = true;
                            tile.tileNumber = colorNum;
                            tile.tileState = TileStates.occupied;
                            break;
                        }
                    }
                }

                if (!alreadyAdded) {
                    Tile newTile = new Tile(x, y, colorNum, TileStates.occupied);
                    MapUpdating.coloredTiles.add(newTile);
                }

                alreadyAdded = false ;

            }
        }


    }

    public boolean isPlayerOnArea (int x , int y , int tileNum) {
        boolean result = false ;
        for (Tile tile : MapUpdating.coloredTiles) {
            if (tile.tileX == x && tile.tileY == y
                    && tile.tileNumber == tileNum ) {

                result = true ;
                break;
            }

        }
        return result ;
    }







//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void paintInsideArea1 () {
        int maxY = 0 ;
        int minX = 0 ;
        int minY = 0 ;
        boolean lineFinished = false ;

        for (Tile tile : tails) {     // maximum Y in tail tiles
            if (tile.tileY > maxY )
                maxY = tile.tileY ;
        }

        for (Tile tile : tails) {     // minimum Y in tail tiles
            if (tile.tileY < minY )
                minY = tile.tileY ;
        }

        for (Tile tile : tails) {       // finding the most left X in each line
            if (tile.tileY == maxY) {
                if (tile.tileX < minX)
                    minX = tile.tileX;
            }
        }

        System.out.println(maxY);
        System.out.println(minY);
        System.out.println(minX);


        while (maxY >= minY) {

            lineFinished = false;

            for (Tile tile : MapUpdating.coloredTiles) {
                if (tile.tileY == maxY && tile.tileX == minX + 1 &&
                        (tile.tileState.equals(TileStates.occupied) || tile.tileState.equals(TileStates.isOccupying))) {
                    lineFinished = true;
                    break;
                }
            }

            if (! lineFinished) {

                Tile newTile = new Tile(minX + 1, maxY, 4, TileStates.occupied);
                MapUpdating.coloredTiles.add(newTile);
                minX = minX + 1;
            }

            else {
                maxY = maxY -1 ;

                for (Tile tile : tails) {       // finding the most left X in each line
                    if (tile.tileY == maxY) {
                        if (tile.tileX < minX)
                            minX = tile.tileX;
                    }
                }
            }

        }


    }

    public void paintInsideArea2(){

        boolean borderFound = false;
        int borderI = 0 ;

        int[][] shouldBePainted = new int[25][25] ;

        for (int i = 0 ; i < 25 ; i ++) {
            for (int j = 0 ; j < 25 ; j ++){
                if (CurrentMap.currentScreen[i][j] == 3 && CurrentMap.currentScreen[i][j+1]== 3 ){
                    borderFound = true ;
                    borderI = i ;
                    break;
                }
            }
        }

        if (borderFound) {
            for (int k = 0 ; k < 25 ; k++) {
                if (CurrentMap.currentScreen[borderI -1][k] == 3) {
                    for (int t = k +1 ; k < 25 ; k++) {
                        if ((CurrentMap.currentScreen[borderI -1][t] == 3) || (CurrentMap.currentScreen[borderI -1][t] == 4)){
                            for (int r = k+1 ; r < t ; r++ ) {
                                shouldBePainted[borderI-1][r] = 4 ;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0 ; i < 25 ; i ++) {
            for (int j = 0 ; j < 25 ; j ++) {
                if (shouldBePainted[i][j] != 0) {
                    CurrentMap.currentScreen[i][j] = shouldBePainted[i][j] ;

                }
            }
        }


    }


    public void paintInsideArea3 (){

        int nPoints ;
        nPoints = tails.size()  ;
        int[] xPoints = new int[nPoints];
        int[] yPoints = new int[nPoints] ;
        int num = 0  ;

        for (Tile tile : tails) {
            xPoints[num] = tile.tileX ;
            yPoints[num] = tile.tileY ;
            num++ ;
        }

        Polygon polygon = new Polygon(xPoints , yPoints , nPoints) ;

        int x = MapUpdating.playerX ;
        int y = MapUpdating.playerY ;
        x -= 12 ;
        y += 12 ;

        if (MapUpdating.up)
            y += 0 ;
        if (MapUpdating.down)
            y -= 1 ;
        if (MapUpdating.right)
            x += 0 ;
        if (MapUpdating.left)
            x -= 1 ;

        for (int i = 0 ; i < 25 ; i ++) {
            for  (int j = 0 ; j < 25 ; j ++) {
                if (polygon.getBounds().contains(x , y) ) {
                    CurrentMap.currentScreen[i][j] = 4 ;
                    Tile newTile = new Tile(x , y , 4 , TileStates.occupied) ;
                    MapUpdating.coloredTiles.add(newTile) ;
                }
                x ++ ;
            }
            y -- ;
            x -= 25 ;
        }

        tails.clear();
        polygon.reset();

    }







}





