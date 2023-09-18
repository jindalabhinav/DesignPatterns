package Structural.Facade;

import java.util.Objects;

// This is the class which the Frontend is communicating with
public class OrderManagerImpl implements OrderManager {
    private OrderProcessor orderProcessor = new OrderProcessorImpl();

    @Override
    public void checkout(Long orderId, String source) {
        if (Objects.equals(source, "Flipkart")) {
            // process sales discounts
        }
        orderProcessor.process(orderId);
    }
}
