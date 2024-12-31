package projectHale;

import mindustry.content.Blocks;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.distribution.ArmoredConveyor;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.distribution.StackConveyor;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.meta.BuildVisibility;

public class ModBlock {
    public static Wall iron_wall;
    public static Wall iron_wall_large;
    public static GenericCrafter chip_stamper;
    public static StackConveyor magnetic_conveyor;
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
        //transport
        magnetic_conveyor=new StackConveyor("magnetic_conveyor"){{
            requirements(Category.distribution, BuildVisibility.shown, new ItemStack[]{new ItemStack(ModItem.iron, 6),new ItemStack(ModItem.chip_basic,3)});
            canOverdrive=true;
            hasItems=true;
            speed=0.2f;
            size=1;
            itemCapacity=8;
        }};
        //factories
        chip_stamper = new GenericCrafter("chip_stamper"){{
            requirements(Category.crafting, new ItemStack[]{new ItemStack(ModItem.iron, 50)});
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
        }};
    }
}
