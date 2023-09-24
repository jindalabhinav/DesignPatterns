# Factory Pattern

## Motivation

**Britania Factory**

We can have different products coming out of a Factory

- Parle G
- Rusks
- Sunfeast
- Goodday

These products are created with an input, like Sugar, Wheat, and Milk.

## Coming back to Factory Pattern

On the front-end, factory pattern is extremely popular. Let's say we're building a Website. We'll have Buttons, Labels, Input-boxes, etc. We can also have a light-theme and a dark-theme for these objects.

In a responsive website, these objects styling might be different for a Desktop, a Mobile, and a Tablet. How do we create these different type of objects?

```Java
  render() {
    var screenSize = getSize();
    if (desktop)
      RoundButton();
    else if (ipad)
      RectButton();
    else
      AnimatedButton();
  }
  // if-else ladder
```

### Problems

1. Violating SRP, OCP (new if else statements have to be added for new types of screens, and we need to modify this code)
2. Whenever I need to create a button, I need this code everywhere, on different screens as well
3. Non-reusable complex construction

> I should not depend on implementation classes

Whenever we try to create an object, we need to reduce the usage of a subclass. We'll probably be using a 3rd party library which returns us the Btn let's say. If we're making use of the implementation methods of that library, any changed in those library methods, might create issues in your code.

The source cause of this problem is that we're making use of the implementation class (concrete classes). That's why in Java we say code to the interface, to introduce loose coupling. 

Example: in JDBC,

```Database db = jdbc.getConnection(connString);```

```Database db = new MySQL(); //Why don't we use this?```

Tomorrow if we change the database from MySQL to Postgres, we need to change this code everywhere, and we've introduced multiple issues with Subclasses.

- tight-coupling
- maintainability (any change needs to implemented everywhere)
- backward-compatibility (if the method names are changed)

### What to do?

Whenever we want to

- create multiple types of objects
- on the bases of a parameter

We use the *Factory Pattern*.