package com.java8inaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class MethodReferenceAndLambdas {

    public static void main(String[] args) throws IOException {
        new MethodReferenceAndLambdas().test();
    }

    private void test() throws IOException {
        testFileHidden();
        testFilterApples();
        testBufferedReaderProcessor();
        testConstructor();
        testChainedComparison();
        }

    private void testFileHidden() {
        System.out.println(new File(".").getAbsolutePath());
        new File(".").listFiles(file -> file.isHidden());
        Arrays.stream(new File(".").listFiles(file -> !file.isHidden())).map(file -> file.getName()).forEach(System.out::println);

        Predicate<File> filePredicate = File::isHidden;
        Arrays.stream(new File(".").listFiles(File::isHidden)).map(file -> file.getName()).forEach(System.out::println);


    }

    private void testFilterApples() {
        List<Apple> apples = Arrays.asList(new Apple("gr", "green", 20),
                new Apple("re", "red", 30),
                new Apple("or", "orange", 40));

        System.out.println(apples);

        List<Apple> greenApples = filterApples(apples, apple -> apple.color.equals("green"));
        System.out.println(greenApples);

        List<Apple> heavyApples = filterApples(apples, Apple::isHeavy);
        System.out.println(heavyApples);


        //apples.sort((apple1, apple2) -> apple1.getName().compareTo(apple2.getName()));
        apples.sort(comparing(Apple::getName));
        System.out.println(apples);
    }

    private static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> applePredicate) {
        return apples.stream().filter(applePredicate).collect(Collectors.toList());

    }

    private void testBufferedReaderProcessor() throws IOException {
        processFile(br -> br.readLine() + br.readLine()+ br.readLine());
    }

    private void processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./pom.xml"))) {
            System.out.println(bufferedReaderProcessor.process(bufferedReader));
        }
    }

    private void testConstructor() {
        BiFunction<String, String, Apple> biConstructor = Apple::new;
        System.out.println(biConstructor.apply("ye", "yellow"));


    }

    private void testChainedComparison() {
        List<Apple> apples = Arrays.asList(new Apple("gr", "green", 20),
                new Apple("re", "red", 30),
                new Apple("re1", "red", 40),
                new Apple("or", "orange", 40));

        apples.sort(comparing(Apple::getColor).reversed().thenComparing(Apple::getWeight));
        System.out.println(apples);
    }
}
