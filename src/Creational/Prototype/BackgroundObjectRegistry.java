package Creational.Prototype;

import java.util.HashMap;
import java.util.Map;

public class BackgroundObjectRegistry {

    private Map<BackgroundType, BackgroundObject> registry = new HashMap<>();

    public void addPrototype(BackgroundObject object) {
        registry.put(object.getType(), object);
    }
    public void removePrototype(BackgroundType type) {
        registry.remove(type);
    }
    public BackgroundObject getPrototype(BackgroundType type) {
        return registry.get(type);
    }
}
