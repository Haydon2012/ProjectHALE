package projectHale;

import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class ModBullet {
    public static damageIncrease dI;

    public static void load() {

        dI = new damageIncrease(3.5f, 20f){{
            textureName = Vars.content.transformName("damage_increase");
            lifetime = 110;
            hitEffect = Fx.none;
            despawnEffect = Fx.none;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.smoke;
        }};
        dI.textureName = Vars.content.transformName("power-orb");
        ((ItemTurret) Blocks.duo).ammoTypes.put(Items.copper, dI);
    }
}
