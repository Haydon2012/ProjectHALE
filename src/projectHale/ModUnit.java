package projectHale;

import arc.func.Prov;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.content.UnitTypes;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.gen.Nulls;
import mindustry.gen.Unit;
import mindustry.gen.UnitEntity;
import mindustry.gen.UnitEntityLegacyGamma;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

import static mindustry.Vars.tilePayload;
import static mindustry.gen.Nulls.unit;

public class ModUnit {
    public static UnitType HaleI;

    static void load(){
        HaleI=new UnitType("HaleI") {{
            aiController = BuilderAI::new;
            isEnemy=false;
            armor = 2f;
            health = 100;
            speed = 4f;
            mineSpeed = 6.5f;
            mineTier = 1;
            rotateSpeed = 3f;
            accel = 0.3f;
            drag = 0.018f;
            flying = true;
            engineOffset = 8f;
            engineSize = 1f;
            faceTarget = true;
            hitSize = 20f;
            payloadCapacity = (3.5f * 3.5f) * tilePayload;
            buildSpeed = 2f;
            drawShields = false;
            lowAltitude = false;
            buildBeamOffset = 5;
            ammoCapacity = 200;
            abilities.add(new ForceFieldAbility(10f, 2f, 200f, 60f * 7));
            weapons.add(new Weapon("small-basic-weapon"){{
                reload = 10f;
                x = 2.2f;
                y = 1f;
                top = false;
                ejectEffect = Fx.casing1;

                bullet = new BasicBulletType(2.5f, 10){
                    {
                        this.width = 7.0F;
                        this.height = 9.0F;
                        this.lifetime = 120.0F;
                        this.shootEffect = Fx.shootSmall;
                        this.smokeEffect = Fx.shootSmallSmoke;
                        this.buildingDamageMultiplier = 0.5F;
                    }
                };
            }});
            this.defaultCommand = UnitCommand.assistCommand;
            constructor = UnitEntity::create;
        }};
    }
}
