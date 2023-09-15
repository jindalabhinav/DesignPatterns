package Builder.BuilderEnhanced;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseTest {

    @Test
    public void testDatabaseBuilder() {
        Database db =
                Database.builder()
                        .withName("testDb")
                        .withCredentials("user", "pass")
                        .mySql()
                        .port(3306)
                        .isCompressed(false)
                        .build();

        Assertions.assertEquals(db.getName(), "testDb");
    }
}
