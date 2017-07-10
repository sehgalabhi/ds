package com.dpatterns.factory;

/**
 * Created by asehgal on 7/10/2017.
 */
public class NYPizzaStore extends PizzaStore {

    private Pizza pizza;

    private NYPizzaIngredientFactory nyPizzaIngredientFactory = new NYPizzaIngredientFactory();

    public Pizza createPizza(String type) {
        if ("cheese".equalsIgnoreCase(type)) {
            pizza = new NYCheesePizza(nyPizzaIngredientFactory);
        } else if ("veg".equalsIgnoreCase(type)) {
            pizza = new NYVegPizza(nyPizzaIngredientFactory);
        }
        return pizza;
    }
}
