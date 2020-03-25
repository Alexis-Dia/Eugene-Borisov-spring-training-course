package example9.screensaver;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Alexey Druzik on 3/25/2020
 */
@org.springframework.stereotype.Component
//@Service - the same
public class ColorFrame extends JFrame {
    @Autowired
    private Color color;

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1200), random.nextInt(700));
        getContentPane().setBackground(color);
        repaint();
    }
}
