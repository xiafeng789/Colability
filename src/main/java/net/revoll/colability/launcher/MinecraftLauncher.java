package net.revoll.colability.launcher;

import net.revoll.colability.tokens.JVMEnum;
import java.util.HashMap;

public class MinecraftLauncher extends AbstractLauncher {
    private String playerID = "Player";
    private String javaPath = "javaw";
    private long Memories = 1024L;
    private String LauncherName = "CML";
    private String LauncherVersion = "1.0beta";
    private String MinecraftPath = "C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Roaming\\.minecraft";
    private String versionNow = "null";



    public MinecraftLauncher(String name, String Minecraftpath){
        init();

    }

    @Override
    public boolean launch(String Version) {
        return false;
    }



    public void init(){
        loadJVMTokens();

    }

    @Override
    public void loadJVMTokens() {
        getJVMTokens().put(JVMEnum.MEMORIES,"-Xmx"+getMemories()+"m");
        getJVMTokens().put(JVMEnum.SYSTEM_INFO,"-Dos.name="+System.getProperty("os.name")+" -Dos.version="+System.getProperty("sun.os.patch.level"));
        getJVMTokens().put(JVMEnum.LAUNCH_NAME_VERSION,"-Dminecraft.launcher.brand="+getLauncherName()+" -Dminecraft.launcher.version="+getLauncherVersion());

        getJVMTokens().put(JVMEnum.LOG_CONFIG,"-Dlog4j.configurationFile="+getMinecraftPath()+"\\client-"+getVersionNow()+".xml");


    }





    @Override
    public void debug() {

    }

    @Override
    public void close() {

    }


    public String getVersionNow() {
        return versionNow;
    }

    public MinecraftLauncher setVersionNow(String versionNow) {
        this.versionNow = versionNow;
        return this;
    }

    public MinecraftLauncher setLauncherName(String launcherName) {
        LauncherName = launcherName;
        return this;
    }

    public MinecraftLauncher setLauncherVersion(String launcherVersion) {
        LauncherVersion = launcherVersion;
        return this;
    }

    public String getLauncherVersion() {
        return LauncherVersion;
    }

    public String getLauncherName() {
        return LauncherName;
    }

    public MinecraftLauncher setPlayerID(String playerID) {
        this.playerID = playerID;
        return this;
    }

    public MinecraftLauncher setJavaPath(String javaPath) {
        this.javaPath = javaPath;
        return this;
    }

    public MinecraftLauncher setMemories(long memories) {
        Memories = memories;
        return this;
    }

    public String getPlayerID() {
        return playerID;
    }

    public String getJavaPath() {
        return javaPath;
    }

    public long getMemories() {
        return Memories;
    }
    public String getMinecraftPath() {
        return MinecraftPath;
    }

    public MinecraftLauncher setMinecraftPath(String minecraftPath) {
        MinecraftPath = minecraftPath;
        return this;
    }


    @Override
    public HashMap<JVMEnum, String> getJVMTokens() {

        return null;
    }
}
