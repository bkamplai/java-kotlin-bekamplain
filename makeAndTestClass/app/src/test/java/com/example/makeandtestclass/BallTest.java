package com.example.makeandtestclass;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BallTest {

    Ball ball;

    @Before
    public void setUp() throws Exception {
        ball = new Ball();
    }

    @After
    public void tearDown() throws Exception {

    }

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

    @Test
    public void fromJSON() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\n" +
                "    \"weight\": 150.0,\n" +
                "    \"color\": \"black\",\n" +
                "    \"height\": 2.5,\n" +
                "    \"popped\": false\n" +
                "}";
        ball = mapper.readValue(json, Ball.class);

        assertEquals(150.0d, ball.getWeightInGrams(), 0.001);
        assertEquals("black", ball.getColor());
        assertEquals(2.5f, ball.getBounceHeightInFeet(), 0.5);
        assertFalse(ball.isPopped());
    }

    // Ball() {
    //        this("black", 150.0d, 2.5f, false);
    //    }
    @Test
    public void toJSON() throws Exception {
        ball = new Ball("black", 150.0d, 2.5f, false);

        ObjectMapper mapper = new ObjectMapper();
        String json  = mapper.writeValueAsString(ball);
        String expect = "{\"color\":\"black\",\"weight\":150.0,\"height\":2.5,\"popped\":false}";

        assertEquals(expect,json);
    }
}