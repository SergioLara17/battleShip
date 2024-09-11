package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartFrame extends JFrame implements KeyListener {
    private StartLabel starPageLabel;
    private LoginFrame loginFrame;

    StartFrame(String name){
        super(name);
        this.setSize(854,720);
        this.setResizable(false);
        this.addKeyListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("src\\co\\edu\\uptc\\BattleShip icon.jpg").getImage());
        this.getContentPane().setBackground(new Color(173, 216, 230));

        starPageLabel = new StartLabel();
        add(starPageLabel);

        loginFrame = new LoginFrame("Login");
        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        final int ENTER_KEY_CODE = 10;

        if(e.getKeyCode() == ENTER_KEY_CODE){
            this.dispose();

            loginFrame.setVisible(true);
        }
    }

    public StartLabel getStarPageLabel() {
        return starPageLabel;
    }

    public String getTextOfUsernameTextField(){
        return loginFrame.getUsernameTextField().getText();
    }

    public LoginFrame getLoginFrame() {
        return loginFrame;
    }

    public JButton[] getAddShipButtons(){
        return loginFrame.getAddShipButtons();
    }

    public JButton[][] getMainPanelButtons(){
        return loginFrame.getMainPanelButtons();
    }

    public BoxButton[][] getSecondaryPanelButtons(){
        return loginFrame.getSecondaryPanelButtons();
    }
}
