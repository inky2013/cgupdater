package uk.co.conclipsegames.cgupdater;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.entity.player.EntityPlayer;
import uk.co.conclipsegames.cgupdater.CGUpdater;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReloadLists implements ICommand {
    private final List aliases;

    public ReloadLists()
    {
        aliases = new ArrayList();
        aliases.add("reloadupdates");
    }

    @Override
    public int compareTo(Object o)
    {
        return 0;
    }

    @Override
    public String getCommandName()
    {
        return "reloadupdates";
    }

    @Override
    public String getCommandUsage(ICommandSender var1)
    {
        return "reloadupdates";
    }

    @Override
    public List getCommandAliases()
    {
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args)
    {
        if(sender instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) sender;
            if (!(uk.co.conclipsegames.cgupdater.CGUpdater.IsOp(player))) {
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED+"You are not opped on this server!"));
                return;
            }
        }
        CGUpdater.instance.reloadConfig();
        sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE+"Config Reloaded"));
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender var1)
    {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender var1, String[] var2)
    {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] var1, int var2)
    {
        return false;
    }
}
