package co.edu.uptc.presenter;

import co.edu.uptc.model.Game;
import co.edu.uptc.model.ModelBehave;
import co.edu.uptc.view.BoxButton;
import co.edu.uptc.view.View;
import co.edu.uptc.view.ViewBehave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Presenter implements ActionListener, PresenterBehave {
    private ViewBehave view;
    private ModelBehave model;
    private ArrayList<int[]> assertAttacksFromPlayer2;
    private ArrayList<int[]> attackedBoxFromPlayer2;



    public Presenter() {
        assertAttacksFromPlayer2 = new ArrayList<>();
        attackedBoxFromPlayer2 = new ArrayList<>();
        view = new View();

        view.addActionListenerToButtons(this);

    }


    public static void main(String[] args) {
        Presenter pr = new Presenter();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Submit")){
            register();
            view.startGame();

        }

        if (e.getActionCommand().equals("Add ship 1°") ||
                e.getActionCommand().equals("Add ship 2°") ||
                e.getActionCommand().equals("Add ship 3°")){
            int shipNumber = Character.getNumericValue(e.getActionCommand().charAt(9));
            int[][] shipCoordinates = readShipCoordinates(3);

            view.changeAddShipButtonEnable(false, (shipNumber-1));
            view.putPlayer1ShipOnBoard(shipCoordinates);
            model.addShipToPlayer1(shipCoordinates, shipNumber);

            //añadiendo un barco al juegador 2

            model.addShipsToPlayer2(3);

        }else if(e.getActionCommand().equals("Add ship 4°") ||
                e.getActionCommand().equals("Add ship 5°")){
            int shipNumber = Character.getNumericValue(e.getActionCommand().charAt(9));
            int[][] shipCoordinates = readShipCoordinates(2);

            view.changeAddShipButtonEnable(false, (shipNumber-1));
            view.putPlayer1ShipOnBoard(shipCoordinates);
            model.addShipToPlayer1(shipCoordinates, shipNumber);

            //añadiendo un barco al juegador 2

            model.addShipsToPlayer2(2);

        }

        if(e.getActionCommand().equals("Attack")){
            BoxButton selected = (BoxButton) e.getSource();

            player1Attack(selected.getCoordinateX(), selected.coordinateY);

            player2Attack();

            

        }

    }

    private int[][] readShipCoordinates(int shipSize) {
        view.showMessage("A continuación le vamos a pedir las coordenadas de su barco" + "\n" +
                "por favor que las cordenadas esten en linea");
        int[][] coordinates = new int[shipSize][2];
        char coordinateY;

        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i][0] = Integer.parseInt(view.readData("Digite la coordenada x numero " + (i + 1)));
            coordinateY = view.readData("Digite la coordenada y numero " + (i + 1) + " (EN MAYUSCULA)").charAt(0);
            switch (coordinateY) {
                case 'A' -> coordinates[i][1] = 0;
                case 'B' -> coordinates[i][1] = 1;
                case 'C' -> coordinates[i][1] = 2;
                case 'D' -> coordinates[i][1] = 3;
                case 'E' -> coordinates[i][1] = 4;
                case 'F' -> coordinates[i][1] = 5;
                case 'G' -> coordinates[i][1] = 6;
                case 'H' -> coordinates[i][1] = 7;
                case 'I' -> coordinates[i][1] = 8;
                case 'J' -> coordinates[i][1] = 9;

            }

        }

        return coordinates;
    }

    public void machineIntelligenceAlgorithm() {
        int x = (int) (Math.random()*10);
        int y = (int) (Math.random()*10);

        reLocateAttack(x, y);

        attackFoundShip();

        if(model.player2Attack(x, y)){
            assertAttacksFromPlayer2.add(new int[]{x, y});
            view.changeImageIconToAttackInPlayer1(x, y);
        } else {
            attackedBoxFromPlayer2.add(new int[]{x,y});
            view.changeButtonEnableInPlayer1(false, x, y);
        }
    }

    private boolean attackFoundShip () {
        if (!assertAttacksFromPlayer2.isEmpty()) {
            for (int[] i : assertAttacksFromPlayer2) {
                if (model.isShipOnPlayer1(i[0] + 1, i[1]) && isAlreadyAttacked(i[0] + 1, i[1])) {
                    model.player2Attack( i[0] + 1, i[1]);
                    assertAttacksFromPlayer2.add(new int[]{(i[0] + 1), i[1]});
                    attackedBoxFromPlayer2.add(new int[]{(i[0] + 1), i[1]});
                    view.changeImageIconToAttackInPlayer1((i[0] + 1), i[1]);

                    return true;

                } else if (model.isShipOnPlayer1(i[0] - 1, i[1]) && isAlreadyAttacked(i[0] - 1, i[1])) {
                    model.player2Attack((i[0] - 1), i[1]);
                    assertAttacksFromPlayer2.add(new int[]{(i[0] - 1), i[1]});
                    attackedBoxFromPlayer2.add(new int[]{(i[0] - 1), i[1]});
                    view.changeImageIconToAttackInPlayer1((i[0] - 1), i[1]);

                    return true;

                } else if (model.isShipOnPlayer1(i[0], i[1] + 1) && isAlreadyAttacked(i[0], i[1] + 1)) {
                    model.player2Attack(i[0], (i[1] + 1));
                    assertAttacksFromPlayer2.add(new int[]{i[0], (i[1] + 1)});
                    attackedBoxFromPlayer2.add(new int[]{i[0], (i[1] + 1)});
                    view.changeImageIconToAttackInPlayer1(i[0], (i[1] + 1));

                    return true;

                } else if (model.isShipOnPlayer1(i[0], i[1] - 1) && isAlreadyAttacked(i[0], i[1] - 1)) {
                    model.player2Attack(i[0], (i[1] - 1));
                    assertAttacksFromPlayer2.add(new int[]{i[0], (i[1] - 1)});
                    attackedBoxFromPlayer2.add(new int[]{i[0], (i[1] - 1)});
                    view.changeImageIconToAttackInPlayer1(i[0], (i[1] - 1));

                    return true;

                }
            }


        }
        return false;
    }

    public void reLocateAttack(int x, int y){
        for (int[] i : attackedBoxFromPlayer2) {
            if (i[0] == x && i[1] == y) {
                machineIntelligenceAlgorithm();
            }

        }
    }

    private boolean isAlreadyAttacked(int x, int y){
        for (int[] i: assertAttacksFromPlayer2) {
            if(i[0] == x && i[1] == y){
                return true;
            }

        }

        return false;

    }

    @Override
    public void register() {
        model = new Game(view.register(false));

    }

    @Override
    public void player1Attack(int x, int y) {
        if(model.player1Attack(x, y)){
            view.changeImageIconToAttackInPlayer2(x, y);

        }else {
            view.changeButtonEnableInPlayer2(false, x, y);
        }

    }

    @Override
    public void player2Attack() {
        machineIntelligenceAlgorithm();

    }
}
