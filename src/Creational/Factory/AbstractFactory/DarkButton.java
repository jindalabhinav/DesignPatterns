package Creational.Factory.AbstractFactory;

public class DarkButton extends Button {

    public DarkButton(Double border, Double length, Double radius) {
        super(border, length, radius);
    }

    @Override
    public void onClick() {
        System.out.println("Dark btn was clicked");
    }

    @Override
    public void render() {
        System.out.println("Dark Button Rendered!");
    }
}
