package uk.co.conclipsegames.projDart;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import uk.co.conclipsegames.projDart.proxy.CommonProxy;

@Mod(name = Constants.MODNAME, version = Constants.VERSION, modid = Constants.MODID)
public class ProjectDart {

    @SidedProxy(clientSide=Constants.BaseClassPath+".proxy.ClientProxy", serverSide=Constants.BaseClassPath+".proxy.ServerProxy")
    public static CommonProxy proxy;

}
