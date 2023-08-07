public class Weapon {

   Player player = new Player();
   //GamePanel gamePanel = new GamePanel();

    public void weaponA () {

        int playerX = MapUpdating.playerX ;
        int playerY = MapUpdating.playerY ;

        if (KeyHandler.upPressed || KeyHandler.isGoingUp) {
            for (int i = 7; i <= 9; i++) {
                for (int j = 26; j <= 28; j++) {
                    CurrentMap.currentScreen[i][j] = 3;

                    for (Tile tile : MapUpdating.coloredTiles) {
                        if (tile.tileX == (j -27 + playerX) &&
                                tile.tileY == (i -1 + playerY)&&
                                tile.tileState == TileStates.playerONIt) {
                            System.out.println("killl");
                            player.removeEnemy();
                            break;
                        }
                    }

                    Tile newTile = new Tile((j - 27 + playerX), (i -1 + playerY) , 3 , TileStates.occupied) ;
                    MapUpdating.coloredTiles.add(newTile) ;
                }
            }
        }

        if (KeyHandler.downPressed || KeyHandler.isGoingDown) {
            for (int i = 21; i <= 23; i++) {
                for (int j = 26; j <= 28; j++) {
                    CurrentMap.currentScreen[i][j] = 3;

                    for (Tile tile : MapUpdating.coloredTiles) {
                        if (tile.tileX == (j -27 + playerX) &&
                                tile.tileY == (i -29 + playerY)&&
                                tile.tileState == TileStates.playerONIt) {
                            System.out.println("killl");
                            player.removeEnemy();
                            break;
                        }
                    }

                    Tile newTile = new Tile((j - 27 + playerX), (i -29 + playerY) , 3 , TileStates.occupied) ;
                    MapUpdating.coloredTiles.add(newTile) ;
                }
            }
        }

        if (KeyHandler.rightPressed || KeyHandler.isGoingRight) {
            for (int i = 14; i <= 16; i++) {
                for (int j = 33; j <= 35; j++) {
                    CurrentMap.currentScreen[i][j] = 3;

                    for (Tile tile : MapUpdating.coloredTiles) {
                        if (tile.tileX == (j -27 + playerX) &&
                                tile.tileY == (i -15 + playerY) &&
                                tile.tileState == TileStates.playerONIt) {
                            System.out.println("killl");
                            player.removeEnemy();
                            break;
                        }
                    }

                    Tile newTile = new Tile((j -27 + playerX), (i -15 + playerY) , 3 , TileStates.occupied) ;
                    MapUpdating.coloredTiles.add(newTile) ;
                }
            }
        }

        if (KeyHandler.leftPressed || KeyHandler.isGoingLeft) {
            for (int i = 14; i <= 16; i++) {
                for (int j = 19; j <= 21; j++) {

                    CurrentMap.currentScreen[i][j] = 3;

                    for (Tile tile : MapUpdating.coloredTiles) {
                        if (tile.tileX == (j -27 + playerX) &&
                                tile.tileY == (i -15 + playerY) &&
                                tile.tileState == TileStates.playerONIt) {
                            System.out.println("killl");
                            player.removeEnemy();
                            break;
                        }
                    }

                    Tile newTile = new Tile((j -27 + playerX), (i -15 + playerY) , 3 , TileStates.occupied) ;
                    MapUpdating.coloredTiles.add(newTile) ;
                }
            }
        }




    }

    public void weaponB () {

    }
}
