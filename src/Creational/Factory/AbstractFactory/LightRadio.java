package Creational.Factory.AbstractFactory;

public class LightRadio extends Radio {
    @Override
    public void onSelect() {
        System.out.println("Light Radio is selected");
    }

    @Override
    public void render() {
        System.out.println("Light Radio Rendered!");
    }
}
