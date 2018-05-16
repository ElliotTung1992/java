package com.github.demo.java7.switch_string;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Test2 {

    public static void main(String[] args) throws IOException {
        String path = "E:/java";
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path1 = Paths.get(path);

        path1.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_CREATE);

        Thread thread = new Thread(() -> {
            while (true){
                try {
                    WatchKey take = watchService.take();
                    List<WatchEvent<?>> watchEvents = take.pollEvents();
                    for (WatchEvent<?> watchEvent:watchEvents) {
                        System.out.println("["+path+"/"+watchEvent.context()+"]文件发生了["+watchEvent.kind()+"]事件");
                    }
                    take.reset();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.setDaemon(false);
        thread.start();

        // 增加jvm关闭的钩子来关闭监听
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                watchService.close();
            } catch (Exception e) {
            }
        }));
    }
}
