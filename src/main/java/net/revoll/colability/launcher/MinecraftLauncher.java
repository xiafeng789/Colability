package net.revoll.colability.launcher;

import net.revoll.colability.downloader.MiniDown;
import net.revoll.colability.i18n.struct.ChineseLanguageConfig;
import net.revoll.colability.i18n.struct.SimpleLanguage;
import net.revoll.colability.tokens.JVMEnum;
import net.revoll.colability.utils.LauncherFileUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

/**
 * @author White_cola
 * Colability main class.
 *
 * Project by AGPL V3 License.
 */
public class MinecraftLauncher extends AbstractLauncher {
    private static MinecraftLauncher instance;
    private SimpleLanguage language;

    private String playerID = "Player";

    private String javaPath = "javaw";
    private long Memories = 1024L;
    private String LauncherName = "CML";
    private String LauncherVersion = "1.0beta";
    private String MinecraftPath = "C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Roaming\\.minecraft";
    private String versionNameNow = "null";



    public MinecraftLauncher(){
        init();

    }

    public void init(){
        loadJVMTokens();
        setLanguage();
    }



    @Override
    public void launch(){
        new Thread(()->{
            MiniDown miniDown = MiniDown.getMiniDownInstace();
            if(!LauncherFileUtils.checkFilesOfVersion(versionNameNow,miniDown)){
                LauncherFileUtils.downloadFilesOfVersionTillDone(versionNameNow,miniDown);
            }

            while(!MiniDown.getMiniDownInstace().getDownloadTasks().isEmpty()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            try {
                JVMLauncher.getInstance(javaPath).launchByJVMFromProcess(this.getInstance());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();





    }






    @Override
    public void loadJVMTokens() {
        getJVMTokens().put(JVMEnum.MEMORIES,"-Xmx"+getMemories()+"m");
        getJVMTokens().put(JVMEnum.SYSTEM_INFO,"-Dos.name="+System.getProperty("os.name")+" -Dos.version="+System.getProperty("sun.os.patch.level"));
        getJVMTokens().put(JVMEnum.LAUNCH_NAME_VERSION,"-Dminecraft.launcher.brand="+getLauncherName()+" -Dminecraft.launcher.version="+getLauncherVersion());

        getJVMTokens().put(JVMEnum.LOG_CONFIG,"-Dlog4j.configurationFile="+getMinecraftPath()+"\\client-"+ getVersionNameNow()+".xml");


    }

    // default or Chinese
    public void setLanguage(){
        if(Locale.getDefault().getLanguage().contains("zh")){
            language = new SimpleLanguage("Chinese");
            return;
        }

        language = new SimpleLanguage("default");
    }



    @Override
    public void debug() {

    }

    @Override
    public void close() {

    }


    public static MinecraftLauncher getInstance() {
        if(instance == null){
            instance = new MinecraftLauncher();
        }
        return instance;
    }

    public String getVersionNameNow() {
        return versionNameNow;
    }

    public MinecraftLauncher setVersionNameNow(String versionNameNow) {
        this.versionNameNow = versionNameNow;
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
        return JVMTokens;
    }
}
