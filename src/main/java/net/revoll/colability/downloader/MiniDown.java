package net.revoll.colability.downloader;

import java.util.concurrent.ConcurrentHashMap;

public class MiniDown {
    private static MiniDown miniDownInstace;
    private ConcurrentHashMap<String,Integer> downloadTasks = new ConcurrentHashMap<>();

    public static MiniDown getMiniDownInstace(){
        if(miniDownInstace ==null){
            miniDownInstace = new MiniDown();
        }
        return miniDownInstace;
    }

    public ConcurrentHashMap<String, Integer> getDownloadTasks() {
        return downloadTasks;
    }

    public void setDownloadTasks(ConcurrentHashMap<String, Integer> downloadTasks) {
        this.downloadTasks = downloadTasks;
    }

    public MiniDown addTask(String taskName,Integer progress){
        downloadTasks.put(taskName,progress);
        return this;
    }
}
