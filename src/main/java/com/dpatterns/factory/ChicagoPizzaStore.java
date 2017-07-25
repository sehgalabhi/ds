package com.dpatterns.factory;

/**
 * Created by asehgal on 7/10/2017.
 */
public class ChicagoPizzaStore extends PizzaStore {

    private Pizza pizza;

    public Pizza createPizza(String type) {
        if ("cheese".equalsIgnoreCase(type)) {
       //     pizza = new ChicagoCheesePizza();
        } else if ("veg".equalsIgnoreCase(type)) {
         //   pizza = new ChicagoVegPizza();
        }
        return pizza;
    }
}
