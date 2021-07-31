package net.revoll.colability.interfaces;

import net.revoll.colability.launcher.AbstractLauncher;

public interface ILaunch {
    String CORE_ID = "Colability";
    String CORE_Version = "1.0beta";
    void launch();
    void debug();
    void close();

}
