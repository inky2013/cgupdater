package uk.co.conclipsegames.cgupdater;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ShowLoadedUpdates implements ICommand {
    private final List aliases;

    public ShowLoadedUpdates()
    {
        aliases = new ArrayList();
        aliases.add("showloadedupdates");
    }

    @Override
    public int compareTo(Object o)
    {
        return 0;
    }

    @Override
    public String getCommandName()
    {
        return "showloadedupdates";
    }

    @Override
    public String getCommandUsage(ICommandSender var1)
    {
        return "showloadedupdates";
    }

    @Override
    public List getCommandAliases()
    {
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args)
    {
        if (CGUpdater.loadedKeys.size() != 0) {
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Loaded Update Commands:"));
            for (int x = 0; x < CGUpdater.loadedKeys.size(); x++) {
                sender.addChatMessage(new ChatComponentText(EnumChatFormatting.WHITE + " - " + EnumChatFormatting.BLUE + CGUpdater.loadedKeys.get(x)));
            }
        } else {
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "No updates in config"));
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender var1)
    { return true; }

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
