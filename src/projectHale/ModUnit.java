package projectHale;

import arc.graphics.Color;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.BuilderAI;
import mindustry.ai.types.FlyingAI;
import mindustry.content.Fx;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.part.HoverPart;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.world.meta.BlockFlag;

import static mindustry.Vars.tilePayload;

public class ModUnit {
    public static UnitType HaleI;
    public static UnitType drone;

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
        drone=new UnitType("drone"){{
            aiController = FlyingAI::new;
            isEnemy=false;
            armor = 1f;
            health = 75;
            speed = 7f;
            range=35f;
            rotateSpeed = 5f;
            accel = 0.4f;
            drag = 0.04f;
            flying = true;
            engineOffset = 8f;
            engineSize = 1f;
            faceTarget = true;
            hitSize = 15f;
            buildSpeed = 3f;
            lowAltitude = false;
            buildBeamOffset = 5;
            ammoCapacity = 140;
            for(final float f : new float[]{-3.0F, 3.0F}) {
                this.parts.add(new HoverPart() {
                    {
                        this.x = 3.9F;
                        this.y = f;
                        this.mirror = true;
                        this.radius = 6.0F;
                        this.phase = 90.0F;
                        this.stroke = 2.0F;
                        this.layerOffset = -0.001F;
                        this.color = Color.valueOf("71918a");
                    }
                });
            }
            this.targetFlags = new BlockFlag[]{BlockFlag.battery,BlockFlag.generator, null};
            constructor = UnitEntity::create;
        }};
    }
}
