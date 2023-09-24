package Creational.Prototype;

// Step 1 - Create a Cloneable Interface
@FunctionalInterface // This will not allow us to add another method to this Interface
public interface GraphicalObject {
    GraphicalObject cloneObject();
}
