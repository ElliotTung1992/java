package com.github.demo.java7.watch_service;

import java.io.IOException;
import java.nio.file.*;

public class Test {

    public void calculate() throws IOException, InterruptedException {
        WatchService service = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("E:/java").toAbsolutePath();
        path.register(service, StandardWatchEventKinds.ENTRY_MODIFY);
        while (true) {
            WatchKey key = service.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                Path createdPath = (Path) event.context();
                createdPath = path.resolve(createdPath);
                long size = Files.size(createdPath);
                System.out.println(createdPath + " ==> " + size);
            }
            key.reset();
        }
    }

    public static void main(String[] args) throws Throwable {
        Test wc = new Test();
        wc.calculate();
    }
}
