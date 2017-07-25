package com.dpatterns.factory;

/**
 * Created by asehgal on 7/10/2017.
 */
public class PizzaSimulator {

    public static void main(String[] args) {
        new PizzaSimulator().test();
    }

    private void test() {
        PizzaStore pizzaStore = new NYPizzaStore();
       // pizzaStore.orderPizza();
    }
}
