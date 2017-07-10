package com.dpatterns.factory;

/**
 * Created by asehgal on 7/10/2017.
 */
public class NYVegPizza implements Pizza {
    private PizzaIngredientFactory pizzaIngredientFactory;

    public NYVegPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void makePizza() {
        pizzaIngredientFactory.createBread();
        pizzaIngredientFactory.createDough();
    }
}
