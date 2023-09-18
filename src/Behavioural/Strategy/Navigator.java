package Behavioural.Strategy;

// Step 3 - Adding a reference to context class
public class Navigator {
    private NavigationStrategy navigationStrategy;

    public Navigator(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }

    // Pass-through to strategy
    public Double navigate(String from, String to) {
        return navigationStrategy.navigate(from, to);
    }

    // Allows us to change strategy with an already created Strategy object
    public void setNavigationStrategy(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }
}
