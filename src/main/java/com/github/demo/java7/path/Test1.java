package com.github.demo.java7.path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Test1 {

    public static void main(String[] args) throws IOException {

//        test1();

//        test2();

//        test3();

//        test4();

//        test5();

//        test6();

//        test7();

//        test8();

        test9();
    }

    private static void test9() throws IOException {
        Path zip = Paths.get("E:/java/test.txt");
        System.out.println(Files.getLastModifiedTime(zip));
        System.out.println(Files.size(zip));
        System.out.println(Files.isSymbolicLink(zip));
        System.out.println(Files.isDirectory(zip));
        System.out.println(Files.readAttributes(zip, "*"));
    }

    private static void test8() throws IOException {
        long copy = Files.copy(Paths.get("E:/java/test.txt"), System.out);
        System.out.println(copy);

        Files.copy(Paths.get("E:/java/test.txt"), Paths.get("E:/java/test2.txt"));
        Files.copy(Paths.get("E:/java/test.txt"), Paths.get("E:/java/test3.txt"), StandardCopyOption.REPLACE_EXISTING);

        long copy1 = Files.copy(System.in, Paths.get("E:/java/test.txt"), StandardCopyOption.REPLACE_EXISTING);
        System.out.println(copy1);
    }

    private static void test7() throws IOException {
        Path startingDir = Paths.get("E:/java");
        List<Path> result = new LinkedList<Path>();
        Files.walkFileTree(startingDir, new FindJavaVisitor(result));
        System.out.println("result.size()=" + result.size());
    }

    private static class FindJavaVisitor extends SimpleFileVisitor<Path> {

        private List<Path> result;

        public FindJavaVisitor(List<Path> result){
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            String filePath = file.toFile().getAbsolutePath();
//            filePath.matches(".*_[1|2]{1}\\.(?i)(jpg|jpeg|gif|bmp|png|txt)")
            if(true){
                try {
                    Files.deleteIfExists(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                result.add(file.getFileName());
            } return FileVisitResult.CONTINUE;
        }
    }

    private static void test6() throws IOException {
        try (Stream<Path> list = Files.list(Paths.get("E:/java"))) {
            Iterator<Path> iterator = list.iterator();
            while (iterator.hasNext()){
                Path next = iterator.next();
                System.out.println(next);
            }
        }
    }

    private static void test5() throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("E:/java/test.txt"), StandardCharsets.UTF_8)) {
            bufferedWriter.write("钢铁侠111");
        }
    }

    private static void test4() throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("E:/java/test.txt"),  StandardCharsets.UTF_8)) {
            String str = null;
            while ((str = bufferedReader.readLine()) != null){
                System.out.println(str);
            }
        }
    }

    private static void test3() throws IOException {
        Path path = Paths.get("E:/java/java2/java3");
        if(!Files.exists(path)){
            Files.createDirectories(path);
//            Files.createFile(path);
        }
    }

    private static void test2() {
        File file = new File("E:/java");
        Path path = file.toPath();
        path.toFile();
        path.toUri();
    }

    private static void test1() {

        Path path1 = Paths.get("E:/", "java");

        Path path2 = Paths.get("E:/java");

        URI uri = URI.create("file:///E:/java");
        Path path3 = Paths.get(uri);

        Path path4 = FileSystems.getDefault().getPath("E:/java", "text.txt");
    }
}
