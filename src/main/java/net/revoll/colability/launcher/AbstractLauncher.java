package net.revoll.colability.launcher;

import net.revoll.colability.interfaces.IJVM;
import net.revoll.colability.interfaces.ILaunch;
import net.revoll.colability.tokens.JVMEnum;

import java.util.HashMap;

public abstract class AbstractLauncher implements ILaunch,IJVM {


    @Override
    public abstract HashMap<JVMEnum, String> getJVMTokens();

    @Override
    public abstract boolean launch(String Version);

    public abstract void loadJVMTokens();
}
