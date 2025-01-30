package projectHale;


import arc.graphics.Color;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;

public class ModEnvironment {
    public static OreBlock ironOre;
    public static OreBlock copperOre;
    public static OreBlock sandOre;
    public static OreBlock combustible_iceOre;
    public static Floor stone;
    public static void load(){
        ironOre=new OreBlock("ironOre"){{
            itemDrop=ModItem.iron;
            oreScale=20;
            playerUnmineable=false;
            oreThreshold= 0.9F;
            useColor=true;
            mapColor= Color.valueOf("4cf0dc");
        }};
        copperOre=new OreBlock("copperOre"){{
            itemDrop=ModItem.copper;
            oreScale=18;
            playerUnmineable=false;
            oreThreshold= 0.9F;
            useColor=true;
            mapColor= Color.valueOf("db912d");
        }};
        sandOre=new OreBlock("sandOre"){{
            itemDrop=ModItem.sand;
            oreScale=30;
            playerUnmineable=false;
            oreThreshold= 0.9F;
            useColor=true;
            variants=0;
            mapColor= Color.valueOf("d8c323");
        }};
        combustible_iceOre=new OreBlock("combustible_iceOre"){{
            itemDrop=ModItem.combustible_ice;
            oreScale=15;
            playerUnmineable=false;
            oreThreshold= 0.9F;
            useColor=true;
            mapColor= Color.valueOf("dededa");
        }};
    }
}
