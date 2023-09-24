package Creational.Prototype;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Step 2 - Implement the cloneable Interface
@NoArgsConstructor
@Setter
@Getter
public class BackgroundObject implements GraphicalObject {

    private Double x;
    private Double y;
    private Double width;
    private Double height;
    private BackgroundType type;

    @Setter(AccessLevel.NONE) // Do not create a setter, this is derived
    private List<Double> pixels = new ArrayList<>();

    public BackgroundObject(Double x, Double y, Double width, Double height, BackgroundType type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
        // we don't want to pass the pixels to be created from the constructor, rather based on the values of the other properties, we want to create it
        this.pixels = generatePixels();
    }

    // Copy constructor (Shallow)
    private BackgroundObject(BackgroundObject ref) {
        this.x = ref.x;
        this.y = ref.y;
        this.width = ref.width;
        this.height = ref.height;
        this.type = ref.type;
        this.pixels = ref.pixels;
    }

    // The time taking piece
    private List<Double> generatePixels() {
        return Collections.emptyList();
    }

    @Override
    // Creating pixels everytime will be expensive, and we'll use the prototype pattern to clone them
    public BackgroundObject cloneObject() {
        return new BackgroundObject(this);
    }
}
