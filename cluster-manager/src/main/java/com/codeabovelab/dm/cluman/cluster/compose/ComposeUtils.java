

package com.codeabovelab.dm.cluman.cluster.compose;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class ComposeUtils {

    public static File applicationPath(String root, String cluster, String app, String fileName, boolean deleteIfExists) {
        fileName = fileName == null ? "docker-compose.yml" : fileName;
        Path path = Paths.get(root, "compose", "clusters", cluster, "apps", app, fileName);
        return createFile(path, deleteIfExists);
    }

    private static void createDirs(File file) {
        file.getParentFile().mkdirs();
    }

    public static File clusterPath(String root, String cluster, String fileName) {
        Path path = Paths.get(root, "compose", "clusters", cluster, fileName);
        return createFile(path, true);
    }

    private static File createFile(Path path, boolean deleteIfExists) {
        File file = path.toFile();
        if (deleteIfExists) {
            try {
                Files.deleteIfExists(path);
            } catch (IOException e) {
                log.error("Can't delete file", e);
            }
        }
        createDirs(file);
        return file;
    }
}
