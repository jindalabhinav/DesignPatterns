# Flyweight Pattern

## Motivation

`In a game development, what object is the most common, even more than trees/mountains?`

- Bullets

Flyweight is one of those patterns that's not concerned with maintainability/extensibility, but rather only with scalability.

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

Let's say, 1 game HAS 400 bullets => 400 * 1.1KB (space used)

- 200 Users = 200* 400 * 1.1 = 80MB
- 2000 users = 800MB
- 2M Users = 800 GB

THIS IS HUGE, it's not feasible to have such memory allocated to bullets.

`Image field uses a lot of memory, however the image is same for all bullets, and that's where Flywheight Pattern comes into the picture.`

We break the attributes of the bullet down to 2 kinds of _States_

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

`HTTP Headers`

- Millions of HTTP requests have the same headers almost
- Flyweight helps

## Implementation

Steps:

1. Intrinsic State (constant) `[Bullet]`
2. Extrinsic State (dynamic) `[FlyingBullet]`
3. Compose Intrinsic in Extrinsic (take a reference of Intrinsic in Extrinsic)
   
   ```Java
   class FlyingBullet {
      Bullet bullet; // Intrinsic Attribute
      
      // Extrinsic Attributes
   }
   ```

`Note:` Compared to Prototype, we're not cloning the object here (not creating), but rather deciding the structure of the class (separating the attributes out).