package Behavioural.Observer;

public class SMSConsumer implements Consumer {
    @Override
    public void consume(Double price) {
        System.out.println("Sending SMS for price: " + price);
    }
}
