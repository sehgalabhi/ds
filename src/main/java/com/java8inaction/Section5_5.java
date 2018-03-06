package com.java8inaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Section5_5 {

    static Trader raoul = new Trader("Raoul", "Cambridge");
    static Trader mario = new Trader("Mario", "Milan");
    static Trader alan = new Trader("Alan", "Cambridge");
    static Trader brian = new Trader("Brian", "Cambridge");

    static List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

    static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {
        new Section5_5().test();
    }

    private void test() {
        testAllTx2011Sorted();
        testUniqueCitiesTraderWorking();
        testTradersFromCambridge();
        testAllTradersNameSorted();
        testAnyTraderInMilan();
        printTransactionsFromTradersinCambrdige();
        testTxHighestValue();
        testTxWithSmallestValue();
        
    }

    private void testTxWithSmallestValue() {
        transactions.stream().reduce((transaction, transaction2) -> (transaction.getValue() < transaction2.getValue() ?transaction:transaction2)).ifPresent(System.out::println);
    }

    private void testTxHighestValue() {
        transactions.stream().map(Transaction::getValue).reduce(Integer::max).ifPresent(System.out::println);
    }

    private void printTransactionsFromTradersinCambrdige() {
        System.out.println(traders.stream().filter(trader -> trader.getCity() == "Cambridge").flatMap(trader -> {
            Stream<Transaction> transactionStream = transactions.stream().filter(transaction -> transaction.getTrader() == trader);
            return transactionStream;
        }).collect(toList()));

        System.out.println(transactions.stream().filter(transaction -> transaction.getTrader().getCity() == "Cambridge").collect(toList()));
    }

    private void testAnyTraderInMilan() {
        System.out.println(traders.stream().anyMatch(trader -> trader.getCity() == "Milan"));
    }

    private void testAllTx2011Sorted() {
        System.out.println(transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(toList()));
    }

    private void testUniqueCitiesTraderWorking() {
        System.out.println(traders.stream().map(Trader::getCity).distinct().collect(toList()));
    }

    private void testTradersFromCambridge() {
        System.out.println(traders.stream().filter(trader -> trader.getCity() == "Cambridge").sorted(Comparator.comparing(Trader::getName)).collect(toList()));
    }

    private void testAllTradersNameSorted() {
        System.out.println(traders.stream().map(Trader::getName).sorted().reduce("", (first, second) -> first+second));
        System.out.println(traders.stream().map(Trader::getName).collect(Collectors.joining()));
    }
}


class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}


class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "{" + this.trader + ", " +
                "year: " + this.year + ", " +
                "value:" + this.value + "}";
    }
}