package Structural.Decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatasourceTest {

    @Test
    void testRead() {
        Datasource db = new FileDatasource();
        assertEquals("Base", db.read(), "If read is called, base should be called");
    }

    @Test
    void testEncryption() {
        Datasource db = new FileDatasource();
        Datasource encryptedDb = new EncryptionDecorator(db); // Now let's encrypt it


        assertEquals("Base - Decrypted", encryptedDb.read(), "If read is called, Decrypted should be returned");
    }

    @Test
    void testEncryptionAndCompression() {
        Datasource db = new FileDatasource();

        // Now let's encrypt it
        Datasource encryptedDb = new EncryptionDecorator(db);

        // Now let's compress it
        Datasource compressedDb = new EncryptionDecorator(encryptedDb);


        assertEquals("Base - Decrypted - Decompressed", encryptedDb.read(), "If read is called, Decrypted should be returned");
    }
}
