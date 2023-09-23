package Creational.Factory.AbstractFactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Button {
    private Double border, length, radius;
    public abstract void onClick(); // when we click a button
    public abstract void render();
}
