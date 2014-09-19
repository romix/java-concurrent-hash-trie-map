package com.romix.scala.collection.concurrent;

import org.junit.Test;

public class TestInstantiationSpeed {
    private static final int COUNT = 100000;
    private static final int ITERATIONS = 10;
    private static final int WARMUP = 20;

    private long runIteration() {
        final TrieMap<?, ?>[] maps = new TrieMap<?, ?>[COUNT];
        final long start = System.nanoTime();

        for (int i = 0; i < COUNT; ++i) {
            maps[i] = new TrieMap<Object, Object>();
        }

        final long stop = System.nanoTime();
        return stop - start;
    }

    @Test
    public void testInstantiation() {

        for (int i = 0; i < WARMUP; ++i) {
            final long time = runIteration();
            System.out.println(String.format("Warmup %s took %sns (%sns)", i, time, time / COUNT));
        }

        long acc = 0;
        for (int i = 0; i < ITERATIONS; ++i) {
            final long time = runIteration();
            System.out.println(String.format("Iteration %s took %sns (%sns)", i, time, time / COUNT));
            acc += time;
        }

        System.out.println("Instantiation cost " + acc / ITERATIONS / COUNT + "ns");
    }
}
