package example4.quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example4/context.xml");
        //During this time you have set true flag in jvisualvm.exe
        Thread.sleep(10000);
        context.getBean(Quoter.class).sayQuote();
    }
}
