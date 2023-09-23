package Creational.Factory.FactoryMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
// Step 1 - Create a common product interface
public abstract class Button {
    private Double border;

    public abstract void onClick();
    public abstract void render();
}
