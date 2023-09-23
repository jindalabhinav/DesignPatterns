package Creational.Factory.AbstractFactory;

// Step 4 - Create concrete factory classes
public class LightThemeFactory implements ThemeFactory {
    @Override
    public Button createButton(Double border, Double length, Double radius) {
        return new LightButton(border, length, radius);
    }

    @Override
    public Radio createRadio() {
        return new LightRadio();
    }
}
