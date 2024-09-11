package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class CoordinateYPanel extends JPanel {
    CoordinateYPanel(int x, int y){
        super();
        this.setLayout(new GridLayout(10, 1));
        this.setBounds(x, y, 50, 600);

        addLabels();

    }

    public void addLabels(){
        JLabel[] letters = new JLabel[10];
        char letter = 'A';

        for (int k = 0; k < letters.length; k++) {;
            letters[k] = new JLabel(String.valueOf(letter));
            letters[k].setHorizontalAlignment(JLabel.CENTER);
            add(letters[k]);
            letter++;

        }
    }

}
