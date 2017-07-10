package com.dpatterns.factory;

/**
 * Created by asehgal on 7/10/2017.
 */
public class NYCheesePizza implements Pizza {

    public NYCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        pizzaIngredientFactory = pizzaIngredientFactory;
    }

    private PizzaIngredientFactory pizzaIngredientFactory;


    @Override
    public void makePizza() {
        pizzaIngredientFactory.createBread();
        pizzaIngredientFactory.createDough();
    }
}
