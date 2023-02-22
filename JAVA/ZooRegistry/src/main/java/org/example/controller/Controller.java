package org.example.controller;

import org.example.controller.services.DirWalkService;
import org.example.controller.services.LoadAnimalsService;
import org.example.controller.services.ZooIndexService;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {
    private Path indexDirPath;
    String INDEX_DIR = "animals_data";
    ZooIndexService zis;

    public Controller() {
        walkRootPath(Path.of(System.getProperty("user.dir")));
        zis = new ZooIndexService(indexDirPath);
    }

    public void printAnimalList() {
        zis.toString();
    }

    private void walkRootPath(Path path) {
        indexDirPath = DirWalkService.search(path, INDEX_DIR);
        if ((indexDirPath == null)) {
            try {
                Files.createDirectory(Paths.get(path.toString(), INDEX_DIR));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


//        if (path.endsWith("animals_data")) {
//            this.indexDirPath = path;
//            return;
//        }
//        if (Files.isDirectory(path)) {
//            try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(path)) {
//                dirStream.forEach(this::walkRootPath);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
