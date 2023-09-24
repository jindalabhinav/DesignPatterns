package Structural.Decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest {

    @Test
    void testRead() {
        Database db = new FileDatabase();
        assertEquals("Base", db.read(), "If read is called, base should be called");
    }

    @Test
    void testEncryption() {
        Database db = new FileDatabase();
        Database encryptedDb = new EncryptionDecorator(db); // Now let's encrypt it


        assertEquals("Base - Decrypted", encryptedDb.read(), "If read is called, Decrypted should be returned");
    }

    @Test
    void testEncryptionAndCompression() {
        Database db = new FileDatabase();

        // Now let's encrypt it
        Database encryptedDb = new EncryptionDecorator(db);

        // Now let's compress it
        Database compressedAndEncryptedDb = new CompressionDecorator(encryptedDb);


        assertEquals("Base - Decrypted - Decompressed", compressedAndEncryptedDb.read(), "If read is called, Decrypted - Decompressed should be returned");
    }
}
