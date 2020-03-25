package example10.screensaverMy;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

/**
 * @author Alexey Druzik on 3/25/2020
 */
//@org.springframework.stereotype.Component
//@Service - the same
public class ColorFrame extends JFrame {
    @Autowired
    MyColor myColor;

    //@Autowired
/*    public ColorFrame(MyColor myColor) {
        Random random = new Random();
        this.myColor = myColor;
    }*/

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //getContentPane().setBackground(myColor);
    }

}
