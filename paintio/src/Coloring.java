import java.awt.*;
import java.util.ArrayList;

public class Coloring {

    KeyHandler keyHandler = new KeyHandler();
    ArrayList<Tile> tails = new ArrayList<>() ;

    public void paintTail () {

        boolean isPlayerOnArea = isPlayerOnArea(MapUpdating.playerX , MapUpdating.playerY) ;

        if (! isPlayerOnArea) {

            Tile newTile = new Tile(MapUpdating.playerX, MapUpdating.playerY, 3, TileStates.isOccupying);
            MapUpdating.coloredTiles.add(newTile);
            tails.add(newTile) ;

            if (MapUpdating.up)
                CurrentMap.currentScreen[13][12] = 3;

            else if (MapUpdating.down)
                CurrentMap.currentScreen[11][12] = 3;

            else if (MapUpdating.right)
                CurrentMap.currentScreen[12][11] = 3;

            else if (MapUpdating.left)
                CurrentMap.currentScreen[12][13] = 3;
        }
    }


    public void paintTailArea (int x , int y) {   // x & y of player

        boolean hasReached = false ;  // checking if player has reached any of the colored tiles

        for (Tile tile : MapUpdating.coloredTiles) {
            if (tile.tileX == x && tile.tileY == y &&
                    tile.tileState.equals(TileStates.occupied)) {

                hasReached = true ;
                break;
            }
        }

        if (hasReached) {  // coloring the tail character made (changing light colors into occupied colors)

            paintInsideArea3();

            for (Tile tile : MapUpdating.coloredTiles) {
                if (tile.tileState.equals(TileStates.isOccupying)) {
                    tile.setTileState(TileStates.occupied);
                    tile.setTileNumber(4);
                }
            }

            for (int i = 0 ; i < 25 ; i ++ ) {
                for (int j = 0 ; j < 25 ; j ++) {
                    if (CurrentMap.currentScreen[i][j] == 3)  // checking if it is light color

                        CurrentMap.currentScreen[i][j] = 4 ;
                }
            }

        }

    }


    public void paintInsideArea3 (){

        int nPoints ;
        nPoints = tails.size()  ;
        int[] xPoints = new int[nPoints];
        int[] yPoints = new int[nPoints] ;
        int num  ;
        Rectangle bound = new Rectangle();

        num = 0 ;
        for (Tile tile : tails) {
            xPoints[num] = tile.tileX ;
            yPoints[num] = tile.tileY ;
            num++ ;
        }

        Polygon polygon = new Polygon(xPoints , yPoints , nPoints) ;
        bound = polygon.getBounds() ;


        int x = MapUpdating.playerX ;
        int y = MapUpdating.playerY ;
        x -= 12 ;
        y += 12 ;

        if (MapUpdating.up)
            y += 1 ;
        if (MapUpdating.down)
            y -= 1 ;
        if (MapUpdating.right)
            x += 1 ;
        if (MapUpdating.left)
            x -= 1 ;

        for (int i = 0 ; i < 25 ; i ++) {
            for  (int j = 0 ; j < 25 ; j ++) {
                if (bound.contains(x , y) ) {
                    CurrentMap.currentScreen[i][j] = 4 ;
                    Tile newTile = new Tile(x , y , 4 , TileStates.occupied) ;
                    MapUpdating.coloredTiles.add(newTile) ;
                }
                x ++ ;
            }
            y -- ;
            x -= 25 ;
        }

        for (Tile tile : tails) {
            tile = null ;
        }



    }

    public boolean isPlayerOnArea (int x , int y) {
        boolean result = false ;
        for (Tile tile : MapUpdating.coloredTiles) {
            if (tile.tileX == x && tile.tileY == y
                    && tile.tileState.equals(TileStates.occupied)) {

                result = true ;
                break;
            }

        }
        return result ;
    }








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







}




