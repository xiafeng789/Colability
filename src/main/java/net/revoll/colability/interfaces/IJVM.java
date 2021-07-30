package net.revoll.colability.interfaces;

import net.revoll.colability.tokens.JVMEnum;

import java.util.HashMap;

public interface IJVM {
    HashMap<JVMEnum,String> JVMTokens = new HashMap<>();
    HashMap<JVMEnum,String> getJVMTokens();
}
