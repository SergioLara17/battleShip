package co.edu.uptc.model;

import java.util.ArrayList;

public class Game implements ModelBehave {
    private Player player1;
    private final Player player2;


    public Game(String player1Name){
        register(player1Name);
        player2 = new Player("Machine");

    }

    @Override
    public void register(String name) {
        player1 = new Player(name);
    }

    @Override
    public boolean player1Attack(int x, int y) {
        return player2.wasAShipDamage(x, y);

    }

    @Override
    public boolean player2Attack(int x, int y) {
        return player1.wasAShipDamage(x, y);


    }



    @Override
    public void addShipToPlayer1(int[][] shipCoordinates, int id) {
        player1.addShip(shipCoordinates, id);
    }

    @Override
    public void addShipsToPlayer2(int shipSize) {
        boolean wasAdded = false;

        do {
            wasAdded = addShipToPlayer2(shipSize);
        }while (!wasAdded);

    }

    public boolean addShipToPlayer2(int shipSize){
        int coordinateX = (int) (Math.random()*9);
        int coordinateY = (int) (Math.random()*9);
        int orientation = (int) (Math.random()*2);


        if(orientation == 0){ //0 = vertical
            if (checkVertical(coordinateX, coordinateY, shipSize) != null){
                int[][] coordinates = checkVertical(coordinateX, coordinateY, shipSize);
                int id = player2.getAmountOfShipsAdded();

                assert coordinates != null;
                player2.addShip(coordinates, id);


                return true;

            }


        } else if (orientation == 1) { //1 = horizontal
            if (checkHorizontal(coordinateX, coordinateY, shipSize) != null){
                int[][] coordinates = checkHorizontal(coordinateX, coordinateY, shipSize);
                int id = player2.getAmountOfShipsAdded();

                assert coordinates != null;
                player2.addShip(coordinates, id);

                return true;

            }

        }

        return false;
    }

    private int[][] checkHorizontal(int x, int y, int length){
        int[][] checkedCoordinates = new int[length][2]; // number of coordinates per point
        int j = 0;
        for (int i = x; i < (length + x); i++) {
            checkedCoordinates[j][0] = i;
            checkedCoordinates[j][1] = y;
            if(isAShipOnPlayer2(i, y)){
                return null;
            }

            j++;

        }

        return checkedCoordinates;
    }

    private int[][] checkVertical(int x, int y, int length){
        int[][] checkedCoordinates = new int[length][2]; // number of coordinates per point
        int j = 0;
        for (int i = y; i < (length + y); i++) {
            checkedCoordinates[j][0] = x;
            checkedCoordinates[j][1] = i;
            if(isAShipOnPlayer2(x, i)){
                return null;
            }

            j++;

        }

        return checkedCoordinates;
    }

    @Override
    public  boolean isShipOnPlayer1(int x, int y){
        return player1.isAShipOn(x, y);

    }

    public  boolean isAShipOnPlayer2(int x, int y){
         return player2.isAShipOn(x, y);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
