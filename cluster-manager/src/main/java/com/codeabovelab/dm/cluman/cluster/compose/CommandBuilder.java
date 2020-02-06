

package com.codeabovelab.dm.cluman.cluster.compose;

public final class CommandBuilder {

    public static String launchTask(String fileName) {
        return prepareCommand(fileName) + " up -d";
    }

    public static String pullImages(String fileName) {
        return prepareCommand(fileName) + " pull";
    }

    public static String stopTask(String fileName) {
        return prepareCommand(fileName) + " stop";
    }

    public static String downTask(String fileName) {
        return prepareCommand(fileName) + " down";
    }

    public static String getContainerIds(String fileName) {
        return prepareCommand(fileName) + " ps -q";
    }

    /**
     * prepare command line
     * @param fileName
     * @return
     */
    private static String prepareCommand(String fileName) {
        return "docker-compose -f " + fileName;
    }

}
