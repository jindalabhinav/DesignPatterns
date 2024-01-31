package Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

// Step 1 - Create an interface for publisher + registry
// This needs to be an abstract class instead of a normal one because we don't want to create an object of this class
// and have an implementation of publish be available for child classes, to publish based on their own logic/trigger
public abstract class Publisher {

    private List<Consumer> consumers = new ArrayList<>();

    public void publish(Double price) {
        consumers.forEach(consumer -> consumer.consume(price));
    }

    public void addConsumer(Consumer consumer) {
        consumers.add(consumer);
    }

    public void removeConsumer(Consumer consumer) {
        consumers.remove(consumer);
    }
}
