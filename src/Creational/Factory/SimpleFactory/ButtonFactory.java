package Creational.Factory.SimpleFactory;

public class ButtonFactory {
    public static Button createButton(ScreenSize screenSize, Double border, Double radius, Double length) {
        switch (screenSize) {
            case PHONE:
            case TABLET: return new RoundBtn(border, radius);
            case DESKTOP: return new SquareButton(border, length);
        }

        throw new IllegalArgumentException("this type isn't supported: " + screenSize);
    }
}
