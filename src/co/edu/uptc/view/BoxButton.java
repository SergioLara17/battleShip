package co.edu.uptc.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoxButton extends JButton{
    public int coordinateX;
    public int coordinateY;
    public boolean isOccuped;

    public BoxButton(int x, int y){
        super();
        coordinateX = x;
        coordinateY = y;
        isOccuped = false;

    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public boolean isOccuped() {
        return isOccuped;
    }

    public void setOccuped(boolean occuped) {
        isOccuped = occuped;
    }
}
