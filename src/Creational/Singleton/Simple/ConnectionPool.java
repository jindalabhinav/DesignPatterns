package Creational.Singleton.Simple;

public class ConnectionPool {
    // Step 3 - Local attribute, static because it's being initialized from a static method
    private static ConnectionPool INSTANCE = null;

    // Step 1 - Constructor hiding, so an object can't be created from outside this class by calling the constructor
    private ConnectionPool() {}

    // Step 2 - Global access point
    // Lazy Initialization - if no one never calls this object, this object will never be created
    public static ConnectionPool getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConnectionPool();
        }
        return INSTANCE;
    }
}

/*
    This code is not thread-safe, if two threads call the getInstance() method (which is also the critical section of this code)
    at the same time, they might be returned 2 different objects.
*/