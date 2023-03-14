package com.example.javabasics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

public class CapTest {

    Cap cap;

    @Before
    public void before() {
        cap = new Cap();
    }

    @Test
    public void getSize() {
        assertEquals(Size.MEDIUM, cap.getSize());
    }

    @Test
    public void setSize() {
        cap.setSize(Size.SMALL);
        assertEquals(Size.SMALL, cap.getSize());
    }

    @Test
    public void getLabel() {
        assertEquals("", cap.getLabel());
    }

    @Test
    public void setLabel() {
        cap.setLabel("x");
        assertEquals("x", cap.getLabel());
    }

    // used fro coparison
    // Use .equals() for objects
    @Test
    public void testEquals() {
        Cap other = new Cap();
        assertEquals(cap, other);
    }

    @Test
    public void testHashCode() {
        long hc1 = cap.hashCode();
        Cap other = new Cap();
        Set<Integer> hashes = new TreeSet<Integer>();
        int [] counts = new int [100];
        for (int t = 0; t < 10_000; ++t) {
            other.setThreadCount(45 + 23 * t);
            hashes.add(other.hashCode());
        }
        assertTrue(hashes.size() >= 10_000 - 3);
    }

    @Test
    public void compareTo() {
    }
}