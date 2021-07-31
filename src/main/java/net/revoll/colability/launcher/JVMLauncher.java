package net.revoll.colability.launcher;

import net.revoll.colability.factories.ProcessUtils;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

public class JVMLauncher {
    private static JVMLauncher instance;
    String javaPath;
    public CopyOnWriteArrayList<Process> processes = new CopyOnWriteArrayList<>();

    @Deprecated
    public JVMLauncher(String javaPath){
        this.javaPath = javaPath;
    }

    public static JVMLauncher getInstance(String javaPath) {
        if(instance==null){
            instance = new JVMLauncher(javaPath);
        }
        return instance;
    }

    public void launchByJVMFromProcess(MinecraftLauncher minecraftLauncher) throws IOException{
        StringBuilder sbu = new StringBuilder();
        for(String arg : minecraftLauncher.getJVMTokens().values()){
            sbu.append(" "+arg);
        }

        // todo

        Process process = ProcessUtils.runProcess(javaPath+" "+sbu.toString());
        processes.add(process);
    }
}
