package org.example.controller;

import org.example.controller.services.LoadAnimalsService;
import org.example.controller.services.ZooIndexService;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Controller {
    private Path indexDirPath;


    Controller() {
        walkRootPath(Path.of(System.getProperty("user.dir")));
        LoadAnimalsService las = new LoadAnimalsService(indexDirPath);


    }

    private void walkRootPath(Path path) {
        if (path.endsWith("animals_data")) {
            this.indexDirPath = path;
            return;
        }
        if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(path)) {
                dirStream.forEach(this::walkRootPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
