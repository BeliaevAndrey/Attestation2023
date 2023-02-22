package org.example.controller.services;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DirWalkService {

    private List<Path> pathsList;

    public void walkPath(Path path) {
        if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(path)) {
                dirStream.forEach(subPath -> {
                    if (Files.isDirectory(subPath)) {
                        pathsList.add(subPath);
                        walkPath(subPath);
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Path search(Path path, String searched) {
        DirWalkService dws = new DirWalkService();
        dws.pathsList = new ArrayList<>();
        dws.walkPath(path);
        for (Path p : dws.pathsList) {
            if (p.endsWith(searched))
                return p;
        }
        return null;
    }

    public static void main(String[] args) {
        String INDEX_DIR = "animals_data";
        Path testing = DirWalkService.search(
                Path.of(System.getProperty("user.dir")), INDEX_DIR
        );
        System.out.println(testing);
    }
}
