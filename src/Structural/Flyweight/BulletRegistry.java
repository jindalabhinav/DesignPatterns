package Structural.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class BulletRegistry {
    Map<BulletType, Bullet> bullets = new HashMap<>();

    void addBullet(Bullet bullet) {
        bullets.put(bullet.getType(), bullet);
    }

    Bullet getBullet(BulletType type) {
        return bullets.get(type);
    }
}
