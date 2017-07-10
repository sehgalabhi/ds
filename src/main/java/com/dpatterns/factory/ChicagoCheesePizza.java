package com.dpatterns.factory;

/**
 * Created by asehgal on 7/10/2017.
 */
public class ChicagoCheesePizza implements Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public ChicagoCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void makePizza() {
        pizzaIngredientFactory.createBread();
        pizzaIngredientFactory.createDough();
    }
}
