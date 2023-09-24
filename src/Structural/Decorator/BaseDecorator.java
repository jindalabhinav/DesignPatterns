package Structural.Decorator;

import lombok.AllArgsConstructor;

// Step 3 - Create Base decorator

// All decorators need to have the same contract and hence we implement the Product Interface
// Why abstract? We need a reference, if we have an encrypted Db, it needs to call encrypt and then the next layer/level. To store the reference of that, we create a variable
@AllArgsConstructor
public abstract class BaseDecorator implements Database {
    protected Database nextLayer;
}
