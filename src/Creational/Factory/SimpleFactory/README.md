# Simple Factory Pattern

## Implementation

Steps:

1. Create Product Interface (Button)
2. Create Product Concrete Classes (RoundButton, SquareButton)
3. Create a Factory class with a method for construction logic

  ```Java
      class BtnFactory {
        static Button createBtn(Type) {
          // if-else logic to get desired object instance
        }
      }
  ```

4. Implement object construction (we can copy our if-else logic here)

This is just a quick implementation and not really a Design Pattern, it's still not maintainable.
