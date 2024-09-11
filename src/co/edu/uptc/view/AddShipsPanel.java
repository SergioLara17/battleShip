package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class AddShipsPanel extends JPanel {
    private JButton[] addShipsButtons;

    AddShipsPanel(){
        addShipsButtons = new JButton[5];
        addShipsButtons[0] = new JButton("Add ship 1°");
        addShipsButtons[0].setActionCommand("Add ship 1°");
        addShipsButtons[1] = new JButton("Add ship 2°");
        addShipsButtons[1].setActionCommand("Add ship 2°");
        addShipsButtons[2] = new JButton("Add ship 3°");
        addShipsButtons[2].setActionCommand("Add ship 3°");
        addShipsButtons[3] = new JButton("Add ship 4°");
        addShipsButtons[3].setActionCommand("Add ship 4°");
        addShipsButtons[4] = new JButton("Add ship 5°");
        addShipsButtons[4].setActionCommand("Add ship 5°");

        add(addShipsButtons[0]);
        add(addShipsButtons[1]);
        add(addShipsButtons[2]);
        add(addShipsButtons[3]);
        add(addShipsButtons[4]);

        this.setLayout(new FlowLayout(FlowLayout.CENTER,0, 20));
        this.setBounds(700, 40, 120, 600);

    }

    public JButton[] getAddShipsButtons() {
        return addShipsButtons;
    }
}
