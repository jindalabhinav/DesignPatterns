package Creational.Factory.FactoryMethod;

import lombok.Getter;

@Getter
// Step 2 - Create the concrete product classes
public class RoundBtn extends Button {
    private Double radius;

    public RoundBtn(Double radius, Double border) {
        super(border);
        this.radius = radius;
    }

    @Override
    public void onClick() {
        System.out.println("Round btn was clicked");
    }

    @Override
    public void render() {
        System.out.println("Rendered!");
    }
}
