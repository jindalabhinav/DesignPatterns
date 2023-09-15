package Structural.Flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Bullet {
    private Double radius;
    private Double weight;
    private String image; // base64 encoded
    private BulletType type;
}
