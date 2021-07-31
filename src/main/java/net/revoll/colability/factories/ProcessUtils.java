package net.revoll.colability.factories;

import java.io.IOException;

public class ProcessUtils {
    public static Process runProcess(String command) throws IOException{
        try {
            return Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            throw e;
        }
    }
}
