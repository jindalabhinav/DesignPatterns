package Creational.Singleton.Simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConnectionPoolTest {

    @Test
    public void testGetInstance() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        assertNotNull(connectionPool, "if the getInstance() is called, the non-null object should be returned");
    }

    @Test
    public void testSingleInstance() {
        ConnectionPool instance1 = ConnectionPool.getInstance();
        ConnectionPool instance2 = ConnectionPool.getInstance();

        assertEquals(instance1, instance2, "if the instance is a Singleton, it should only create 1 instance and return the same everytime");
    }
}
