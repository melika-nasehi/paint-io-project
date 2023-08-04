import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Player{
    String imagePath = "/images/player blue.png" ;
    GamePanel gamePanel ;
    Coloring coloring  = new Coloring() ;
    Random random = new Random() ;
    public int[] colors = {7 , 10 , 13 , 16} ;  // different color codes
    private int playerColor ;
    boolean goingUp , goingDown = true , goingRight , goingLeft ;
    int tileX = 0 , tileY = 0 ;
    int playerX , playerY ;

    public Enemy (GamePanel gamePanel) {
        this.gamePanel = gamePanel ;
        setDefaultValues();
        //getPlayerImage(this.imagePath);

    }

    @Override
    public void update() {
        moving();
        coloring();
        kill(playerX , playerY ,playerColor-2);
    }

    @Override
    public void getPlayerImage(String imagePath) {
        try {

            this.img = ImageIO.read(getClass().getResourceAsStream(imagePath)) ;

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void draw(Graphics2D graphics2D) {

    }

    private int getRandomColors(){
        int rand = random.nextInt(colors.length) ;
        playerColor = colors[rand] ;
        boolean duplicate ;
        boolean finish = false ;
        while (!finish) {
            duplicate = false ;
            for (Integer i : gamePanel.usedColors) {
                if (i == playerColor) {
                    duplicate = true ;
                    break;
                }
            }
            if (duplicate) {
                rand = random.nextInt(colors.length);
                playerColor = colors[rand];
            }
            if (! duplicate)
                finish = true ;

        }

        gamePanel.usedColors.add(playerColor) ;
        return playerColor ;
    }

    @Override
    public void setDefaultValues() {
        int rand1 =0 ;
        int rand2 = 0 ;
        gamePanel.enemyCount ++ ;

        switch (gamePanel.enemyCount) {
            case 1 :
                rand1 = random.nextInt(1 , 22);
                rand2 = random.nextInt(1 , 12);
                break;
            case 2 :
                rand1 = random.nextInt(33 , 53);
                rand2 = random.nextInt(1 , 12);
                break;
            case 3 :
                rand1 = random.nextInt(1 , 22);
                rand2 = random.nextInt(19 , 29);
                break;
            case 4 :
                rand1 = random.nextInt(33 , 53);
                rand2 = random.nextInt(19 , 29);
                break;
        }

        playerColor = getRandomColors() ;

        xPosition = rand1 * gamePanel.displayedTileSize ;
        yPosition = rand2 * gamePanel.displayedTileSize ;

        CurrentMap.currentScreen[rand2][rand1] = playerColor ;

        Tile playerTile = new Tile(rand1 - 27 ,  -rand2 + 15 , playerColor , TileStates.playerONIt) ;
        MapUpdating.coloredTiles.add(playerTile) ;

        playerX = rand1 - 27 ;
        playerY = - rand2 + 15 ;


            for (int i = rand2 - 2 ; i <= rand2 + 2 ; i ++) {
                for (int j = rand1 - 2 ; j <= rand1 + 2 ; j ++) {
                    if ((i != rand2 || j != rand1) && (i >= 0 && i < 31) && (j >= 0 && j < 55) ) {
                        CurrentMap.currentScreen[i][j] = playerColor - 1;
                        Tile newTile = new Tile(playerX + j - rand1 , playerY - i + rand2 ,
                                playerColor - 1 ,TileStates.occupied ) ;
                        MapUpdating.coloredTiles.add(newTile) ;
                    }
                    if (i == rand2 && j == rand1) {
                        Tile newTile = new Tile(playerX + j - rand1 , playerY - i + rand2 ,
                                playerColor - 1 ,TileStates.occupied ) ;
                        MapUpdating.coloredTiles.add(newTile) ;
                    }
                    if ((i >= 0 && i < 31) && (j >= 0 && j < 55)) {

                    }
                }
            }

    }

    public void moving () {
        int rand = random.nextInt(100) ;
        changePlace(goingUp , goingDown , goingRight , goingLeft);

        if (rand <= 5 ) {  // up
           goingUp = true ;
           goingDown = goingRight = goingLeft = false ;
        }

        else if (rand <= 10 ) {  // down
            goingDown = true ;
            goingUp = goingRight = goingLeft = false ;
        }

        else if (rand <= 15 ) {  // right
            goingRight = true ;
            goingUp = goingDown = goingLeft = false ;
        }

        else if (rand <= 20 ) { // left
            goingLeft = true ;
            goingUp = goingDown = goingRight = false ;
        }

    }

    public void changePlace (boolean up , boolean down , boolean right , boolean left ) {
        int direction = 0  ;
        int m = 0 ;
        int n = 0 ;
        if (up) {
            direction = 1 ;
            m = -1 ;
        }
        else if (down) {
            direction = -1 ;
            m = 1 ;
        }
        else if (right) {
            direction = 1;
            n = 1 ;
        }
        else if (left) {
            direction = - 1 ;
            n = -1 ;
        }

        for (Tile tile : MapUpdating.coloredTiles) {
            if (tile.tileNumber == playerColor) {
                int x = tile.getTileX();
                int y = tile.getTileY() ;
                if (up || down)
                    tile.setTileY(y + direction);
                else if (right || left)
                    tile.setTileX(x + direction);
                Tile newTile = new Tile(x , y , playerColor - 2 , TileStates.isOccupying) ;
                MapUpdating.coloredTiles.add(newTile) ;
                tileX = tile.getTileX() ;
                tileY = tile.getTileY() ;
                break;
            }
        }

        //checking if it is in visible area and change the current screen array

        if ((tileX <= MapUpdating.playerX + 28 && tileX >= MapUpdating.playerX - 28) &&
                (tileY <= MapUpdating.playerY + 16 && tileY >= MapUpdating.playerY - 16)) {

            boolean found = false ;
            boolean onArea = false ;
            int t = 0 ;
            if (up||down||right||left)
             t = 55 ;
            for (int i = 0 ; i < 31 ; i++) {
                for (int j = 0 ; j < t ; j++) {
                    if (CurrentMap.currentScreen[i][j] == playerColor ) {

                        if (up && i == 0)
                            CurrentMap.currentScreen[i][j] = playerColor - 2;

                        else if (down && i == 30)
                            CurrentMap.currentScreen[i][j] = playerColor - 2 ;

                        else if (right && j == 54)
                            CurrentMap.currentScreen[i][j] = playerColor - 2 ;

                        else if (left && j == 0)
                            CurrentMap.currentScreen[i][j] = playerColor - 2 ;
                        else {
                            CurrentMap.currentScreen[i+m][j+n] = playerColor ;
                            if (! isPlayerOnArea()) {
                                drawTail(i, j);
                            }
                            else {
                                dontDrawOnArea(i , j);
                                onArea = true ;
                            }
                        }
                        if (!onArea)
                            addNewTile(i , j);
                        found = true ;
                        break;
                    }
                }
                if (found)
                    break;
            }
        }

        if (up)
            playerY ++ ;
        if (down)
            playerY -- ;
        if (right)
            playerX ++ ;
        if (left)
            playerX -- ;

    }

    private void drawTail(int i, int j) {
        CurrentMap.currentScreen[i][j] = playerColor - 2 ;
    }
    private void addNewTile (int i , int j) {
        Tile newTile = new Tile(MapUpdating.playerX + (j - 27) , MapUpdating.playerY - (i - 15) ,
                playerColor -2 , TileStates.isOccupying) ;
        MapUpdating.coloredTiles.add(newTile) ;
    }

    private boolean isPlayerOnArea () {
        return coloring.isPlayerOnArea(playerX , playerY , playerColor -1 ) ;
    }
    private void dontDrawOnArea(int i , int j) {
        CurrentMap.currentScreen[i][j] = playerColor - 1 ;
    }

    private void coloring () {

        //paint tail
        boolean hasReached = false ;  // checking if player has reached any of the colored tiles
        boolean isThereAnyTail = false ;

        for (Tile tile : MapUpdating.coloredTiles) {
            if (tile.tileX == playerX && tile.tileY == playerY &&
                    tile.tileNumber == playerColor - 1) {

                hasReached = true ;
                break;
            }
        }

        for (Tile tile : MapUpdating.coloredTiles) {
            if (tile.tileNumber == playerColor -2 ) {
                isThereAnyTail = true ;
                break;
            }
        }

        if (hasReached && isThereAnyTail) {  // coloring the tail character made (changing light colors into occupied colors)

            coloring.paintInsideArea(playerColor -2 , playerColor -1 , playerColor );

            for (Tile tile : MapUpdating.coloredTiles) {
                if (tile.tileNumber == playerColor - 2) {
                    tile.setTileState(TileStates.occupied);
                    tile.setTileNumber(playerColor - 1);
                }
            }

            for (int i = 0 ; i < 31 ; i ++ ) {
                for (int j = 0 ; j < 55 ; j ++) {
                    if (CurrentMap.currentScreen[i][j] == playerColor - 2)  // checking if it is light color

                        CurrentMap.currentScreen[i][j] = playerColor - 1 ;
                }
            }

        }

    }



}
