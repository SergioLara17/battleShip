package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private MainPanel mainPanel;
    private AddShipsPanel adShipsPanel;
    private SecondaryPanel secondaryPanel;
    private CoordinateYPanel y1Panel;
    private CoordinateXPanel x1Panel;
    private CoordinateYPanel y2Panel;
    private CoordinateXPanel x2Panel;

    GameFrame(String name){
        super(name);
        this.setSize(1600,800);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("src\\co\\edu\\uptc\\BattleShip icon.jpg").getImage());
        this.getContentPane().setBackground(new Color(173, 216, 230));

        mainPanel = new MainPanel();
        mainPanel.setBounds(80, 40 ,600, 600);
        mainPanel.setBackground(new Color(37, 36, 64));
        mainPanel.setLayout(new GridLayout(10, 10));

        y1Panel = new CoordinateYPanel(20, 40);
        x1Panel = new CoordinateXPanel(80, 650);

        secondaryPanel = new SecondaryPanel();
        secondaryPanel.setBounds(840, 40, 600, 600);
        secondaryPanel.setBackground(new Color(0x8B0000));
        secondaryPanel.setLayout(new GridLayout(10, 10));

        y2Panel = new CoordinateYPanel(1450, 40);
        x2Panel = new CoordinateXPanel(840, 650);

        adShipsPanel = new AddShipsPanel();

        add(mainPanel);
        add(y1Panel);
        add(x1Panel);
        add(secondaryPanel);
        add(y2Panel);
        add(x2Panel);
        add(adShipsPanel);

    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public SecondaryPanel getSecondaryPanel() {
        return secondaryPanel;
    }

    public void setSecondaryPanel(SecondaryPanel secondaryPanel) {
        this.secondaryPanel = secondaryPanel;
    }

    public AddShipsPanel getAdShipsPanel() {
        return adShipsPanel;
    }

    public JButton[] getAddShipButtons(){
        return adShipsPanel.getAddShipsButtons();
    }

    public JButton[][] getMainPanelButtons(){
        return mainPanel.getButtons();
    }

    public BoxButton[][] getSecondaryPanelButtons(){
        return secondaryPanel.getButtons();
    }
}
