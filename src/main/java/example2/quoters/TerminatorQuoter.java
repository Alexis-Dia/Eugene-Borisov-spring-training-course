package example2.quoters;

/**
 * @author Alexey Druzik on 3/21/2020
 */
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat ; i++) {
            System.out.println("message = " + message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
