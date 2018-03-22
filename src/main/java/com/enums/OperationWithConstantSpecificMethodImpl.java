package com.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum OperationWithConstantSpecificMethodImpl {

    PLUS("+") {
        double apply(double a, double b) {
            return a + b;
        }
    },
    MINUS("-") {
        double apply(double a, double b) {
            return a - b;
        }
    },
    MULT("*") {
        double apply(double a, double b) {
            return a * b;
        }
    },
    DIVIDE("%") {
        double apply(double a, double b) {
            return a / b;
        }
    };

    private final String symbol;

    OperationWithConstantSpecificMethodImpl(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    //as toStringOverriden, to use valueOf, override fromString method too

    private static final Map<String, OperationWithConstantSpecificMethodImpl> stringToEnum = new HashMap<>();

    static {
        Arrays.stream(OperationWithConstantSpecificMethodImpl.values()).forEach(operation -> stringToEnum.put(operation.symbol, operation));
    }

    public static OperationWithConstantSpecificMethodImpl fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    abstract double apply(double x, double y);
}


class Test {
    public static void main(String[] args) {
        new Test().test();
    }

    private void test() {
        double x = Double.parseDouble("1");
        double y = Double.parseDouble("2");

        Arrays.stream(OperationWithConstantSpecificMethodImpl.values()).forEach((t) -> {
            System.out.printf("%f %s %f = %f ", x, t, y, t.apply(x, y));
        });
        OperationWithConstantSpecificMethodImpl operationWithConstantSpecificMethod = OperationWithConstantSpecificMethodImpl.fromString("+");
        System.out.println(operationWithConstantSpecificMethod.name());

    }
}