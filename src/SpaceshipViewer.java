import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SpaceshipViewer {
    public static SpaceshipMoverer spaceShip = new SpaceshipMoverer();
    public static int moveKeyPressed = 0;
    public static void main(String[] args) {


        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        frame.add(spaceShip.spaceShip);
        class KeyboardPressListener implements KeyListener {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                String key = KeyStroke.getKeyStrokeForEvent(e).toString();
                if (key.equalsIgnoreCase("pressed UP")){
                    moveKeyPressed = 2;
                } else if (key.equalsIgnoreCase("pressed DOWN")) {
                    moveKeyPressed = 1;
                } else if (key.equalsIgnoreCase("pressed RIGHT")) {
                    moveKeyPressed = 3;
                } else if (key.equalsIgnoreCase("pressed LEFT")) {
                    moveKeyPressed = 4;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                    moveKeyPressed = 0;
            }
        }
        class MoveTimerListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                spaceShip.move();
                switch (moveKeyPressed){
                    case 1:
                        spaceShip.acceleratePosY();
                        break;
                    case 2:
                        spaceShip.accelerateNegY();
                        break;
                    case 3:
                        spaceShip.acceleratePosX();
                        break;
                    case 4:
                        spaceShip.accelerateNegX();
                        break;
                    default:
                        spaceShip.decelerate();
                }
            }
        }



        KeyboardPressListener listener = new KeyboardPressListener();
        MoveTimerListener moveTimeListener = new MoveTimerListener();
        Timer moveTimer = new Timer(50, moveTimeListener);

        spaceShip.spaceShip.addKeyListener(listener);
        spaceShip.spaceShip.setFocusable(true);
        spaceShip.spaceShip.requestFocus();
        frame.setVisible(true);


        moveTimer.start();

    }


}
