package Behavioural.Observer;

import lombok.AllArgsConstructor;

// Step 2 - Extend the publisher class
@AllArgsConstructor
public class BitcoinManager extends Publisher {
    private Bitcoin bitcoin;

    // Event driven instead of Polling, notification sent for trigger price hit
    // An external entity would be setting the price of Bitcoincan  
    public void setPrice(Double price) {
        if (bitcoin.getPrice() - price > 5) {
            publish(price); // OR super.publish(price);
        }
        bitcoin.setPrice(price);
    }
}
