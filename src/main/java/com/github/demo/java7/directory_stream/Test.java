package com.github.demo.java7.directory_stream;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

    public static void main(String[] args) throws IOException {
        listFiles();
    }

    private static void listFiles() throws IOException {
        Path path = Paths.get("E:/java");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.txt")) {
            for (Path entry:stream) {
                System.out.println(entry);
            }
        }
    }
}
