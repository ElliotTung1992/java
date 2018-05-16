package com.github.demo.java7.try_with_resources;

import java.io.IOException;

public class Test2 {

    public static void main(String[] args) {

    }

    private static void test1(String zipFileName,
                              String outputFileName) throws IOException {
        java.nio.charset.Charset charset =
                java.nio.charset.StandardCharsets.US_ASCII;
        java.nio.file.Path outputFilePath =
                java.nio.file.Paths.get(outputFileName);

        try (
            java.util.zip.ZipFile zf =
                    new java.util.zip.ZipFile(zipFileName);
            java.io.BufferedWriter writer =
                    java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
        ) {
            // Enumerate each entry
            for (java.util.Enumeration entries =
                 zf.entries(); entries.hasMoreElements();) {
                // Get the entry name and write it to the output file
                String newLine = System.getProperty("line.separator");
                String zipEntryName =
                        ((java.util.zip.ZipEntry)entries.nextElement()).getName() +
                                newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }
    }
}
