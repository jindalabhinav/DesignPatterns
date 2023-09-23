package Creational.Factory.AbstractFactory;

// Step 2 - Create concrete product classes
public class DarkRadio extends Radio {

    @Override
    public void onSelect() {
        System.out.println("Dark Radio is selected");
    }

    @Override
    public void render() {
        System.out.println("Dark Radio Rendered!");
    }
}
