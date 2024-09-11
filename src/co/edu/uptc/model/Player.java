package co.edu.uptc.model;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Ship> ships;
    private final int NUMBER_OF_SHIPS = 5;

    public Player(String name){
        this.name = name;
        ships = new ArrayList<>(5);
    }

    public String getName() {
        return name;
    }

   public void addShip(int[][] coordinates, int id){
        Ship e = new Ship(coordinates.length, id);
        e.setCoordinates(coordinates);

        ships.add(e);
   }

   public boolean wasAShipDamage(int coordinateX, int coordinateY){
        for(Ship i: ships){
            int[][] shipCoordinates = i.getCoordinates();
            for (int j = 0; j < shipCoordinates.length ; j++) {
                if(shipCoordinates[j][0] == coordinateX && shipCoordinates[j][1] == coordinateY){
                    int newLife = i.getLife() - 1;
                    i.setLife(newLife);
                    return true;
                }
            }
        }

        return false;
   }

   public int getAmountOfShipsAdded(){
        return ships.size();
   }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public boolean isAShipOn(int x, int y){
        for (Ship i: ships){
            for(int[] j: i.getCoordinates()){
                if(j[0] == x && j[1] == y){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean gameOver(){
        int totalLife = 0;
        for (Ship i: ships){
            totalLife += i.getLife();
        }

        if (totalLife == 0){
            return true;
        }

        return false;
    }
}
