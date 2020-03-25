package example10.screensaver;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * @author Alexey Druzik on 3/25/2020
 */
@Configuration
@ComponentScan(basePackages = "example10.screensaver")
public class Config {
    @Bean
    @Scope(value = "prototype")
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public ColorFrame frame() {
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                //это не вызов метода color, это обращение к бину, котоый color.
                return color();
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(100);
        }
    }
}
