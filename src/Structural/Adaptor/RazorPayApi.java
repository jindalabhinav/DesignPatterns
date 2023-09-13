package Structural.Adaptor;

// SDK
// Step 0 - Incompatible interfaces
public class RazorPayApi {

    public void prePay (Long id, String name, String email, Double amount) {
        System.out.println("RazorPay Pre-Payment");
    }

    public void pay (Long id, String name, String email, Double amount) {
        System.out.println("RazorPay Payment");
    }

    public RazorPayStatus checkStatus(Long id) {
        return RazorPayStatus.OK;
    }
}
