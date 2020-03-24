package example6.quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example6/context.xml");
        //context.getBean(Quoter.class).sayQuote();
    }
}
