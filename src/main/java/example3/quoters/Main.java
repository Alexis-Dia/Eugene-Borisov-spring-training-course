package example3.quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example3/context.xml");
        context.getBean(Quoter.class).sayQuote();
    }
}
