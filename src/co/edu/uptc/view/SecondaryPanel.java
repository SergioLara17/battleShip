package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class SecondaryPanel extends JPanel {
    private BoxButton[][] buttons;

    SecondaryPanel(){
        final int ROW_SIZE = 10;
        final int COlUMB_SIZE = 10;

        buttons = new BoxButton[10][10];

        int newWidth = 20; // Nuevo ancho en píxeles
        int newHeight = 20; // Nueva altura en píxeles
        ImageIcon redIcon = new ImageIcon("src\\co\\edu\\uptc\\red icon.png");
        Image resizedRedIcon = redIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        redIcon = new ImageIcon(resizedRedIcon);


        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COlUMB_SIZE; j++) {
                buttons[i][j]= new BoxButton(j, i);
                buttons[i][j].setIcon(redIcon);
                buttons[i][j].setActionCommand("Attack");
                this.add(buttons[i][j]);

            }
        }
    }

    public BoxButton[][] getButtons() {
        return buttons;
    }
}
