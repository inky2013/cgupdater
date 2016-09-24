package uk.co.conclipsegames.cgupdater;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class UpdateCmdErrored implements ICommand {
    private final List aliases;

    public UpdateCmdErrored()
    {
        aliases = new ArrayList();
        aliases.add("update");
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
        return "update";
    }

    @Override
    public String getCommandUsage(ICommandSender var1)
    {
        return "Restart Minecraft/Server";
    }

    @Override
    public List getCommandAliases()
    {
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args)
    {
        sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED+"There was an error loading the config."));
        sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED+"Run "+EnumChatFormatting.WHITE+"/reloadupdates "+EnumChatFormatting.RED+"to reload the config"));
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
