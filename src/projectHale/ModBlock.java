package projectHale;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.content.Fx;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.part.DrawPart;
import mindustry.entities.part.HaloPart;
import mindustry.entities.pattern.ShootBarrel;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.distribution.Router;
import mindustry.world.blocks.distribution.StackConveyor;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.draw.*;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class ModBlock {
    public static Wall iron_wall;
    public static Wall iron_wall_large;
    public static Wall iron_wall_advanced;
    public static GenericCrafter chip_stamper;
    public static StackConveyor magnetic_conveyor;
    public static Unloader basic_unloader;
    public static ConsumeGenerator wind_turbine;
    public static CoreBlock core_basic;
    static Attribute attribute;
    public static UnitFactory coreI;
    public static ItemTurret octuple;
    public static LiquidRouter small_tank;
    public static Router router;
    public static ItemTurret missile;
    public static GenericCrafter silicon_smelter;

    public static void load() {
        //walls
        iron_wall = new Wall("iron_wall") {{
            requirements(Category.defense, BuildVisibility.shown, new ItemStack[]{new ItemStack(ModItem.iron,6)});
            health = 800;
            size = 1;
            buildCostMultiplier = 2f;
        }};
        iron_wall_large = new Wall("iron_wall_large") {{
            requirements(Category.defense, BuildVisibility.shown, new ItemStack[]{new ItemStack(ModItem.iron,24)});
            health = 3500;
            size = 2;
            buildCostMultiplier = 2f;
        }};
        iron_wall_advanced = new Wall("iron_wall_advanced") {{
            requirements(Category.defense, BuildVisibility.shown, new ItemStack[]{new ItemStack(ModItem.iron,24),new ItemStack(ModItem.copper,24),new ItemStack(ModItem.chip_basic,10)});
            health = 5000;
            size = 2;
            absorbLasers=true;
            chanceDeflect=0.1f;
            buildCostMultiplier = 2f;
        } };
        //transport
        magnetic_conveyor=new StackConveyor("magnetic_conveyor"){{
            requirements(Category.distribution, BuildVisibility.shown, new ItemStack[]{new ItemStack(ModItem.iron, 6),new ItemStack(ModItem.chip_basic,3)});
            canOverdrive=true;
            hasItems=true;
            speed=0.2f;
            size=1;
            itemCapacity=8;
            health=70;
            unloadable=true;
        }};
        basic_unloader=new Unloader("basic_unloader"){{
            requirements(Category.effect, BuildVisibility.shown, new ItemStack[]{new ItemStack(ModItem.iron, 20),new ItemStack(ModItem.copper,15),new ItemStack(ModItem.chip_basic,15)});
            canOverdrive=true;
            speed=0.7f;
            size=1;
            health=50;
            group = BlockGroup.transportation;
        }};
        router = new Router("router") {{
            this.requirements(Category.distribution, ItemStack.with(new Object[]{ModItem.iron,3,ModItem.chip_basic,2}));
            this.buildCostMultiplier = 3F;
            this.speed=0.8f;
        }};
        //factories
        silicon_smelter = new GenericCrafter("silicon_smelter"){{
            requirements(Category.crafting, new ItemStack[]{new ItemStack(ModItem.iron, 50),new ItemStack(ModItem.copper,40)});
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(ModItem.silicon_base, 1);
            craftTime = 50f;
            size = 2;
            hasPower = true;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            hasItems=true;
            itemCapacity=10;
            health=120;
            canOverdrive=true;
            consumePower(2f);
            consumeItems(new ItemStack(ModItem.sand,4));
            size = 2;
        }};
        chip_stamper = new GenericCrafter("chip_stamper"){{
            requirements(Category.crafting, new ItemStack[]{new ItemStack(ModItem.iron, 80),new ItemStack(ModItem.copper,30)});
            craftEffect = Fx.circleColorSpark;
            outputItem = new ItemStack(ModItem.chip_basic, 2);
            craftTime = 40f;
            size = 2;
            hasPower = true;
            hasLiquids = false;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;
            hasItems=true;
            itemCapacity=10;
            health=120;
            canOverdrive=true;
            consumePower(1f);
            consumeItems(new ItemStack(ModItem.iron,1),new ItemStack(ModItem.silicon_base,3));
            size = 2;
        }};
        //generator
        wind_turbine=new ConsumeGenerator("wind_turbine"){{
                requirements(Category.power, new ItemStack[]{new ItemStack(ModItem.iron, 4), new ItemStack(ModItem.copper, 35)});
                this.outputsPower = true;
                connectedPower = true;
                this.hasPower = true;
                this.ambientSound = Sounds.hum;
                this.ambientSoundVolume = 0.06F;
                this.powerProduction = 1.5F;
                size = 2;
                this.drawer = new DrawMulti(new DrawBlock[]{new DrawDefault(), new DrawRegion("-rotator1") {
                    {
                        this.rotateSpeed = 6F;
                    }
                }});
        }};
        //core
        core_basic=new CoreBlock("core_basic"){{
            requirements(Category.effect, new ItemStack[]{new ItemStack(ModItem.iron, 2000),new ItemStack(ModItem.copper,1000),new ItemStack(ModItem.chip_basic,500),new ItemStack(ModItem.silicon_base,200)});
            health=4000;
            this.acceptsItems=true;
            this.alwaysUnlocked=true;
            this.requiresCoreZone=true;
            this.coreMerge=true;
            this.unitCapModifier=6;
            size=3;
            this.unitType=ModUnit.HaleI;
            itemCapacity=10000;
        }};
        //units
        coreI = new UnitFactory("coreI"){{
            requirements(Category.units, with(ModItem.iron, 40, ModItem.copper, 120, ModItem.chip_basic, 80));
            plans = Seq.with(
                    new UnitFactory.UnitPlan(ModUnit.HaleI, 60f * 12, with(ModItem.iron, 40, ModItem.chip_basic, 20))
            );
            size = 2;
            health=600;
            consumePower(3f);
        }};
        //logic
        //turrets
        octuple=new ItemTurret("octuple"){{
            requirements(Category.turret, with(ModItem.iron,40, ModItem.copper,20));
            health=500;
            maxAmmo = 30;
            size = 1;
            reload = 8f;
            recoils=8;
            targetAir=false;
            targetGround=true;
            this.ammo(new Object[]{ModItem.iron, new BasicBulletType(3F,6.5F) {
                {
                    this.lifetime = 52F;
                    this.ammoMultiplier = 4F;
                    health=10;
                }
            }});

            shoot = new ShootBarrel();
            this.recoil = 0.25F;
            this.shootY = 3.0F;
            this.reload = 5F;
            this.range = 140F;
            this.shootCone = 15.0F;
            this.ammoUseEffect = Fx.casing1;
            this.health = 300;
            this.inaccuracy = 3F;
            this.rotateSpeed = 8F;
            this.coolant = this.consumeCoolant(0.2F);
            this.researchCostMultiplier = 0.05F;
            recoils=8;
        }};
        missile=new ItemTurret("missile"){{
            requirements(Category.turret, with(ModItem.iron,120,ModItem.chip_basic,70));
            this.coolant = this.consumeCoolant(0.6F);
            health=500;
            maxAmmo = 2;
            reload = 75f;
            size=2;
            range=800f;
            targetGround=true;
            targetAir=true;
            this.ammo(new Object[]{ModItem.chip_basic, new MissileBulletType() {
                {
                    this.lifetime = 200F;
                    this.ammoMultiplier = 1F;
                    speed=4f;
                    damage=30f;
                    buildingDamageMultiplier=0.001f;
                    trailEffect=Fx.missileTrail;
                }
            }});
            this.drawer = new DrawTurret() {{
                this.parts.addAll(new DrawPart[]{new HaloPart() {{
                    progress=DrawPart.PartProgress.reload.delay(0);
                    rotateSpeed=0;
                    sides=1;
                    shapes=1;
                    color=Color.valueOf("25c9ab");
                    hollow=true;
                    stroke=1;
                    strokeTo=0;
                    radius=5;
                    radiusTo=0;
                    triLength=10;
                    triLengthTo=0;
                    haloRadius=30;
                    haloRotation=0f;
                    layer=110;
                    haloRotateSpeed=0f;
                    tri=true;
                }},
                new HaloPart() {{
                    progress=DrawPart.PartProgress.reload.delay(0);
                    rotateSpeed=0;
                    sides=1;
                    shapes=1;
                    color=Color.valueOf("25c9ab");
                    hollow=true;
                    stroke=1;
                    strokeTo=0;
                    radius=5;
                    radiusTo=0;
                    triLength=15;
                    triLengthTo=0;
                    haloRadius=60;
                    haloRotation=0f;
                    layer=110;
                    haloRotateSpeed=0f;
                    tri=true;
                }},
                new HaloPart() {{
                    progress=DrawPart.PartProgress.reload.delay(0);
                    rotateSpeed=0;
                    sides=1;
                    shapes=1;
                    color=Color.valueOf("25c9ab");
                    hollow=true;
                    stroke=1;
                    strokeTo=0;
                    radius=5;
                    radiusTo=0;
                    triLength=15;
                    triLengthTo=0;
                    haloRadius=90;
                    haloRotation=0f;
                    layer=110;
                    haloRotateSpeed=0f;
                    tri=true;
                }}
                });
            }};
        }};
        //liquid
        small_tank=new LiquidRouter("small_tank"){{
            this.requirements(Category.liquid, ItemStack.with(new Object[]{ModItem.iron, 60}));
            this.liquidCapacity = 200.0F;
            this.size = 1;
            this.health=60;
            this.solid = true;
            this.alwaysUnlocked=true;
            this.outputsLiquid=true;
        }};
        //drill
    }
}