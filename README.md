# CGUpdater

A Minecraft 1.7.10 mod to download files from the internet.
You can also view a working example at https://github.com/inky2013/inky2013.github.io/tree/master/modpacks/thinktank

The purpose of this mod is to download files such as config or minetweaker scripts from a web server. This means files can be updated without having to update the modpack. This mod can be especially useful if you own a server maintained by multiple people who need a quick and easy way to push updates to the config or recipes without forcing users to update the modpack or even leave the server.

#####Commands:
- ```/showloadedupdates``` Prints a list of each script available to download.
- ```/update <group>``` group refers to a line in updates.list.
- ```/reloadupdates``` reloads the ```updates.list``` file from config
- ```/directupdate <save-directory> <URL>``` downloads the file at the URL to the save-directory

The ```/update``` command can update multiple groups at once. Each group can be added as an additional argument.
Eg: ```/update <group1> <group2> <group3>```

#####Adding scripts to update:
Open ```updates.list``` in the config folder and write:<br/>
<code>&lt;command-name&gt;;&lt;install-folder&gt;;&lt;url&gt;</code><br/>
The install folder is relative to the server/minecraft install directory.
The URL must have the protocol (eg: 'http://example.com/modpack/scripts')<br>
so for example you could have <code>recipes;scripts;example.com/example/</code>
#####Setting up the downloads online:
- Make a new file called <code>mission-control.list</code> in the directory specified in <code>updates.list</code> (eg: 'http://example.com/example/mission-control.list')
- Place each file you need to download in the same directory as <code>mission-control.list</code> (eg: 'http://example.com/example/recipes.zs')
- In <code>mission-control.list</code> write the name of each file on a new line.

#####mission-control.list example:
```
recipes.zs
furnace.zs
http://other-website.com/modpack/tweaks.zs
```

