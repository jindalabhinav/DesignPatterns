# Adaptor Design Pattern

Very important in Backend Programming

## Analogy

If you're travelling to a foreign country and you carry with yourself an Indian Charger, does it work when you go to Europe? What do you do?

How does Adaptoir Pattern work?
you have 2 diff interaces:

- An Indian Charger
- European Plug

We introduce an Adapter in beterrn which make the 2 compatible

- Integrates incompatible interfaces

Example 2 :
UserAPI -> returns JSON

But another client needs XML

Will we create a new API for that user?

No, we intruduce an Adapter in between. It takes the JSON input and outputs an XML. This process is actually called *Content Negotiation.* (an API accepts headers like *Accepts* - Content Negotiation Headers).

## Payment Gateways

**Examples:**

**Flipkart supports multiple Banks like HDFC/Axis/ICICI. Do they integrate will all these banks, in order to get money?**

---

No, there are newer banks opening everyday. Some banks don't have anything automated sometimes, we then probably need to scrape their webpage. And this is where *Payment Gateways* come into picture.

Flipkart --> Payment Gateways --> Integrates with different banks

**Does Flipkart integrate with only 1 Payment Gateway?**

---

No, multiple. For high-availability.

- Razorpay
- CashFree
- PayU

**What's the problem with integrating with multiple Payment Gateways?**

---

| RazorPay API           | PayU API                | CashFree API     |
| ---------------------- | ----------------------- | ---------------- |
| void pay(id, name, ..) | makePayment(id, amount) | makeOrder()      |
| checkStatus(id)        | getSAtatus(id)          | verifyStatus(id) |

Different request and response structures. Implementing them in the code 

```Java
makePayment() {
  if (RP) {
    1. Convert to RP
    2. Call pay
    3. Convert the Response
  }
  else if (PU) {
    // same set of steps with diff flavour
  }

}
```

This violates OCP, SRP, becomes huge classes with different providers, these fields aren't standardized. 

---

**How to solve?**

Steps

0. Incompatible Interfaces (RazorPay, PayU, etc.)
1. Create your Adapter Interface (Flipkart methods, not specific for a specific Payment Gateway)
2. Create your Concrete Adapters (specific for Payment Gateways - RazorPay/PayU/etc.). This concrete implementation makes the call to the Payment Gateway respective APIs.
