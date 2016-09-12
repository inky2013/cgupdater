package uk.co.conclipsegames.projDart;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import uk.co.conclipsegames.projDart.Proxy.CommonProxy;

@Mod(name = Constants.MODNAME, version = Constants.VERSION, modid = Constants.MODID)
public class ProjectDart {

    @SidedProxy(clientSide=Constants.BaseClassPath+".Proxy.ClientProxy", serverSide=Constants.BaseClassPath+".Proxy.ServerProxy")
    public static CommonProxy proxy;

}
