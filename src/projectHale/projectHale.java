package projectHale;

import arc.Core;
import arc.Events;
import arc.util.Log;
import arc.util.Time;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;

public class projectHale extends Mod{


    public projectHale(){
        Log.info("Loaded projectHale constructor...");

        Events.on(ClientLoadEvent.class, e -> {
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("Welcome!\n[cyan]欢迎!");
                dialog.cont.image(Core.atlas.find("projecthale-ICON")).pad(50f).row();
                dialog.addCloseButton();
                dialog.cont.add("-Welcome to [project:HALE]-").row();
                dialog.cont.add("[sky]Tks for your support!").row();
                dialog.cont.row();
                dialog.cont.add("一个非常正常的模组，就是画工有点差").row();
                dialog.cont.add("剧透：前期非常累手，后期就会好一点（划）");
                dialog.cont.add(",自己体会").row();
                dialog.cont.add("还有，别问有没有Q群，[grey]本人连一个qq号都没有呢").row();
                dialog.cont.add("[white]玩  的  开  心  ！").row();
                dialog.cont.add("（内心OS:模组叫什么好呢，好纠结啊）").row();
                dialog.show();
            });
        });
    }
    public void loadContent(){
        Log.info("Loading projectHale contents...");
        ModItem.load();
        ModPlanet.load();
        ModLiquid.load();
        ModEffect.load();
        ModUnit.load();
        ModEnvironment.load();
        Log.info("Loading projectHale blocks...");
        ModBlock.load();
        ModTech.load();
    }

}