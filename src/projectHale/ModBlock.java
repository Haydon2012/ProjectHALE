package projectHale;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.meta.BuildVisibility;

public class ModBlock {
    public static Wall iron_wall;
    public static Wall iron_wall_large;
    public static GenericCrafter chip_stamper;
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
        //factories
        chip_stamper = new GenericCrafter("chip_stamper"){{
            requirements(Category.crafting, new ItemStack[]{new ItemStack(ModItem.iron, 50),new ItemStack(Items.copper,40)});
            craftEffect = Fx.smeltsmoke;
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
            chip_stamper.consumePower(0.50f);
            chip_stamper.consumeItems(new ItemStack(ModItem.iron,1),new ItemStack(Items.silicon,3));
        }};
    }
}
