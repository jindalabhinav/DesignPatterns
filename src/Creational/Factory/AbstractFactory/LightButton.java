package Creational.Factory.AbstractFactory;

public class LightButton extends Button {

    public LightButton(Double border, Double length, Double radius) {
        super(border, length, radius);
    }

    @Override
    public void onClick() {
        System.out.println("Light btn was clicked");
    }

    @Override
    public void render() {
        System.out.println("Light Button Rendered!");
    }
}
