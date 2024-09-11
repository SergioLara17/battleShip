package co.edu.uptc.model;

import java.util.Arrays;

public class Ship {
    private int id;
    private int sizeInBoxes;
    private int life;
    private int[][] coordinates;

    public Ship(int sizeInBoxes, int id){
        this.sizeInBoxes = sizeInBoxes;
        life = sizeInBoxes;
        this.id = id;

        if (sizeInBoxes == 2){
            coordinates = new int[2][2];

        } else if (sizeInBoxes == 3) {
            coordinates = new int[3][2];

        }

    }

    public boolean isAlive(){
        return life != 0;
    }

    public int getSizeInBoxes() {
        return sizeInBoxes;
    }

    public void setSizeInBoxes(int sizeInBoxes) {
        this.sizeInBoxes = sizeInBoxes;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int[][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[][] coordinates) {
        this.coordinates = coordinates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String meesage = "";

        for (int i = 0; i < coordinates.length; i++) {
            meesage += "coordenada numero " + i + "[";
            meesage += " x = " + coordinates[i][0] + ", ";
            meesage += "y = " + coordinates[i][1] + "] \n";
        }

        return meesage;
    }
}
