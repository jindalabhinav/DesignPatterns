# Decorator Pattern

## Analogies

- Cold Weather
  
  - Imagine it's very cold outside and we come back and wear a jacket.
  - Even though we've worn a jacket, we don't change as a person, we've just added another layer of functionality.
  - Like a wrapper.

- Ice Cream
  
  - We start at the bottom of the cone, and we add some vanilla there. At its current state, is it an ice cream?
  - Yes, although we don't have much, but it still has cone and ice-cream.
  - Now we add some black-current on top of it.
  - We're not changing the cone, but rather just adding more flavors on top, without changing the existing functionality.
  - Now we add Strawberry on top (still the same cone).

## Motivation

`Highly used in front-end applications.`

Whenever we want to add some functionality to something (layer of jacket, layer of ice-cream), we add on top, without changing the existing functionality.

`Database`

Now let's say we have a Db class, having 2 methods:

- Read()
  - We can get the data from Db
- Write()
  - Write data to the Db

Database tables have rows with data. `Read()` gives us that data, and `Write()` changes that read data and stores it back to Db. But eventually we run out of space as the application took off, and we don't want to auto-scale yet, what else can we do?

- Probably `compress` it to make it smaller
- Let's say we get the data audited, they come with a list of items to follow. Like `encryption` is required. User shouldn't be able to look at the whole Db.

Now we need 2 new functionalities, compress & encrypt.

```Java
Database() {
  write() {
    encrypt();
    compress();
    write();
  }
}
```

Both SRP and OCP is being violated here. Tomorrow if we need to do another thing with the data, we'll have to again modify the method.

`How do we structure this?`

We make use of the `Decorator Pattern`, it allows us to add functionality to our current system, without modifying the existing functionality.

For Database, we'll create a `Wrapper` around it <br>
`( Compress ( Encrypt ( Database ) ) )`

But when we need different enhancements to the Database Class (base class), we'll need different wrappers:

- EncryptedDatabase
- CompressedDatabase
- EncryptedAndCompressedDatabase

This leads to class explosion.

## Questions

`A Db class currently has read and write methods. How do we create a wrapper around it? We might add a wrapper which implements the same methods, but does it override the parent methods?`

No, the external layer will do it's work (like encrypt) and then call the parent method (like write).

Example:

`(
  Compress - write() { // does compression and calls super.write() } (
    Encrypt - write() { // does encryption and calls super.write() } (
      Database - write() // actual write to Db
    )
  )
)`

So the additional layers will just do it's worl and pass it to the parent class.

`What methods will the layer have?`

They'll have methods with the same signatures, and will inherit from the parent class.

## Implementation

`Steps:`

1. Product interface
   
   ```Java
   interface Database {
      read();
      write();
   }
   ```

2. Concrete Product Class
   
   ```Java
   class MySQL implements Database {
      // implements the methods
   }
   ```

3. Base Decorator (going to be an abstract class for all the decorator concrete classes)
   
   ```Java
   abstract class BaseDecorator implements Database {
      Database nextLayer;

      abstract read();
      abstract write();
   }
   ```

   When we call the compression decorator, it has to call the next layer. Instead of using Inheritence, Composition is what we'll use to call the next layer.

4. Concrete Decorators (extending the BaseDecorator to get the nextLayer and the methods to be implemented)
   
   ```Java
   public class ConcreteDecorator extends BaseDecorator {
      public ConcreteDecorator(Database nextLayer) {
          super(nextLayer);
      }
      
      @Override
      read(); // call the next layer, and do its job
      @Override
      write(); // do its job and call the next layer
   }
   ```

   All Decorators will extend the abstract Decorator class

Checkout the actual implementation for better understanding.