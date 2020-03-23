package example2.quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example2/context.xml");
        context.getBean(Quoter.class).sayQuote();
    }
}
