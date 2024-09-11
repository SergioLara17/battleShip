package co.edu.uptc.model;

public interface ModelBehave {
    public void register(String name);
    public boolean player1Attack(int x, int y);
    public boolean player2Attack(int x, int y);
    public void addShipToPlayer1(int[][] shipCoordinates, int id);
    public void addShipsToPlayer2(int shipSize);
    public  boolean isShipOnPlayer1(int x, int y);
}
