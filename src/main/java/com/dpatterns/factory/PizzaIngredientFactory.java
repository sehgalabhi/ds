package com.dpatterns.factory;

/**
 * Created by asehgal on 7/10/2017.
 */
public interface PizzaIngredientFactory {

    Dough createDough();

    Bread createBread();
}
