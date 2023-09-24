package Structural.Decorator;

// Step 2 - Create concrete product class
public class FileDatabase implements Database {
    @Override
    public String read() {
        return "Base";
    }

    @Override
    public void write(String value) {
        System.out.println(value);
    }
}
