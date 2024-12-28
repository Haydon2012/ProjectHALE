package projectHale;

import arc.*;
import arc.util.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class projectHale extends Mod{


    public projectHale(){
        Log.info("Loaded projectHale constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("welcome!");
                dialog.cont.add("-Welcome-").row();
                dialog.cont.add("it is just in alpha...").row();
                dialog.cont.add("Tks for your supporting!").row();
                dialog.cont.image(Core.atlas.find("projectHale-frog")).pad(20f).row();
                dialog.cont.button("continue...", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }
    public void loadContent(){
        Log.info("Loading projectHale contents...");
        ModItem.load();
    }

}
