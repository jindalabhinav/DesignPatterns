package Structural.Adaptor;

public class RazorPayAdapter implements PaymentProvider {

    private RazorPayApi razorPayApi = new RazorPayApi();
    @Override
    public void createPayment(PaymentRequest paymentRequest) {
        razorPayApi.prePay(paymentRequest.getId(), paymentRequest.getName(), paymentRequest.getEmail(), paymentRequest.getAmount()); // RazorPay payment flow is different from others
        razorPayApi.pay(paymentRequest.getId(), paymentRequest.getName(), paymentRequest.getEmail(), paymentRequest.getAmount());
    }

    @Override
    public PaymentStatus verifyStatus(Long id) {
        var status = razorPayApi.checkStatus(id);
        return to(status);
    }

    private PaymentStatus to(RazorPayStatus status) {
        switch (status) {
            case OK: return PaymentStatus.DONE;
            case NOT_OK:return PaymentStatus.FAILED;
        }

        throw new IllegalArgumentException("Invalid Status: " + status);
    }
}
