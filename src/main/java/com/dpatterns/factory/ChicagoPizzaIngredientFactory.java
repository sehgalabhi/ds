package com.dpatterns.factory;

/**
 * Created by asehgal on 7/10/2017.
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory{


    @Override
    public Dough createDough() {
        return new ChicagoDough();
    }

    @Override
    public Bread createBread() {
        return new ChicagoBread();
    }
}
