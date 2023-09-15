package Structural.Decorator;

// Step 1 - Create Product Interface
public interface Datasource {
    String read();
    void write(String value);
}
