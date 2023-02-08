package com.example.makeandtestclass;

import static org.junit.Assert.*;

import org.junit.Test;

public class BallTest {

    @Test
    public void close() {
    }

    @Test
    public void isPoppedDefault() {
        Ball ball = new Ball();
        assertFalse(ball.isPopped());
    }

    public void isPoppedGetSet() {
        Ball ball = new Ball();
        ball.setPopped(true);
        assertFalse(ball.isPopped());
    }

    @Test
    public void setPopped() {
    }

    @Test
    public void getColor() {
    }

    @Test
    public void setColor() {
    }

    @Test
    public void getBounceHeightInFeet() {
    }

    @Test
    public void setBounceHeightInFeet() {
    }

    @Test
    public void getWeightInGrams() {
        Ball ball = new Ball();
        assertEquals(150.0, ball.getWeightInGrams(), 0.001);
    }

    @Test
    public void setWeightInGramsOk() {
        Ball ball = new Ball();
        ball.setWeightInGrams(150.0);
        assertEquals(150.0, ball.getWeightInGrams(), 0.001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setWeightInGramsFail() {
        Ball ball = new Ball();
        ball.setWeightInGrams(-33);
        assertEquals(-33, ball.getWeightInGrams(), 0.001);
    }
}