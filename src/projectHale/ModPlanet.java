package projectHale;

import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.game.Team;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.SerpuloPlanetGenerator;
import mindustry.type.Item;
import mindustry.type.Planet;
import mindustry.world.meta.Attribute;

public class ModPlanet {
    public static Planet frel;
    public static Planet sun;

    public static void load() {
        sun = new Planet("sun", (Planet)null, 4.0F) {
            {
                this.bloom = true;
                this.accessible = false;
                this.meshLoader = () -> new SunMesh(this, 4, (double)5.0F, 0.3, 1.7, 1.2, (double)1.0F, 1.1F, new Color[]{Color.valueOf("ff7a38"), Color.valueOf("ff9638"), Color.valueOf("ffc64c"), Color.valueOf("ffc64c"), Color.valueOf("ffe371"), Color.valueOf("f4ee8e")});
            }
        };
        frel = new Planet("Frel", sun, 1.0F, 2) {
            {
                generator = new SerpuloPlanetGenerator();
                this.meshLoader = () -> new HexMesh(this, 7);
                this.cloudMeshLoader = () -> new MultiMesh(new GenericMesh[]{new HexSkyMesh(this, 3, 0.15F, 0.14F, 5, Color.valueOf("708165").a(0.75F), 2, 0.42F, 1.0F, 0.43F), new HexSkyMesh(this, 3, 0.6F, 0.15F, 5, Color.valueOf("aaaabb").a(0.75F), 2, 0.42F, 1.2F, 0.45F)});
                this.alwaysUnlocked = true;
                this.landCloudColor = Color.valueOf("3ba7de");
                this.atmosphereColor = Color.valueOf("8bd4e8");
                this.defaultEnv = 17;
                this.startSector = 0;
                this.atmosphereRadIn = 0.02F;
                this.atmosphereRadOut = 0.3F;
                this.tidalLock = true;
                this.orbitSpacing = 3F;
                this.totalRadius += 70F;
                this.radius=1f;
                this.lightSrcTo = 0.5F;
                this.lightDstFrom = 0.2F;
                this.clearSectorOnLose = true;
                this.defaultCore = ModBlock.core_basic;
                this.iconColor = Color.valueOf("116464");
                this.hiddenItems.addAll(Items.erekirItems).removeAll(ModItem.frelItems);
                hiddenItems.removeAll(Items.serpuloItems);
                this.enemyBuildSpeedMultiplier = 1F;
                this.allowLaunchToNumbered = true;
                this.updateLighting = false;
                this.defaultAttributes.set(Attribute.water, 0.2F);
                this.ruleSetter = (r) -> {
                    r.waveTeam = Team.crux;
                    r.placeRangeCheck = false;
                    r.showSpawns = true;
                    r.fog = false;
                    r.staticFog = true;
                    r.lighting = false;
                    r.coreDestroyClear = true;
                    r.onlyDepositCore = true;
                };
                this.unlockedOnLand.add(ModBlock.core_basic);
            }
        };
    }
}
