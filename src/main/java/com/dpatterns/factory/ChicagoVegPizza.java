package com.dpatterns.factory;

/**
 * Created by asehgal on 7/10/2017.
 */
public class ChicagoVegPizza implements Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public ChicagoVegPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void makePizza() {
        pizzaIngredientFactory.createDough();
        pizzaIngredientFactory.createBread();
    }
}
