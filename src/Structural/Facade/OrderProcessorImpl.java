package Structural.Facade;

// This processor wraps all the complex logic that the OrderManager class was supposed to implement,
// and over there we can simply create an object of this class
// Now this facade can also be reused at multiple places
public class OrderProcessorImpl implements OrderProcessor {
    private InventoryService inventoryService = new InventoryService();
    private PaymentService paymentService = new PaymentService();
    private InvoiceService invoiceService = new InvoiceService();

    @Override
    public void process(Long orderId) {
        // Check for inventory
        if (!inventoryService.isPresent(orderId)) {
            throw new RuntimeException("Stock is not present");
        }

        // Payment Gateway
        paymentService.processPayment(orderId);

        // Create a bill
        invoiceService.processInvoice(orderId);

        // Send an email


        // this method can keep on getting bigger,
    }
}
