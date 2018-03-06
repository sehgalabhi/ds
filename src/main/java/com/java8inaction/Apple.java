package com.java8inaction;

import java.util.Objects;

public class Apple {


    public Apple(String name, String color, int weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public Apple(String name, String color) {
        this.name = name;
        this.color = color;
        this.weight=20;
    }

    String name;

    String color;

    int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isHeavy(){
        return this.weight > 20;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return weight == apple.weight &&
                Objects.equals(name, apple.name) &&
                Objects.equals(color, apple.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, color, weight);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
