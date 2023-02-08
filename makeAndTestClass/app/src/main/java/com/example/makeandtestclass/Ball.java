package com.example.makeandtestclass;

public class Ball implements AutoCloseable {

    private boolean popped;
    private String color;
    private float bounceHeightInFeet;
    private double weightInGrams;

    Ball(String color, double weightInGrams, float bounceHeightInFeet, boolean popped) {
        this.color = color;
        this.weightInGrams = weightInGrams;
        this.bounceHeightInFeet = bounceHeightInFeet;
        this.popped = popped;
    }

    Ball(double weightInGrams) {
        this("black", weightInGrams, 2.5f, false);
    }

    Ball(float bounceHeightInFeet) {
        this("black", 150.00d, bounceHeightInFeet, false);
    }

    Ball(String color) {
        this(color, 150.00d, 2.5f, false);
    }

    Ball() {
        this("black", 150.0d, 2.5f, false);
    }

    public void close() {
        System.out.println("closing ball " + this + " color " + color);
    }

    public boolean isPopped() {
        return popped;
    }

    public void setPopped(boolean popped) {
        this.popped = popped;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getBounceHeightInFeet() {
        return bounceHeightInFeet;
    }

    public void setBounceHeightInFeet(float bounceHeightInFeet) {
        this.bounceHeightInFeet = bounceHeightInFeet;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(double weightInGrams) {
        if (weightInGrams > 0) {
            this.weightInGrams = weightInGrams;
        } else {
            throw new IllegalArgumentException("weight must be positive");
        }
    }
}
