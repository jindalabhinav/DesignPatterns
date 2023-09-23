package Creational.Factory.FactoryMethod;

import lombok.Getter;

@Getter
// Step 2 - Create the concrete product classes
public class SquareButton extends Button {
    private Double length;

    public SquareButton(Double length, Double border) {
        super(border);
        this.length = length;
    }

    @Override
    public void onClick() {
        System.out.println("Square btn was clicked");
    }

    @Override
    public void render() {
        System.out.println("Rendered!");
    }
}
