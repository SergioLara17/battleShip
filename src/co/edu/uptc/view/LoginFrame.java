package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private GameFrame gameFrame;
    private JButton submitButton;
    private JTextField usernameTextField;
    LoginFrame(String name){
        super(name);
        this.setSize(854,720);
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("src\\co\\edu\\uptc\\BattleShip icon.jpg").getImage());
        this.getContentPane().setBackground(new Color(173, 216, 230));

        gameFrame = new GameFrame("BattleShip Game");



        usernameTextField = new JTextField();
        usernameTextField.setPreferredSize(new Dimension(250, 40));
        usernameTextField.setFont(new Font("Console", Font.BOLD, 18));
        usernameTextField.setForeground(new Color(0x00FF00));
        usernameTextField.setBackground(Color.black);
        usernameTextField.setCaretColor(Color.white);
        usernameTextField.setText("Write your username here");

        submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.setActionCommand("Submit");
        

        add(usernameTextField);
        add(submitButton);
        this.pack();

    }



    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(JTextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public JButton[] getAddShipButtons(){
        return gameFrame.getAddShipButtons();
    }

    public JButton[][] getMainPanelButtons(){
        return gameFrame.getMainPanelButtons();
    }

    public BoxButton[][] getSecondaryPanelButtons(){
        return gameFrame.getSecondaryPanelButtons();
    }
}
