package com.dpatterns.factory;

/**
 * Created by asehgal on 7/10/2017.
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {


    @Override
    public Dough createDough() {
        return new NYDough();
    }

    @Override
    public Bread createBread() {
        return new NYBread();
    }
}
