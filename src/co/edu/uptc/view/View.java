package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View implements ViewBehave {
    private ImageIcon battleShipIcon;
    private StartFrame starPageFrame;

    public View() {
        starPageFrame = new StartFrame("Welcome to BattleShip");
        starPageFrame.setVisible(true);
    }

    public void changeAddShipButtonEnable(boolean e, int button){
        getAddShipButtons()[button].setEnabled(e);
    }

    public void putPlayer1ShipOnBoard(int[][] shipCoordinates){
        ImageIcon shipIcon = new ImageIcon("src\\co\\edu\\uptc\\icono de barco.jpg");
        int newWidth = 60; // Nuevo ancho en píxeles
        int newHeight = 60; // Nueva altura en píxeles
        Image resizedShipIcon = shipIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        shipIcon = new ImageIcon(resizedShipIcon);

        for (int[] shipCoordinate : shipCoordinates) {
            getMainPanelButtons()[shipCoordinate[1]][shipCoordinate[0]].setIcon(shipIcon);

        }
    }

    @Override
    public void changeImageIconToAttackInPlayer2(int x, int y) {
        int newWidth = 20; // Nuevo ancho en píxeles
        int newHeight = 20; // Nueva altura en píxeles
        ImageIcon explosionIcon = new ImageIcon("src\\co\\edu\\uptc\\explotion icon.png");
        Image resizedExplosionIcon = explosionIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        explosionIcon = new ImageIcon(resizedExplosionIcon);

        getSecondaryPanelButtons()[y][x].setIcon(explosionIcon); // se intercambia ya que i es representado por y y x por j

    }

    @Override
    public void changeImageIconToAttackInPlayer1(int x, int y) {
        int newWidth = 20; // Nuevo ancho en píxeles
        int newHeight = 20; // Nueva altura en píxeles
        ImageIcon explosionIcon = new ImageIcon("src\\co\\edu\\uptc\\explotion icon.png");
        Image resizedExplosionIcon = explosionIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        explosionIcon = new ImageIcon(resizedExplosionIcon);

        getMainPanelButtons()[y][x].setIcon(explosionIcon); // se intercambia ya que i es representado por y y x por j

    }
    
    @Override
    public void changeButtonEnableInPlayer2(boolean e, int x, int y){
        getSecondaryPanelButtons()[y][x].setEnabled(e); // se intercambia ya que i es representado por y y x por j

    }

    @Override
    public void changeButtonEnableInPlayer1(boolean e, int x, int y){
        getMainPanelButtons()[y][x].setEnabled(e); // se intercambia ya que i es representado por y y x por j

    }

    public void setBattleShipIcon(ImageIcon battleShipIcon) {
        this.battleShipIcon = battleShipIcon;
    }

    public StartFrame getStarPageFrame() {
        return starPageFrame;
    }

    public void setStarPageFrame(StartFrame starPageFrame) {
        this.starPageFrame = starPageFrame;
    }

    public JButton[] getAddShipButtons(){
        return starPageFrame.getAddShipButtons();
    }

    public JButton[][] getMainPanelButtons(){
        return starPageFrame.getMainPanelButtons();
    }

    public BoxButton[][] getSecondaryPanelButtons(){
        return starPageFrame.getSecondaryPanelButtons();
    }

    @Override
    public String readData(String message){
        return (String) JOptionPane.showInputDialog(message);
    }

    @Override
    public void addActionListenerToButtons(ActionListener e) {
        getStarPageFrame().getLoginFrame().getSubmitButton().addActionListener(e);

        getAddShipButtons()[0].addActionListener(e);
        getAddShipButtons()[1].addActionListener(e);
        getAddShipButtons()[2].addActionListener(e);
        getAddShipButtons()[3].addActionListener(e);
        getAddShipButtons()[4].addActionListener(e);

        for (int i = 0; i < getMainPanelButtons().length; i++) {
            for (int j = 0; j < getMainPanelButtons()[0].length; j++) {
                getMainPanelButtons()[i][j].addActionListener(e);
                getSecondaryPanelButtons()[i][j].addActionListener(e);

            }

        }

    }

    @Override
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public String register(boolean isVisible) {
        starPageFrame.getLoginFrame().setVisible(isVisible);
        return starPageFrame.getTextOfUsernameTextField();
        

    }

    @Override
    public void startGame() {
        starPageFrame.getLoginFrame().getGameFrame().setVisible(true);

    }
}
