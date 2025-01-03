package projectHale;
import arc.graphics.Color;
import mindustry.type.Item;
import mindustry.type.ItemStack;

public class ModItem {
    public static Item iron;
    public static Item chip_basic;
    public static Item silicon_base;
    public static Item copper;
    public static Item sand;

    public static void load() {
        iron = new Item("iron", Color.valueOf("797171")) {{
            hardness = 2;
            cost = 2.6f;
            alwaysUnlocked = true;
            flammability = 0f;
            explosiveness = 0f;
            radioactivity = 0f;
        }};
        copper = new Item("copper", Color.valueOf("dabd50")) {{
            hardness = 1;
            cost = 3f;
            alwaysUnlocked = true;
            flammability = 0f;
            explosiveness = 0f;
            radioactivity = 0.01f;
        }};
        sand = new Item("sand", Color.valueOf("e1e825")) {{
            hardness = 0;
            alwaysUnlocked = true;
            flammability = 0.02f;
            explosiveness = 0f;
            radioactivity = 0f;
        }};
        silicon_base = new Item("silicon_base", Color.valueOf("414141")) {{
            cost = 2.6f;
            alwaysUnlocked = true;
            flammability = 0f;
            explosiveness = 0f;
            radioactivity = 0.4f;
        }};
        chip_basic = new Item("chip_basic", Color.valueOf("a1db5e")) {{
            cost = 2.8f;
            alwaysUnlocked = true;
            flammability = 0.1f;
            explosiveness = 0.02f;
            radioactivity = 0.2f;
        }};
    }
}
