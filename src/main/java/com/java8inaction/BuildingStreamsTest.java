package com.java8inaction;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildingStreamsTest {
    public static void main(String[] args) throws IOException {
        new BuildingStreamsTest().test();
    }

    private void test() throws IOException {
        testStreamsFromValues();
        testStreamsFromArrays();
        testStreamFromFiles();
        testStreamFromFunctionIterateInfiniteStreams();
        testStreamFromFunctionGenerateInfiniteStreams();
    }

    private void testStreamFromFunctionGenerateInfiniteStreams() {
        System.out.println(Stream.generate(Math::random).limit(10).collect(Collectors.toList()));
    }

    private void testStreamFromFunctionIterateInfiniteStreams() {
        System.out.println(Stream.iterate(0, n -> n + 2).limit(10).collect(Collectors.toList()));
    }


    private void testStreamFromFiles() throws IOException {
        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("./pom.xml"), Charset.defaultCharset())){
            Stream<String> stringStream = lines.map(line -> line.split(" ")).flatMap(Arrays::stream);
            System.out.println(stringStream.distinct().map(d -> 1).count());
        }

    }

    private void testStreamsFromArrays() {
        String[] arr = {"Java8", "Lambdas", "In", "Action"};

        Stream<String> stream = Arrays.stream(arr);
        System.out.println(stream.map(String::toUpperCase).collect(Collectors.toList()));
    }

    private void testStreamsFromValues() {
        Stream<String> java8 = Stream.of("Java8", "Lambdas", "In", "Action");
        System.out.println(java8.map(String::toUpperCase).collect(Collectors.toList()));
        Stream<Object> empty = Stream.empty();
    }
}
