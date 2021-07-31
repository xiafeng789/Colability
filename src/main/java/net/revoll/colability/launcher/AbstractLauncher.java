package net.revoll.colability.launcher;

import net.revoll.colability.interfaces.IJVM;
import net.revoll.colability.interfaces.ILaunch;

public abstract class AbstractLauncher implements ILaunch,IJVM {


    public abstract void loadJVMTokens();
}
