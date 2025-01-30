package projectHale;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

public class ModItem {
    public static Item iron;
    public static Item chip_basic;
    public static Item silicon_base;
    public static Item copper;
    public static Item sand;
    public static Item combustible_ice;
    public static final Seq<Item> frelItems = new Seq();

    public static void load() {
        iron = new Item("iron", Color.valueOf("797171")) {{
            hardness = 1;
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
        combustible_ice = new Item("combustible_ice", Color.valueOf("d8d0d0")) {{
            hardness = 2;
            alwaysUnlocked = true;
            flammability = 1.5f;
            explosiveness = 0.01f;
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
        frelItems.addAll(new Item[]{iron,copper,silicon_base,combustible_ice,chip_basic,sand});
    }
}
