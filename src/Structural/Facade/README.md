# Facade Pattern

## Analogies

Let's say we're creating an order on Flipkart. It might sound pretty simple but there's a lot of stuff happening behind the scenes

```Java
class OrderManagement {
  void checkout() {
    checkInventory();
    processPayment(); // from payment gateway
    createBill();
    updateInventory();
    scheduleDelivery();
    sendNotificationToUser();
  }
}
```

Such a simple task consists of a lot of such steps. All these methods wherever we implement them might be in different class.

- Inventory Service
- Payment Service

OrderManagement will have to depend on all such classes, and it's becoming a monster method. Violates SRP & OCP.

```Java
class OrderManagement {
  PaymentService paymentService;

  void checkout() {
    paymentService.pay();
    ...
  }
}
```

It's not:

- Reusable
  - To make use of it again, we'll have to copy all this code again at another place.
- Testable
  - these dependencies might have dependencies of its own and we'll have to build all of that

**Solution**

*Facade Patten* - Hide the complicated implementation behind an interface.

```Java
interface OrderProcessor { // this is the Facade
  process();
}

class OrderProcessorConcrete implements OrderProcessor {
  process();
}

class OrderManagement {
  OrderProcessor processor;

  void checkout() {
    processor.process(); // this does all the complex things
  }
}
```

The only thing we've done is we've moved it t o a different place, it still hasn't solved SRP or OCP.