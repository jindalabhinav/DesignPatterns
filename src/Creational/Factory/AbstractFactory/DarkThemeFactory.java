package Creational.Factory.AbstractFactory;

public class DarkThemeFactory implements ThemeFactory {
    @Override
    public Button createButton(Double border, Double length, Double radius) {
        return new DarkButton(border, length, radius);
    }

    @Override
    public Radio createRadio() {
        return new DarkRadio();
    }
}
