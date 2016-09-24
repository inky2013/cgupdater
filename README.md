# CGUpdater

A Minecraft 1.7.10 mod to download files from the internet.

#####Commands:
- ```/showloadedupdates``` Prints a list of each script available to download.
- ```/update <script>``` Updates the script.

#####Adding scripts to update:
Open ```updates.list``` in the config folder and write:<br/>
<code>&lt;command-name&gt;=&lt;install-folder&gt;=&lt;url&gt;</code><br/>
The install folder is relative to the server/minecraft install directory.
The URL must have the protocol (eg: 'http://example.com/modpack/scripts')
#####Setting up the downloads online:
- Make a new file called <code>mission-control.list</code> in the directory specified in <code>updates.list</code> (eg: 'http://example.com/modpack/scripts/mission-control.list')
- Place each file you need to download in the same directory as <code>mission-control.list</code> (eg: 'http://example.com/modpack/scripts/recipes.zs')
- In <code>mission-control.list</code> write the name of each file on a new line.

#####mission-control.list example:
<code>recipes.zs<br/>furnace.zs<br/>tweaks.zs</code>
