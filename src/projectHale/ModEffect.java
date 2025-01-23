package projectHale;

import arc.Events;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.game.EventType;
import mindustry.type.StatusEffect;

public class ModEffect {
    public static StatusEffect emp;
    public static StatusEffect networkBlocked;
    public static void load(){
        emp=new StatusEffect("emp"){{
            this.buildSpeedMultiplier=0.8F;
            this.damageMultiplier=1.1F;
            this.speedMultiplier=0.5F;
            this.damage=1F/60;
            this.transitionDamage = 9.0F;
            this.effect= Fx.smeltsmoke;
        }};
        networkBlocked=new StatusEffect("networkBlocked"){{
            this.buildSpeedMultiplier=0.8F;
            this.damageMultiplier=0.6F;
            this.speedMultiplier=0.5F;
            this.transitionDamage = 9.0F;
            this.init(() -> {
                this.opposite(new StatusEffect[]{StatusEffects.melting, StatusEffects.burning});
                this.affinity(ModEffect.emp, (unit, result, time) -> {
                    unit.damagePierce(this.transitionDamage);
                });
            });
        }};
    }
}
