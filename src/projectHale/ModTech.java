package projectHale;

import arc.struct.ObjectMap;
import arc.struct.Seq;
import mindustry.content.TechTree;
import mindustry.game.Objectives;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;

public class ModTech {
    public ModTech() {
    }
    public static ObjectMap<UnitType, ItemStack[]> unitBuildCost = new ObjectMap<>();

    public static void nodeUnit(UnitType type, Runnable children) {
        TechTree.node(type, (ItemStack[])unitBuildCost.get(type), children);
    }

    public static void nodeUnit(UnitType type, Seq<Objectives.Objective> objectives, Runnable children) {
        TechTree.node(type, (ItemStack[])unitBuildCost.get(type), objectives, children);
    }
    public static void load() {
        TechTree.TechNode root = TechTree.nodeRoot("projectHale", ModPlanet.frel, () -> {
            TechTree.node(ModBlock.magnetic_conveyor,() -> {
                TechTree.node(ModBlock.basic_unloader,() -> {
                    TechTree.node(ModBlock.router);
                });
            });
            TechTree.node(ModBlock.small_tank, () -> {
            });
            TechTree.node(ModBlock.core_basic, () -> {
            });
            TechTree.node(ModBlock.wind_turbine, () -> {
                TechTree.node(ModBlock.coreI);
                TechTree.node(ModBlock.chip_stamper ,()-> {
                    TechTree.node(ModBlock.magnetic_conveyor);

                });
            });
            TechTree.node(ModBlock.coreI,()->{
            });
            TechTree.node(ModBlock.octuple,()->{
                TechTree.node(ModBlock.missile);
            });
            TechTree.nodeProduce(ModItem.iron,() -> TechTree.nodeProduce(ModItem.copper,()->{
                    TechTree.node(ModBlock.wind_turbine);
                    TechTree.node(ModBlock.octuple);
            }));
        });
        root.planet = ModPlanet.frel;
        root.children.each((c) -> c.planet = ModPlanet.frel);
    }
}
