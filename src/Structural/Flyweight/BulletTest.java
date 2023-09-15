package Structural.Flyweight;

import org.junit.jupiter.api.Test;

public class BulletTest {

    @Test
    public void createFlyweight() {
        // Objects of Intrinsic State
        Bullet bullet = new Bullet(10.0, 0.9, "IMAGE", BulletType.TEN_MM);

        // Same Intrinsic State object used in below 2 Extrinsic State, thus saving space
        FlyingBullet flyingBullet1 = new FlyingBullet(0.0,0.0,0.0, 0.0, bullet);
        FlyingBullet flyingBullet2 = new FlyingBullet(10.0,10.0,10.0, 10.0, bullet);
    }

    @Test
    public void createFlyweightEnhanced() {
        // We can have a registry to store different prototypes of Bullets
        BulletRegistry registry = new BulletRegistry();

        // Objects of Intrinsic State
        Bullet bullet1 = new Bullet(10.0, 0.9, "IMAGE", BulletType.TEN_MM);
        Bullet bullet2 = new Bullet(10.0, 1.2, "IMAGE", BulletType.NINE_MM);

        registry.addBullet(bullet1);
        registry.addBullet(bullet2);

        // Same Intrinsic State object used in below 2 Extrinsic State, thus saving space
        FlyingBullet flyingBullet1 = new FlyingBullet(0.0,0.0,0.0, 12.0, registry.getBullet(BulletType.TEN_MM));
        FlyingBullet flyingBullet2 = new FlyingBullet(10.0,10.0,10.0, -10.0, registry.getBullet(BulletType.NINE_MM));
    }
}
