package com.dpatterns.factory;

/**
 * Created by asehgal on 7/10/2017.
 */
public abstract class PizzaStore {

    public void orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.makePizza();
    }

    public abstract Pizza createPizza(String type);
}
