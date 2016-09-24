package uk.co.conclipsegames.cgupdater;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mod(name = CGUpdater.MODNAME, modid = CGUpdater.MODID, version = CGUpdater.MODVER)
public class CGUpdater {

    public static final String MODID = "cgupdater";
    public static final String MODNAME = "CG Updater";
    public static final String MODVER = "1.0";
    public static final String CFGPATH = "config/updater.list";
    public static boolean updateslistdidload = true;
    public static Map<String, String> updateLoc = new HashMap<String, String>();
    public static Map<String, String> saveLoc = new HashMap<String, String>();
    public static List<String> loadedKeys = new ArrayList<String>();

    public CGUpdater() {

    }

    @Mod.Instance
    public static CGUpdater instance = new CGUpdater();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        getUpdateConfig();
    }
    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
        // register server commands
        if (updateslistdidload) {
            event.registerServerCommand(new UpdateCmd());
            event.registerServerCommand(new ShowLoadedUpdates());
        } else {
            event.registerServerCommand(new UpdateCmd());
        }
    }
    public void getUpdateConfig() {
        String cline[];
        File f = new File(CFGPATH);
        System.out.println(f.getAbsolutePath());
        if ((f.exists()) && (f.isFile())) {
            try {
                for (String line : FileUtils.readLines(f)) {
                    cline = line.split("=");
                    if (cline.length == 3) {
                        updateLoc.put(cline[0], cline[2]);
                        saveLoc.put(cline[0], cline[1]);
                        loadedKeys.add(cline[0]);
                    }
                }
            } catch(IOException e) {
                System.out.println("Error loading updates");
                updateslistdidload = false;
            }
        } else {
            try {
                f.createNewFile();
            } catch (IOException e){System.out.println("updater.list did not exist and an error occurred whilst creating a new one.");}
        }
    }
}
