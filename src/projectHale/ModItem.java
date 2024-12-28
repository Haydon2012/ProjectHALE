package projectHale;
import arc.graphics.Color;
import mindustry.type.Item;

public class ModItem {
    public static Item iron;
    public static Item chip_basic;
    public static void load() {
        iron=new Item("iron", Color.valueOf("797171")){{
            hardness=1;
            cost=0.3f;
            alwaysUnlocked=true;
            flammability=0f;
            explosiveness=0f;
            radioactivity=0f;
        }};
        chip_basic=new Item("chip_basic", Color.valueOf("a1db5e")){{
            cost=0.5f;
            alwaysUnlocked=true;
            flammability=0.2f;
            explosiveness=0.02f;
            radioactivity=0.2f;
        }};
    }
}