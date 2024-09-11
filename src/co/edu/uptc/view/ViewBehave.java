package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public interface ViewBehave {
    public String register(boolean isVisible);
    public void putPlayer1ShipOnBoard(int[][] shipCoordinates);
    public void changeAddShipButtonEnable(boolean e, int button);
    public void changeImageIconToAttackInPlayer2(int x, int y);
    public void changeImageIconToAttackInPlayer1(int x, int y);
    public void changeButtonEnableInPlayer2(boolean e, int x, int y);
    public void changeButtonEnableInPlayer1(boolean e, int x, int y);
    public void startGame();
    public void showMessage(String message);
    public String readData(String message);
    public void addActionListenerToButtons(ActionListener e);
}
