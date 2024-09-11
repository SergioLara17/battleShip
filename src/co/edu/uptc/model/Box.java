package co.edu.uptc.model;

public class Box {
    private char coordinateY;
    private int coordinateX;
    private boolean isOccupied;
    private boolean wasAttacked;

    public Box(char coordinateY, int coordinateX){
        this.coordinateY = coordinateY;
        this.coordinateX = coordinateX;
        isOccupied = false;
        wasAttacked = false;

    }

    public char getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(char coordinateY) {
        this.coordinateY = coordinateY;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isWasAttacked() {
        return wasAttacked;
    }

    public void setWasAttacked(boolean wasAttacked) {
        this.wasAttacked = wasAttacked;
    }
}
