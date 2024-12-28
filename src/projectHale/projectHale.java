package projectHale;

import arc.*;
import arc.util.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class projectHale extends Mod{


    public projectHale(){
        Log.info("Loaded projectHale constructor...");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("welcome!");
                dialog.cont.image(Core.atlas.find("projecthale-ICON")).pad(30f).row();
                dialog.cont.add("-Welcome to [project:HALE]-").row();
                dialog.cont.add("[yellow]warning:Beta Version!").row();
                dialog.cont.add("[sky]Tks for your supporting!").row();
                dialog.cont.button("->continue->", dialog::hide).size(300f, 50f);
                dialog.show();
            });
        });
    }
    public void loadContent(){
        Log.info("Loading projectHale items...");
        ModItem.load();
    }

}
