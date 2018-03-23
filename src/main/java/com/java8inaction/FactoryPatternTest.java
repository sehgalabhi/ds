package com.java8inaction;

public class FactoryPatternTest {
    public static void main(String[] args) {
        new FactoryPatternTest().test();
    }

    private void test() {
    }
}

class ProductFactory{
    static Product createProduct(String name){
        return null;
    }
}


class Product{

}