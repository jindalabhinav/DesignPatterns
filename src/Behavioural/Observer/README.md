# Observer Pattern

## Analogies

### Buying an iPhone

Approach #1

Let's say you have a house and near you is an Apple store.  Let's say everyday at the start of the day you go and ask them if you have the new iPhone, he says no and you come back, and you repeat that everyday.

With this everyday you're basically wasting your effort (or CPU cycles).

Approach #2

You go to the Apple store and you give them youre email id and they'll send everyone an email once it arrives

Approach #3

I want the iPhone. Then they'll maintain a list of people who're interested. Now they'll only senf an email to the interested people. Which is the best thing possible for you

### Bitcoin

So far it was a bearish season and we've not entered a Bullish season.

We wait for the price to drop to buy the bitcoin

```Java
public BitcoinManager {
  Bitcoin btc;

  setPrice(price) {
    if (btc.price - price > 5) {
      sendEmail();
      // Now I also want to get a slack
      sendSlack(); // this has violated OCP
    }
  }
}
```

Whenever this price is hit, you want to recieve an email.

Previous price - current > (some delta)

## Solution

### Long Polling

```Java
public BitcoinManager {
  Bitcoin btc;

  setPrice(price) {
    btc.setPrice = price;
  }
}

// Runs on a set frequency
public BitcoinTracker {
  Bitcoin btc;

  setPrice(currPrice) {
    if (btc.price - currPrice > 5) {
      sendEmail();
      sendSlack(); // still violates OCP
    }
  }
}
```

But this process is CPU intensive, so we set a polling duration, but waht sort of polling duration to set? 1 day? 1 hour? 1 min?

We don't want our application to waste cycles

### Ideal solution

1. Notify if there's a change
2. Solve Tight coupling (solves the OCP problem)

This is where the Observer comes in.

## Implementation

Publisher (observable/subject) <-> Consumer (observer/subscriber/object)

BTCManager is the Publisher, it will notify a Consumer Interface (Email Service, Slack Service, these are concrete implemetations of the Consumer Interface).

Steps:

1. Publisher Interface (responsible to inform the consumer that there has been a change)
   
   ```Java
   interface Publisher {
      publish();
   }
   ```

2. Concrete Publisher
   
   ```Java
   class BTCManager implements Publisher {
      publish();
   }
   ```

3. Consumer Interface
   
   ```Java
   interface Consumer {
      consume();
   }
   ```

4. Concrete Consumers
   
   ```Java
   class EmailConsume implements Consumer {
      consume() {
        // sendEmail;
      }
   }

   class SMSConsume implements Consumer {
      consume() {
        // sendSMS;
      }
   }
   ```

Now there might be other coins where we want to only send an Email. How do we solve that?

We maintain a registry of consumers, the publish/notify method notifies all of the applicable Consumers.

**This makes this event-driven architecture instead of a polling architecture.**

Real world Example: There could be a lot of things happening when a user clicks on "Sign In"

- Google Analytics
- Notification
- Amplitude

These 3 things would go to publish method and have consumer do the job. Trigger would be a click.
