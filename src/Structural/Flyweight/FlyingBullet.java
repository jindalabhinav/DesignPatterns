package Structural.Flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Step 2 - Extrinsic State
@AllArgsConstructor
@Getter
public class FlyingBullet {
    private Double x, y, z;
    private Double direction;

    // Step 3 - Has-a relation
    private Bullet bullet;
}
