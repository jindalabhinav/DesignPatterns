package Behavioural.Observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BitcoinTest {
    private BitcoinManager bitcoinManager;

    // Setup Method -> Create the dependencies
    @BeforeEach
    public void setUp() {
        Bitcoin bitcoin = new Bitcoin(100.0);
        bitcoinManager = new BitcoinManager(bitcoin);
        // This way we're setting the consumers for Bitcoin Price Triggers
        bitcoinManager.addConsumer(new EmailConsumer());
        bitcoinManager.addConsumer(new SMSConsumer());
    }

    // Teardown Method -> Destroy the dependencies


    @Test
    public void updatePrice() {
        bitcoinManager.setPrice(90.0);
        // this should trigger an email
    }
}
