package Behavioural.Observer;

// Step 4 - Concrete Consumer
public class EmailConsumer implements Consumer {
    @Override
    public void consume(Double price) {
        System.out.println("Sending email for price: " + price);
    }
}
