package Creational.Singleton.BillPughSingleton;

public class ConnectionPool {
    private ConnectionPool() {}

    private static final class ConnectionPoolHolder {
        private static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.INSTANCE;
    }
}

// This is the most performant version of a lazy-initialization, thread-safe version of a Singleton
// When the ConnectionPool class is loaded, it doesn't load the ConnectionPoolHolder into memory.
// The inner static class is only loaded
// when the user calls:
// ConnectionPool connectionPool = ConnectionPool.getInstance();