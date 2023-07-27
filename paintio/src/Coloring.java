public class Coloring {

    KeyHandler keyHandler = new KeyHandler();

    public void paintTail () {

        boolean isPlayerOnArea = isPlayerOnArea(MapUpdating.playerX , MapUpdating.playerY) ;

        if (! isPlayerOnArea) {
            Tile newTile = new Tile(MapUpdating.playerX, MapUpdating.playerY, 3, TileStates.isOccupying);
            MapUpdating.coloredTiles.add(newTile);

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


    public void paintTailArea (int x , int y) {

        boolean hasReached = false ;  // checking if player has reached any of the colored tiles

        for (Tile tile : MapUpdating.coloredTiles) {
            if (tile.tileX == x && tile.tileY == y &&
                    tile.tileState.equals(TileStates.occupied)) {

                hasReached = true ;
                break;
            }
        }

        if (hasReached) {  // coloring the tail character made (changing light colors into occupied colors)

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

    public void paintInsideArea () {

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
