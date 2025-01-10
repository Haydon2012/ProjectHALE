package projectHale;

import arc.struct.Seq;
import mindustry.content.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.mod.Mod;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.Turret;
import mindustry.world.blocks.distribution.ArmoredConveyor;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.distribution.StackConveyor;
import mindustry.world.blocks.power.PowerGenerator;
import mindustry.world.blocks.power.SolarGenerator;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.draw.DrawBlock;
import mindustry.world.draw.DrawBlurSpin;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawMulti;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.BuildVisibility;
import org.w3c.dom.Attr;

import static mindustry.type.ItemStack.with;
import static mindustry.world.meta.StatValues.ammo;
import static projectHale.ModUnit.HaleI;

public class ModBlock {
    public static Wall iron_wall;
    public static Wall iron_wall_large;
    public static Wall iron_wall_advanced;
    public static GenericCrafter chip_stamper;
    public static StackConveyor magnetic_conveyor;
    public static Unloader basic_unloader;
    public static PowerGenerator wind_turbine;
    public static CoreBlock core_basic;
    static Attribute attribute;
    public static UnitFactory coreI;
    public static Turret octuple;

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
        }};
        basic_unloader=new Unloader("basic_unloader"){{
            requirements(Category.effect, BuildVisibility.shown, new ItemStack[]{new ItemStack(ModItem.iron, 20),new ItemStack(ModItem.copper,15),new ItemStack(ModItem.chip_basic,15)});
            canOverdrive=true;
            speed=0.7f;
            size=1;
            health=50;
            group = BlockGroup.transportation;
        }};
        //factories
        chip_stamper = new GenericCrafter("chip_stamper"){{
            requirements(Category.crafting, new ItemStack[]{new ItemStack(ModItem.iron, 80)});
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
            consumePower(0.50f);
            consumeItems(new ItemStack(ModItem.iron,1),new ItemStack(ModItem.silicon_base,3));
            size = 2;
        }};
        //generator
        wind_turbine=new SolarGenerator("wind_turbine"){{
            requirements(Category.power, new ItemStack[]{new ItemStack(ModItem.iron, 4),new ItemStack(ModItem.copper,35)});
            this.outputsPower=true;
            connectedPower=true;
            this.hasPower=true;
            this.ambientSound = Sounds.hum;
            this.ambientSoundVolume = 0.06F;
            this.powerProduction=6F;
            size=2;
            this.drawer = new DrawMulti(new DrawBlock[]{new DrawDefault(), new DrawBlurSpin("-rotator", 5.4F) {
                {
                    this.blurThresh = 0.01F;
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
        //turrets
        octuple=new Turret("octuple"){{
            requirements(Category.turret, with(ModItem.iron,40, ModItem.copper,20));
            health=500;
            maxAmmo = 30;
            size = 1;
            reload = 8f;
            range = 240f;
            this.ammo(new Object[]{ModItem.iron, new damageIncrease(2.5F, 4F) {
                {
                    this.lifetime = 80F;
                    this.ammoMultiplier = 4F;
                }
            }});
        }};
    }
}