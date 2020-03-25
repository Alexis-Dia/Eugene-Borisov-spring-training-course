package example10.screensaverMy;

import org.springframework.context.annotation.Scope;

import java.awt.*;

/**
 * @author Alexey Druzik on 3/25/2020
 */
@org.springframework.stereotype.Component
@Scope(value = "prototype")
public class MyColor extends Color {

    public MyColor() {
        super(1, 100, 1);
    }

    public MyColor(int a, int b, int c) {
        super(1, 100, 1);
    }
}
