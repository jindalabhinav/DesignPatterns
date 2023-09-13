package Structural.Adaptor;


public class PayUAdapter implements PaymentProvider {
    private PayUApi payUApi = new PayUApi();
    @Override
    public void createPayment(PaymentRequest paymentRequest) {
        payUApi.makePayment(paymentRequest.getId(), paymentRequest.getAmount());
    }

    @Override
    public PaymentStatus verifyStatus(Long id) {
        var status = payUApi.getStatus(id);
        return to(status);
    }

    private PaymentStatus to(PayUStatus status) {
        switch (status) {
            case SUCCESS: return PaymentStatus.DONE;
            case FAILURE: return PaymentStatus.FAILED;
        }

        throw new IllegalArgumentException("Invalid Status: " + status);
    }
}
