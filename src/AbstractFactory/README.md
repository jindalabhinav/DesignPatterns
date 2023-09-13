# Abstract Factory Pattern

An extension of factory pattern

Let's talk about a family of UI Components
              DARK          LIGHT
Btn           Dark Btn
Radio         Dark Radio
Select

MySQL
    MySQL Db  Mongo
Db

- It allows us to create a family of products
- Product of 1 family cannot be created along with another family
- More useful on the front-end comapred to back-end

## Implementation

### Step 1 : Common Product Interface

  BUTTON    RADIO

### Step 2 : Concrete Product Classes

  Button
  - Dark Button
  - Light Button

  Radio
  - Dark Radio
  - Light Radio

### Step 3 : Factory Interface (Factory of Factories)

  ```
  interface ComponentFactory {
    Btn createButton(); // returns a button
    Radio createRadio();
  }
  // Allows us to create multiple products
  ```

### Step 4 : Concrete Factories

  - Dark Theme Factory
  - Light Theme Factory

So now th Button Interface will have 2 concrete factory

Theme Factory (better word for ComponentFactory)
- Dark Theme Factory
  - createButton() --> Dark Button returned
- Light Theme Factory
  - - createButton() --> Light Button returned


If tomorrow we need a SuperDarkTheme, we just need to add some classes
