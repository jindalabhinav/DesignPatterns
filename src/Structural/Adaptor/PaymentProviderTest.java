package Structural.Adaptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentProviderTest {
    PaymentProvider adapter = new RazorPayAdapter();
//    PaymentProvider adapter = new PayUAdapter();

    @Test
    public void testPayMethod() {
        adapter.createPayment(
                PaymentRequest.builder()
                        .id(1L)
                        .name("Tantia Tope")
                        .email("t@t")
                        .amount(100.0)
                .build());
    }

    @Test
    public void testStatus() {
        var status = adapter.verifyStatus(1L);
        assertEquals(status, PaymentStatus.DONE);
    }
}
