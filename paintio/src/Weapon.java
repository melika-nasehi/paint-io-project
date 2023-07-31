public class Weapon {

    //KeyHandler keyHandler = new KeyHandler();

    public void weaponA () {

        int playerX = MapUpdating.playerX ;
        int playerY = MapUpdating.playerY ;

        if (KeyHandler.upPressed || KeyHandler.isGoingUp) {
            for (int i = 4; i <= 6; i++) {
                for (int j = 11; j <= 13; j++) {
                    CurrentMap.currentScreen[i][j] = 4;
                    Tile newTile = new Tile((j - 12 + playerX), (i + 2 + playerY) , 4 , TileStates.occupied) ;
                    MapUpdating.coloredTiles.add(newTile) ;
                }
            }
        }

        if (KeyHandler.downPressed || KeyHandler.isGoingDown) {
            for (int i = 18; i <= 20; i++) {
                for (int j = 11; j <= 13; j++) {
                    CurrentMap.currentScreen[i][j] = 4;
                    Tile newTile = new Tile((j - 12 + playerX), (i -26 + playerY) , 4 , TileStates.occupied) ;
                    MapUpdating.coloredTiles.add(newTile) ;
                }
            }
        }

        if (KeyHandler.rightPressed || KeyHandler.isGoingRight) {
            for (int i = 11; i <= 13; i++) {
                for (int j = 18; j <= 20; j++) {
                    CurrentMap.currentScreen[i][j] = 4;
                    Tile newTile = new Tile((j - 12 + playerX), (i -12 + playerY) , 4 , TileStates.occupied) ;
                    MapUpdating.coloredTiles.add(newTile) ;
                }
            }
        }

        if (KeyHandler.leftPressed || KeyHandler.isGoingLeft) {
            for (int i = 11; i <= 13; i++) {
                for (int j = 4; j <= 6; j++) {
                    CurrentMap.currentScreen[i][j] = 4;
                    Tile newTile = new Tile((j - 12 + playerX), (i -12 + playerY) , 4 , TileStates.occupied) ;
                    MapUpdating.coloredTiles.add(newTile) ;
                }
            }
        }


    }

    public void weaponB () {

    }
}
