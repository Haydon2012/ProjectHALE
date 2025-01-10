package projectHale;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.Bullet;

public class damageIncrease extends BulletType {
    public TextureRegion dI;
    public String textureName = "";

    public damageIncrease(float speed, float damage) {
        super(speed, damage);
    }

    public damageIncrease() {
    }

    @Override
    public void load() {
        super.load();
        dI = Core.atlas.find(textureName);
    }

    public float dmgIncrease = 4f / 60f;
    @Override
    public void update(Bullet b) {
        super.update(b);
        b.damage += dmgIncrease;
    }

    @Override
    public void draw(Bullet b) {
        super.draw(b);
        Draw.rect(dI,b.x,b.y);
    }
}
