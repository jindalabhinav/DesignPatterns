# Prototype and Registry Pattern

## Analogies

### Assignment Given in College

- Publishing Research Papers
- One person creates a research paper  (heavy-lifting)
- Others Copy and Modify a little bit

## Motivation

The Prototype Pattern is particularly useful in the Game Industry.

In a game like PUBG, where there are multiple copies of the same object (e.g., trees) in a big map, creating thousands of similar objects is neither feasible nor efficient. The prototype pattern allows us to create an original object, copy it, and modify the copies as needed.

This pattern is beneficial when creating an object is resource-intensive, requires a lot of memory, CPU, or involves waiting due to network calls. It's used when we want to create multiple copies of the same object and creating one object is costly.

### Example Scenario

Let's consider creating random users using a RandomAPI that involves network calls. Creating multiple users from the same RandomAPI would be costly, as it requires waiting for network calls. The Prototype Pattern comes to our rescue:

1. Create a User from the RandomAPI and make it the prototype.
2. Copy it a million times, saving network calls.
3. Modify just the required fields like name, email, etc.

## Implementation

In game development, there are two kinds of objects:

- Foreground Objects: Players, Enemies, etc.
- Background Objects: Trees, Houses, Hills, etc. (replicable)

### Steps Involved

#### Creating a Prototype

   ```Java
   class BackgroundObject {
      // class attributes
   }
   ```

1. Create a Cloneable Interface

   ```Java
   // this is a functional interface (contains only 1 method)
   interface Cloneable {
      BackgroundObject clone();
   }
   ```

2. Implement this Interface

   ```Java
   class BackgroundObject implements Cloneable {
      // class attributes

      BackgroundObject clone() {
        // returns a cloned object
      }
   }
   ```

3. Create a Prototype, Clone it, and Modify it as needed

#### *What's Cloning?*

It simply means copying an object

- Shallow Cloning (when we clone an object, but we don't clone the nested/user-defined fields inside, i.e., non-primitive type objects in a class)
  - Disadvantages
    - Changing the value of 1 such field will change it across all clones, since the same instance is shared
    - Inconsistencies
  - Advantages
    - Faster (Copies only the root level objects)
    - Space Efficient
- Deep Cloning (it copies recursively)
  - Disadvantages
    - Slower
    - Occupies more memory
  - Advantages
    - Even if let's say A  depends on B and B depends on C, we copy it till the last level
    - Always consistent

## Registry

Now that we have a prototype, we need a place to store it and fetch it when needed. The Registry is essentially a wrapper around a `Map<Type, BackgroundObject>`.

A good data structure for the same would be a Map<Type, BackgroundObject>, and registry is essentially a wrapper around this Map.

```Java
// Place to store objects
class Registry {
  Map<Type, BackgroundObject> map;

  // add()
  // get()
  // remove()
}
```

This is not exactly an extensive design pattern, but rather just a simple class which is not just useful in Prototype Pattern, but in other scenarios as well like the Flyweight Pattern, Observer Pattern, Commmand Pattern, etc.
