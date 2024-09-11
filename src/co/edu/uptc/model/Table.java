package co.edu.uptc.model;

import java.util.ArrayList;

public class Table {
    private ArrayList<Ship> ships;
    private Box[][] myBoxes;
    private Box[][] enemyBoxes;
    private final int NUMBER_OF_SHIPS = 5;
    private final int BOARD_HEIGHT = 10;
    private final int BOARD_WIDTH = 10;

    private void initializeTable(){
        char column = 'A';
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                myBoxes[i][j] = new Box(column, j);
                enemyBoxes[i][j] = new Box(column, j);

            }
            column++;
        }

    }

    public Table(){
        ships = new ArrayList<>(NUMBER_OF_SHIPS);
        myBoxes = new Box[BOARD_WIDTH][BOARD_HEIGHT];
        enemyBoxes = new Box[BOARD_WIDTH][BOARD_HEIGHT];
        initializeTable();
    }

    public void addShip(Ship e){
        ships.add(e);
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public Box[][] getMyBoxes() {
        return myBoxes;
    }

    public Box[][] getEnemyBoxes() {
        return enemyBoxes;
    }
}
