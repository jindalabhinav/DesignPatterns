package Structural.Adaptor;

// Step 1 - Adapter Interface
public interface PaymentProvider {
    // This should be a combination of both
    void createPayment(PaymentRequest paymentRequest);
    PaymentStatus verifyStatus(Long id);
}
