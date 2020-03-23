package example1.quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example1/context.xml");
        context.getBean(Quoter.class).sayQuote();
    }
}
