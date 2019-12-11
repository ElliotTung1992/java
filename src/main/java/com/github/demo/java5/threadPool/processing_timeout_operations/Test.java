package com.github.demo.java5.threadPool.processing_timeout_operations;

import lombok.extern.java.Log;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用线程池处理超时操作
 */
@Log
public class Test {

    private static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*2);

    public static void main(String[] args) {

        log.info(Runtime.getRuntime().availableProcessors() + "");

        AtomicReference<String> message = new AtomicReference<>("");

        Callable callable = () -> {
            try {
                message.set("数据");
                TimeUnit.SECONDS.sleep(7);
            } catch (InterruptedException e) {
                System.out.println("任务被中断。");
                return "error";
            }
            return "OK";
        };

        Future<String> future = executorService.submit(callable);

        try {
            String s = future.get(6, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            log.info("处理超时！！！");
            System.out.println(message.get());
            e.printStackTrace();
        }
    }

}
