package com.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PathsTests {

    public static void main(String[] args) throws IOException {
        new PathsTests().test();
    }

    private void test() throws IOException {
        Path path = Paths.get("D:\\Agile");
        System.out.println(path);

        System.out.println(Files.isDirectory(path));

        Path helloDirectory = Paths.get("D:\\Agile", "hello", "out", "0717", "112T0.004.ASC");
        System.out.println(helloDirectory);
        System.out.println(Files.isDirectory(helloDirectory));

        System.out.println(Files.isWritable(path));
        System.out.println(Files.exists(helloDirectory) );

        if(!Files.exists(helloDirectory)) {
            Files.createDirectories(helloDirectory.getParent());
            Files.createFile(helloDirectory);
        }

        Files.deleteIfExists(helloDirectory);

        System.out.println(Files.exists(helloDirectory) );

    /*    BufferedWriter outputWriter = Files.newBufferedWriter(helloDirectory, StandardOpenOption.TRUNCATE_EXISTING);

        outputWriter.write("hellos");
        outputWriter.flush();*/
    }
}
