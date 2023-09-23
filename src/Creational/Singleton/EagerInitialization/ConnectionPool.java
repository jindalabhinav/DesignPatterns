package Creational.Singleton.EagerInitialization;

public class ConnectionPool {
    // Step 3 - Local attribute, static because it's being initialized from a static method
    // Eager Initialization, this is even thread safe
    private static ConnectionPool INSTANCE = new ConnectionPool();

    // Step 1 - Constructor hiding, so an object can't be created from outside this class by calling the constructor
    private ConnectionPool() {}

    // Step 2 - Global access point
    public static ConnectionPool getInstance() {
        return INSTANCE;
    }
}

/*
    But, when we have dynamic initialization, let's say certain parameters need to be passed
    to the getInstance to create an object of ConnectionPool (like the ConnectionPool name),
    that's not possible here

    Eager Initialization
    T0 - Run Program
    T1 - Class is loaded (during Compilation)
        This is also the time when an object of ConnectionPool is also created
    T2 - Runtime
        So before Runtime, we have an object of ConnectionPool, and is hence called Eager Initialization
*/