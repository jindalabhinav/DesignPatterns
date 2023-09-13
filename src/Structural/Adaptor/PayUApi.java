package Structural.Adaptor;

// SDK
// Step 0 - Incompatible interfaces
public class PayUApi {
    public void makePayment(Long id, Double amount) {
        System.out.println("RazorPay Payment");
    }

    public PayUStatus getStatus(Long id) {
        return PayUStatus.SUCCESS;
    }
}
