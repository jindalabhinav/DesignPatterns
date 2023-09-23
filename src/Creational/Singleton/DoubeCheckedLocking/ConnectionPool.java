package Creational.Singleton.DoubeCheckedLocking;

public class ConnectionPool {
    // Step 3 - Local attribute, static because it's being initialized from a static method
    private static ConnectionPool INSTANCE = null;

    // Step 1 - Constructor hiding, so an object can't be created from outside this class by calling the constructor
    private ConnectionPool() {}

    // Step 2 - Global access point
    public static ConnectionPool getInstance() {
        if (INSTANCE == null) {
            synchronized (ConnectionPool.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectionPool();
                }
            }
        }
        return INSTANCE;
    }
}

/*
    This code is a double-checked locked version, which is more performant than the normal thread-safe version
*/