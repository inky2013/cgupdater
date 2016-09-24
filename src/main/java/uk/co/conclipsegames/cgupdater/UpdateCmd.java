package uk.co.conclipsegames.cgupdater;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Pack200;

public class UpdateCmd implements ICommand {
    private final List aliases;

    public UpdateCmd()
    {
        aliases = new ArrayList();
        aliases.add("update");
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
        return "update <group> (groups are set in config)";
    }

    @Override
    public List getCommandAliases()
    {
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args)
    {
        String url;
        World world = sender.getEntityWorld();

        if (!(world.isRemote)) {
            if (args.length == 0) {
                sender.addChatMessage(new ChatComponentText("Usage: /update <group> (groups are set in config)"));
            }
            for(int i=0;i< args.length; i++) {
                url = CGUpdater.updateLoc.get(args[i]);
                if (url == null) {
                    sender.addChatMessage(new ChatComponentText(args[i]+" was not found in the config."));
                } else {
                    if (!(url.endsWith("/"))) { url = url+"/"; }
                    url = url+"mission-control.list";
                    URL u;
                    try {
                        u = new URL(url);
                    } catch (MalformedURLException e) {
                        sender.addChatMessage(new ChatComponentText(args[i]+" URL is invalid."));
                        continue;
                    }
                    BufferedReader in;
                    try {
                        in = new BufferedReader(new InputStreamReader(u.openStream()));
                    } catch (IOException e) {
                        sender.addChatMessage(new ChatComponentText("Error while at mission control for " + args[i]));
                        continue;
                    }

                    String inputLine;
                    List<String> urls = new ArrayList<String>();
                    try {
                        while ((inputLine = in.readLine()) != null)
                            urls.add(inputLine);
                        in.close();
                    } catch (IOException e) { sender.addChatMessage(new ChatComponentText("(IO)Error while at mission control for " + args[i])); }
                    for (int y=0; y<urls.size(); y++) {
                        try {
                            String urlf;
                            if ((urls.get(y).startsWith("http://")) || (urls.get(y).startsWith("http://"))) {
                                urlf = urls.get(y); //Absolute URL
                            } else {
                                urlf = CGUpdater.updateLoc.get(args[i]) + urls.get(y); //Relative URL
                            }
                            FileUtils.copyURLToFile(new URL(urlf), new File(CGUpdater.saveLoc.get(args[i]) + "/" + urls.get(y)));
                        } catch (IOException ioe) {
                            sender.addChatMessage(new ChatComponentText("Error Downloading "+urls.get(y)));
                        }


                    }
                }

            }
        }
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
