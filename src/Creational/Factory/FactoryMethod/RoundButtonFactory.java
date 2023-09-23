package Creational.Factory.FactoryMethod;

public class RoundButtonFactory implements ButtonFactory {
    @Override
    public Button createButton(Double border, Double radius, Double length) {
        return new RoundBtn(border, radius);
    }
}
