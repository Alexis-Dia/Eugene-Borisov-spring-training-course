package example10.screensaverMy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.util.Random;

/**
 * @author Alexey Druzik on 3/25/2020
 */
@Configuration
@ComponentScan(basePackages = "example10.screensaverMy")
public class Config {

    @Bean
    public ColorFrame frame() {
        Random random = new Random();
        ColorFrame colorFrame = new ColorFrame();
        colorFrame.setSize(200, 200);
        colorFrame.setVisible(true);
        colorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return colorFrame;
    }


    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            ColorFrame bean = context.getBean(ColorFrame.class);
            MyColor myColorBean = context.getBean(MyColor.class);
            bean.getContentPane().setBackground(myColorBean);

            Random random = new Random();
            bean.setLocation(random.nextInt(1200), random.nextInt(700));
            bean.repaint();

            Thread.sleep(100);
        }
    }
}
