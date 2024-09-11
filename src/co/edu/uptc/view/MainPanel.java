package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{
    private JButton[][] buttons;

    MainPanel(){
        super();
        final int ROW_SIZE = 10;
        final int COlUMB_SIZE = 10;

        buttons = new JButton[10][10];


        ImageIcon blueIcon = new ImageIcon("src\\co\\edu\\uptc\\blue icon2.png");
        int newWidth = 20; // Nuevo ancho en píxeles
        int newHeight = 20; // Nueva altura en píxeles
        Image resizedBlueIcon = blueIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        blueIcon = new ImageIcon(resizedBlueIcon);


        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COlUMB_SIZE; j++) {
                buttons[i][j]= new JButton();
                buttons[i][j].setIcon(blueIcon);
                buttons[i][j].setActionCommand("Attack");
                this.add(buttons[i][j]);

            }
        }

    }

    public JButton[][] getButtons() {
        return buttons;
    }
}
