# Prototype and Registry Pattern

## Analogies

Assignment Given in College
One Assignment --> Chatur completes it (heavy-lifting) --> Others Copy and Modify it

Publishing Research Papers -->
One persion creates a research paper  (heavy-lifting) -->
Others Copy and Modify a little bit

## Motivation

Particularly useful in the Game Industry

In a PUBG game, we have a big Map which contains multiple copies of the same object, for instance Trees
Creating thousands of similar trees is neither feasible nor efficient. The shape is same but not the location/size.

Hence what we can do is, create an original tree, copy it, and modify the location.

The prototype pattern comes in handy when it's hard to create an object and has an overhead like:

- resource intensive
- might need lot of memory
- CPU
- need to wait bcz of a network call
  
*Prototype pattern is used when we want to create mutiple copies of the same object and where creating 1 object is costly.*

Let's say we want to create a Random User, and to create a Random User, we have to make a call to the RandomAPI and wait for it to complete.
Creating multiple users from the same RandomAPI would be costly (need to wait for the network calls). Let's see how Prototype pattern can help us.

1. We'll create a User from the RandomAPI and make it the prototype
2. Copy it (this saves us another network call) a million times, we don't care (in this case the new object creation was expensive because of the network call)
3. Modify just the required fields like the name, email, etc.
4. And this is called the **Prototype Pattern**

## Implementation

When we talk about game development, it has 2 kinds of objects

- ForeGround Objects - Players, Enemies, etc.
- Background Objects - Trees, Houses, Hills, etc. (replicable)

**Steps Involved**

***Creating a Prototype***

   ```
   class BackgroundObject {
        ...
   }
   ```
1. Create a Cloneable Interface
   ```
   // this is a functional interface (contains only 1 method)
   interface Cloneable {
      BG clone();
   }
   ```
2. Implement this Interface
   ```
   class BackgroundObject implements Cloneable {
      // class attributes

      BG clone() {
        // returns a cloned object
      }
   }
   ```
    *What's Cloning?*
    It simply means copying an object
    
    - Shallow Cloning (when we clone an object but we don't clone the nested/user-defined fields inside, i.e., non-primitive type objects in a class)
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
    
3. Create a Prototype, Clone it, and Modify it as needed

## Registry

Now that we have a prototype, we also need a place to store it and fetch it when we want. Also, associating the prototypes in the registry with a type will allow us to get them easily on-demand.

A good datastructure for the same would be a Map<Type, BackgroundObject>, and registry is essentially a wrapper around this Map.

```
// Place to store objects
class Registry {
  Map<Type, BackgroundObject> map;

  // add()
  // get()
  // remove()
}
```
This is not exactly an extensive design pattern, but rather just a simple class which is not just useful in Prototype Pattern, but in other scenarios as well like the Flyweight Pattern, Observer Pattern, Commmand Pattern, etc.
