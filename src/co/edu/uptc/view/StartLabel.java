package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class StartLabel extends JLabel {
    StartLabel(){
        super();
        this.setText("Press enter to start");
        this.setIcon(new ImageIcon("src\\co\\edu\\uptc\\BattleShip icon 2.png"));
        this.setHorizontalTextPosition(JLabel.CENTER); // position text related to iconimage;
        this.setVerticalTextPosition(JLabel.BOTTOM); // position text related to iconImage
        this.setForeground(Color.GRAY); //font color
        this.setFont(new Font("Albertus Medium", Font.ROMAN_BASELINE, 20));//set font tex
        this.setIconTextGap(-25);
        this.setBackground(Color.black);// set background Color
        this.setOpaque(true);//display background color
        this.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
        this.setVerticalAlignment(JLabel.NORTH); // set content label position
        this.setHorizontalAlignment(JLabel.CENTER); // set content label position
    }
}
