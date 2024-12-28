package projectHale;
import arc.graphics.Color;
import mindustry.type.Item;

public class ModItem {
    public static Item iron;
    public static void load() {
        iron=new Item("Iron", Color.valueOf("cfc1c1")){{
            hardness=1;
            cost=0.3f;
            alwaysUnlocked=true;
            flammability=0f;
            explosiveness=0f;
            radioactivity=0.01f;
        }};
    }
}
