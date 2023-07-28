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

            paintInsideArea2();

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

        int[][] shouldBePainted = new int[25][25] ;

        for (int i = 0 ; i < 25 ; i ++) {
            for (int j = 0 ; j < 25 ; j ++){
                if (CurrentMap.currentScreen[i][j] == 3 ){  // if it was a tail
                    System.out.println("hi");
                    while ((CurrentMap.currentScreen[i][j+1] != 3 && CurrentMap.currentScreen[i][j+1] != 4) && (j < 23)) {
                        shouldBePainted[i][j+1] = 4 ;
                        j++ ;
                    }
                    break;
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
}
