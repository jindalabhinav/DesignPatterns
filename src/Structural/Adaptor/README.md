# Adaptor Design Pattern

Very important in Backend Programming

## Analogy

**`Example 1: Incompatible chargers`**

`If you're travelling to a foreign country, and you carry with yourself an Indian Charger, does it work when you go to Europe? What do you do?`

You have 2 different interfaces:

- An Indian Charger
- European Plug

We introduce an Adapter in between that makes the 2 chargers compatible

- Integrates incompatible interfaces

---

**`Example 2 : Content Negotiation`**

`UserAPI -> returns JSON, but another client needs XML. Will we create a new API for that user?`

No, we introduce an Adapter in between. It takes the JSON input and outputs an XML. This process is actually called *Content Negotiation.* (an API accepts headers like *Accepts* - Content Negotiation Headers).

---

**`Example 3 : Payment Gateways`**

`Flipkart supports multiple Banks like HDFC/Axis/ICICI. Do they integrate with all these banks, in order to get money?`

No, there are newer banks opening every day. Some banks don't have anything automated sometimes, we then probably need to scrape their webpage. And this is where *Payment Gateways* come into picture.

> Flipkart --> Payment Gateways --> Integrates with different banks

`Does Flipkart integrate with only 1 Payment Gateway?`

No, multiple. For high-availability.

- Razorpay
- CashFree
- PayU

`What's the problem with integrating with multiple Payment Gateways?`

| RazorPay API           | PayU API                | CashFree API     |
| ---------------------- | ----------------------- | ---------------- |
| void pay(id, name, ..) | makePayment(id, amount) | makeOrder()      |
| checkStatus(id)        | getSAtatus(id)          | verifyStatus(id) |

Different request and response structures. Implementing them in the code:

```Java
makePayment() {
  if (RazorPay) {
    // Convert to RP
    // Call pay
    // Convert the Response
  }
  else if (PayU) {
    // same set of steps with a diff flavour
  }
  ...
}
```

This violates OCP, SRP, becomes huge classes with different providers, these fields aren't standardized.

## How to solve?

We can use Adaptor Patterns for all these scenarios.

## Implementation

`Steps:`

When we have Incompatible Interfaces (RazorPay, PayU, etc.), from SDKs perhaps:

1. Create your Adapter Interface (Flipkart methods, not specific for a specific Payment Gateway)
2. Create your Concrete Adapters (specific for Payment Gateways - RazorPay/PayU/etc.). This concrete implementation makes the call to the Payment Gateway respective APIs.
