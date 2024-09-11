package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class CoordinateXPanel extends JPanel {
    CoordinateXPanel(int x, int y){
        super();
        this.setLayout(new GridLayout(1, 10));
        this.setBounds(x, y, 600, 50);

        addLabels();
    }

    public void addLabels(){
        JLabel[] numbers = new JLabel[10];
        int number = 0;

        for (int k = 0; k < numbers.length; k++) {
            numbers[k] = new JLabel(String.valueOf(number));
            numbers[k].setHorizontalAlignment(JLabel.CENTER);
            add(numbers[k]);
            number++;

        }
    }


}
