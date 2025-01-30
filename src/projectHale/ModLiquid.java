package projectHale;

import arc.graphics.Color;
import mindustry.content.Liquids;
import mindustry.type.Liquid;

public class ModLiquid {
    public static Liquid natural_water;
    public static void load(){
        natural_water=new Liquid("natural_water",Color.valueOf("3cb6e8")){{
            this.alwaysUnlocked=true;
            this.capPuddles=true;
            this.coolant=true;
            this.heatCapacity=0.3F;
            this.boilPoint = 0.8F;
            this.gasColor = Color.grays(0.7F);
        }};
    }
}
