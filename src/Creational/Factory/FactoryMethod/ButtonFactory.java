package Creational.Factory.FactoryMethod;

public interface ButtonFactory {
    // Factory Method - a method that creates different kinds of objects
    Button createButton(Double border, Double radius, Double length);
}
