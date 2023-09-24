# Abstract Factory Pattern

## Motivation

### Family of Products

#### Diwali Package

| Chocolate  | Vanilla  | Bhujia   |
| ---------- | -------- | -------- |
| Oreo       | Icecream | Aloo     |
| Dairy Milk | Milkybar | Bikaneri |
| Snickers   | Sunfeast | Sev      |

Let's say Diwali is around the corner, and we want to build a package to give to a friend, we'll most probably be building a package of similar products (my friends would be furious if I add a Bhujia to a Chocolate Package :P).

#### Dark/Light Themed Front-end Objects

| Dark          | Light          |
| ------------- | -------------- |
| Dark Button   | Light Button   |
| Dark Checkbox | Light Checkbox |
| Dark Dropdown | Light Dropdown |

#### Different Databases

| MySQL        | Mongo        |
| ------------ | ------------ |
| MySQL Db     | Mongo Db     |
| MySQL Driver | Mongo Driver |

Basically have a family of Products

- All Products should be of the same family. (I won't have a MySQL Db with a Mongo Driver)

## Implementation

Steps:

1. Common Product Interfaces

   - Button
   - Radio

2. Concrete Product Classes

    Button (interface)

      - Dark Button
      - Light Button

    Radio (interface)

      - Dark Radio
      - Light Radio

3. Factory Interface (Factory of Factories)

    ```Java
    interface ThemeFactory {
      Btn createButton();
      Radio createRadio();
    }
    // Allows us to create multiple products
    ```

4. Concrete Factories

    ThemeFactory (interface)

      - Dark Theme Factory (for creating a Dark Button/Radio)
      - Light Theme Factory (for creating a Light Button/Radio)

If tomorrow we need a SuperDarkTheme, we just need to add some classes.

The issue of Class Explosion still persists.
