package Structural.Decorator;

// Step 4 - Create concrete decorators

// Why not directly implement Database? Because we also need the nextLayer which can only come from an abstract class.
public class EncryptionDecorator extends BaseDecorator {
    public EncryptionDecorator(Database nextLayer) {
        super(nextLayer);
    }

    @Override
    public String read() {
        String value = nextLayer.read();
        return decrypt(value);
    }

    private String decrypt(String value) {
        return value + " - Decrypted";
    }

    @Override
    public void write(String value) {
        String encrypted = encrypt(value);
        nextLayer.write(encrypted); // Once it's done with its own functionality, it calls the next layer
    }

    private String encrypt(String value) {
        return value + " - Encrypted";
    }
}
