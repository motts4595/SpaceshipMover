import javax.swing.*;
import java.awt.*;

public class RectangleComponent extends JComponent {

    private static final int X = 500;
    private static final int Y = 500;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 35;

    private Rectangle box;

    public RectangleComponent(int WIDTH, int HEIGHT){
        box = new Rectangle(X, 0, WIDTH, HEIGHT);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(box);
    }

    public void move(int dx, int dy){
        box.translate(dx, dy);
        repaint();
    }

    public int getPositionX(){
        Point location = box.getLocation();
        return location.x;
    }

    public int getPositionY(){
        Point location = box.getLocation();
        return location.y;
    }

    public void moveTo(int x, int y){
        box.setLocation(x, y);
        repaint();
    }

}
