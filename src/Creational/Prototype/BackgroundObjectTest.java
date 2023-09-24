package Creational.Prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BackgroundObjectTest {

    @Test
    public void testClone() {
        // Step 3 - Create a prototype + copy it + modify it
        BackgroundObject prototype = new BackgroundObject(0.0, 0.0, 10.0, 20.0, BackgroundType.TREE);
        BackgroundObject clone = prototype.cloneObject();

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
        BackgroundObject prototype = new BackgroundObject(0.0, 0.0, 10.0, 20.0, BackgroundType.TREE);
        registry.addPrototype(prototype);

        // Fetch the Prototype
        BackgroundObject treePrototype = registry.getPrototype(BackgroundType.TREE);
        assertNotNull(treePrototype, "If prototype is stored, it shouldn't return null");

        BackgroundObject mountainPrototype = registry.getPrototype(BackgroundType.MOUNTAIN);
        assertNull(mountainPrototype, "If the prototype is not stored, it should return null");

        // Remove the Prototype
        registry.removePrototype(BackgroundType.TREE);
        BackgroundObject treePrototypeAfterRemoval = registry.getPrototype(BackgroundType.TREE);
        assertNull(treePrototypeAfterRemoval, "If the prototype is not stored, it should return null");
    }
}
