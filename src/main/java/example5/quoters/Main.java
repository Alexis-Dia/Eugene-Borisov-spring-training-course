package example5.quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example5/context.xml");
        //context.getBean(Quoter.class).sayQuote();
    }
}
