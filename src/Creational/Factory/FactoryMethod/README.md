# Factory Method Pattern

## Implementation

The change here would be that we'll have different factories for different kinds of object, and have 1 Parent Factory Interface

Steps:

First 2 steps remain the same as Simple Factory. i.e., to create the product hierarchy

1. Create Product Interface (Button)
2. Create Product Concrete Classes (RoundButton, SquareButton)
3. Create Factory Interface

    ```Java
    interface ButtonFactory {
      Button createButton(); // high level module depends on high level module
    }
    ```

4. Create concrete factories

    ```Java
    class RoundButtonFactory implements ButtonFactory {
      createButton() {
        return new RoundButton();
      }
    }
    ```

An issue with this pattern is that we have a **Class Explosion**. We create classes for Product Hierarchy, and the Factory Hierarchy. (Double the number of classes)
