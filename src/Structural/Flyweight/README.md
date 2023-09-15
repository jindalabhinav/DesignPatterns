# Flyweight Pattern

In a game development, what object is the most common, even more than trees/mountains? <br>
Bullets

Flyweight is one of those patterns that's not concerned witrrh maintainability/extensibility, but rather only with scalability.

```Java
class Bullet {
  x,y,z; // Double - 8*3 - 24 Bytes
  radius; // Double - 8 Bytes
  direction; // Double - 8 Bytes
  speed; // Double - 8 Bytes
  type; // Enum (Integers) - 2 Bytes
  image/pixels; // 1KB (probably)
}
```

> Let's try to find out the memory used by a Bullet.

space used = image + others = 1.1 KB

1 Game - 400 bullets - 400 *1.1KB<br>
200 Users - 200* 400 * 1.1 = 80MB<br>
2000 users = 800MB<br>
2M = 800 GB

THIS IS HUGE, that not feasible to have such memory allocated to bullets.

Image field uses a lot of memory, however the image is same for all bullets, and that's where Flywheight Pattern comes into picture.

State (we break the attributes of the bullet down to)

- Intrinsic
  - Constant Data (fields that doesn't change, from object to object)
- Extrinsic
  - Dynamic Data

Bullet's State

- Normal Bullet (Intrinsic State)
  - Image (constant)
  - Type
  - Radius
- Flying Bullet (Extrinsic State)
  - x, y, z
  - Direction
  - Speed

Whenever we have such states present, we have 2 classes for above. 
Prototype bcz it's hard to create
Flyweight because it's Intrinsic and Extrinsic, small fields with high volumes.

HTTP Headers

- Millions of HTTP requests have the same headers almost
- Flyweight helps

## Implementation

Steps:

1. Intrinsic State (constant)
2. Extrinsic State (dynamic)
3. Compose Intrinsic in Extrinsic (take a reference of Intrinsic in Extrinsic)
   
   ```Java
   class FlyingBullet {
      Bullet bullet;

      ...
   }
   ```

