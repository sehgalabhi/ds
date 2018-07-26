package com.files;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileIOTest {

    public static void main(String[] args) throws IOException {
//        testFileInputStream();
//        testBufferedInputStream();
//        testDirectBuffer();


        List<Path> collect = Files.list(Paths.get("D:\\Agile\\hello\\in")).collect(Collectors.toList());
        Path sourcePath = Paths.get("D:\\Agile\\hello\\in", "112T0.003.ASC");
        Path targetPath = Paths.get("D:\\Agile\\hello\\archive");
        Files.move(sourcePath, targetPath.resolve(sourcePath.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        System.out.println(collect.size());
    }

    private static void testDirectBuffer() {
        try {
            long start = System.currentTimeMillis();

            FileInputStream fis = new FileInputStream("C:\\Users\\asehgal\\Desktop\\Rambus - TSP - Product Description - v2.2.pdf");
            byte buf[] = new byte[2048];
            int cnt = 0;
            int n;
            while ((n = fis.read(buf)) != -1) {
                for (int i = 0; i < n; i++) {
                     cnt++;
                }
            }
            fis.close();
            System.out.println((System.currentTimeMillis() - start) / 1000);

            System.out.println(cnt);
        } catch (IOException e) {
            System.err.println(e);
        }


    }

    private static void testBufferedInputStream() {
        try {
            long start = System.currentTimeMillis();

            FileInputStream fis = new FileInputStream("C:\\Users\\asehgal\\Desktop\\Rambus - TSP - Product Description - v2.2.pdf");
            BufferedInputStream bis = new BufferedInputStream(fis);
            int cnt = 0;
            int b;
            while ((b = bis.read()) != -1) {
                cnt++;
            }
            bis.close();
            System.out.println((System.currentTimeMillis() - start) / 1000);

            System.out.println(cnt);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private static void testFileInputStream() {
        try {

            long start = System.currentTimeMillis();
            FileInputStream fis = new FileInputStream("C:\\Users\\asehgal\\Desktop\\Rambus - TSP - Product Description - v2.2.pdf");
            int cnt = 0;
            int b;
            while ((b = fis.read()) != -1) {
                cnt++;
            }
            fis.close();
            System.out.println((System.currentTimeMillis() - start) / 1000);
            System.out.println(cnt);

        } catch (IOException e) {
            System.err.println(e);
        }

    }


}



