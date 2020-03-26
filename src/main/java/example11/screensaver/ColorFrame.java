package example11.screensaver;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Alexey Druzik on 3/25/2020
 */
@org.springframework.stereotype.Component
//@Service - the same
public abstract class ColorFrame extends JFrame {

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(700));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor();
}
