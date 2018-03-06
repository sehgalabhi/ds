package com.generics.general;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by asehgal on 10/5/2017.
 */
public class ReflectionForGenerics {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> k = Class.forName("com.generics.general.Cell");
        toString(k);
        toGenericString(k);
    }

    private static void toString(Class<?> k) {
        System.out.println(k + " >> toString");
        for (Field field:
             k.getDeclaredFields()) {
            System.out.println(field.toString());
        }

        for (Constructor c:
             k.getDeclaredConstructors()) {
            System.out.println(c.toString());
        }

        for (Method m: k.getDeclaredMethods()
             ) {
            System.out.println(m.toString());
        }
    }

    private static void toGenericString(Class<?> k) {
        System.out.println(k + " >> toGenericString");
        for (Field field:
                k.getDeclaredFields()) {
            System.out.println(field.toGenericString());
        }

        for (Constructor c:
                k.getDeclaredConstructors()) {
            System.out.println(c.toGenericString());
        }

        for (Method m: k.getDeclaredMethods()
                ) {
            System.out.println(m.toGenericString());
        }


    }

}

class Cell<E> {

    private E value;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Cell(E value) {
        this.value = value;
    }

    public <T> Cell<T> copy(Cell<T> cell) {
        return new Cell<T>(cell.getValue());
    }
}
