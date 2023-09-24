package Structural.Decorator;

// Step 1 - Create Product Interface
public interface Database {
    String read();
    void write(String value);
}
