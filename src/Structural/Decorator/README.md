# Decorator Pattern

## Analogies

- Cold Weather
  
  Imaginme it's very cold outside and we come back and wear a jacket.
  We come insode and wear a jacvket
  we don't change as a person, but we've added another layer of functionality
  Like a wrapper.

- Ice Cream
  
  We start at the cone (bottom), we add a vanilla there. At the current stage is it an ince cream?
  Yes, although we don't have much but it still has cone and ince cream
  Now we add some black-current on top of it.
  We're not changing the cone, but rather we just added more flovors on top, without changing the existing functionality
  Now we add Strawberry on top (still the same cone).

Highly used in front-end applications.

Whenever we want to add some functionality (layer of jacket, layer of ice-cream), we add on top without changing the existing functionality.

- Database
  Now let's say we have a Db class, we have 2 Methods

  - Read()
    - We can get the data from Db
  - Write()
    - Write data to the Db

  Now the db table has a row with data. Read gives me that data, write changes that read data and stores it back to Db. But eventually we run out of space as the application took off, and I don't want to autoscale, what else can we do?

  - Probably **compress** it to make it smaller
  - If we ever get the data audited, they come with a list of items to follow. Like **encryption** is required. User shouldn't be able to look at the whole Db.

  We need 2 new fucntionalities, compress & encrypt.

  ```Java
  Database() {
    write() {
      encrypt();
      compress();
      write();
    }
  }
  ```

  Both SRP and OCP is violated here. Tomorrow if we need to do another thing with the data, we'll have to again modify the method.

  How do we structure this?

  We make use of the Decorator Pattern, it allows us to add functionality to our current system, without modifying the existing functionality.

  For Database, I'll create a Wrapper around it <br>
  ( Compress ( Encrypt ( Database ) ) )

  Database Class (base class)
  - EncryptedDatabase
  - CompressedDatabase
  - EncryptedAndCompressedDatabase

  This leads to class explosion.

## Questions

    A Db class currently has read and write methods. How do we create a wrapper around it? We might add a wrapper class around it, which implements the same methods, nut does it override the parent methods?

  No, the external layer will do it's work (like encrypt) and then call the parent method (like write).

  Example: ( Compress - write() { // does compression and calls super.write() } ( Encrypt - write() { // does encryption and calls super.write() } ( Database - write() ) ) )

  So the additional layers will just do it's worl and pass it to the parent class.

    What methods will the layer have?

  They'll have methods with the same signatures, and will inherit from the parent class.

## Implementation

Steps:

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
