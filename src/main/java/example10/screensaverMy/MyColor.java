package example10.screensaverMy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.awt.*;
import java.util.Random;

/**
 * @author Alexey Druzik on 3/25/2020
 */
@org.springframework.stereotype.Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyColor extends Color {

    static Random random = new Random();

    public MyColor() {
        super(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
