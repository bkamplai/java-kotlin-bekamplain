package com.example.javabasics;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Cap implements Comparable<Cap> {
    public Cap(int threadCount, Size size, String label) {
        this.threadCount = threadCount;
        this.size = size;
        this.label = label;
    }

    private int threadCount;

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    void doUselessThingsWithThreadCount() {
        threadCount++;
        //Integer x = new Integer(3);
        //++x; // x = new Integer(x.intValue() + 1);

        // C++: std::list < int > ints;
        List< Integer > ints = new LinkedList< Integer >();

        // C++: for (std::list<int>::iterator i > ints.begin(): i!=ints.end(); ++i) {cout << *i;)
        // i = begin() -1;
        Iterator<Integer> i = ints.iterator();
        while (i.hasNext()) { // (i+1) != end())
            // C++: ++i; x = *i;
            Integer x = i.next();
        }

        // C++: for (auto &x : ints) {...}
        for (Integer x : ints) {

        }

    }

    // Size Cap.size = Size.MEDIUM;
    public static final Size DEFAULT_SIZE = Size.MEDIUM;
    private Size size = DEFAULT_SIZE;
    private String label = "";

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        if (size == null) {
            throw new IllegalArgumentException("size cannot be null");
        }
        this.size = size;
    }

    public String getLabel() {
        return label;
    }

    public void shout(int loudness) {
        //StringBuffer sb = new StringBuffer(label); //thread safe / slower version
        StringBuilder sb = new StringBuilder(label.length() + loudness); // not thread safe / faster
        sb.append(label);
        for (int i =0; i < loudness; ++i) {
            //label += "!";
            //label = label + "!";
            sb.append("!");
        }
        label = sb.toString();
    }

    public void setLabel(String label) {
        if (label == null) {
            throw new IllegalArgumentException("label cannot be null");
        }
        if (Utils.codepoints(label) > 20) {
            throw new IllegalArgumentException("label is too long");
        }
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Cap ? compareTo((Cap) o) == 0 : false;
//        if (this == o) return true;
//        if (!(o instanceof Cap)) return false;
//        Cap cap = (Cap) o;
//        return threadCount == cap.threadCount && getSize().equals(cap.getSize()) && getLabel().equals(cap.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(threadCount, getSize(), getLabel());
    }

    @Override
    public int compareTo(Cap cap) {
        if (threadCount != cap.threadCount) return Integer.compare(threadCount, cap.threadCount);
        if (getSize() != cap.getSize()) return getSize().compareTo(cap.getSize());
        return getLabel().compareTo(cap.getLabel());
    }
}
