package Prototype;

import java.util.HashMap;
import java.util.Map;

public class BackgroundObjectRegistry {

    private Map<BackgroundType, BackgrountObject> registry = new HashMap<>();

    public void addPrototype(BackgrountObject object) {
        registry.put(object.getType(), object);
    }
    public void removePrototype(BackgroundType type) {
        registry.remove(type);
    }
    public BackgrountObject getPrototype(BackgroundType type) {
        return registry.get(type);
    }
}
