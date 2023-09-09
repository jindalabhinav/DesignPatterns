package Prototype;

import org.junit.jupiter.api.Test;

import java.rmi.*;
import java.rmi.registry.Registry;

import static org.junit.jupiter.api.Assertions.*;

public class BackgroundObjectTest {

    @Test
    public void testClone() {
        // Step 3 - Create a prototype + copy it + modify it
        BackgrountObject prototype = new BackgrountObject(0.0, 0.0, 10.0, 20.0, BackgroundType.TREE);
        BackgrountObject clone = prototype.cloneObject();

        assertNotSame(prototype, clone, "If a clone us called, a new object will be created");
        assertEquals(prototype.getType(), clone.getType(), "if a clone is called, the same type will be returned");

        // Modify it
        clone.setX(10.0);
        clone.setY(10.0);
    }

    @Test
    public void testRegistry() {
        // Create a Registry
        BackgroundObjectRegistry registry = new BackgroundObjectRegistry();

        // Add a Prototype
        BackgrountObject prototype = new BackgrountObject(0.0, 0.0, 10.0, 20.0, BackgroundType.TREE);
        registry.addPrototype(prototype);

        // Fetch the Prototype
        BackgrountObject treePrototype = registry.getPrototype(BackgroundType.TREE);
        assertNotNull(treePrototype, "If prototype is stored, it shouldn't return null");

        BackgrountObject mountainPrototype = registry.getPrototype(BackgroundType.MOUNTAIN);
        assertNull(mountainPrototype, "If the prototype is not stored, it should return null");

        // Remove the Prototype
        registry.removePrototype(BackgroundType.TREE);
        BackgrountObject treePrototypeAfterRemoval = registry.getPrototype(BackgroundType.TREE);
        assertNull(treePrototypeAfterRemoval, "If the prototype is not stored, it should return null");
    }
}
