package Creational.Singleton.ThreadSafe;

public class ConnectionPool {
    // Step 3 - Local attribute, static because it's being initialized from a static method
    private static ConnectionPool INSTANCE = null;

    // Step 1 - Constructor hiding, so an object can't be created from outside this class by calling the constructor
    private ConnectionPool() {}

    // Step 2 - Global access point

    // OPTION 1
    // making this function synchronized, slows down this code
    public synchronized static ConnectionPool getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConnectionPool();
        }
        return INSTANCE;
    }

    // OPTION 2
    // instead of blocking the whole method, let's try the sync block
    // another problem here is that, even if an object exists, this will allow only 1 thread to enter the critical section
    // we want to restrict threads, only when the object is null
//    public static ConnectionPool getInstance() {
////      synchronized (INSTANCE) { // this won't work because INSTANCE is null here
//        synchronized (ConnectionPool.class) { // this way we've not synchronized the method, but rather when 2 threads come to this line, they'll become synchronized, not a huge improvement still
//            if (INSTANCE == null) {
//                INSTANCE = new ConnectionPool();
//            }
//        }
//        return INSTANCE;
//    }

    // OPTION 3
    // we can try putting a sync block inside the if block
    // but then again, once T1 has entered the critical section for the first time, and T2 waits for T1 to exit, T2 once enters, will again create a new object, so this doesn't work
//    public static ConnectionPool getInstance() {
//        if (INSTANCE == null) {
//            synchronized(ConnectionPool.class) {
//                INSTANCE = new ConnectionPool();
//            }
//        }
//        return INSTANCE;
//    }
}

/*
    This is a thread-safe version, not very performant though.
*/