package com.romix.scala.collection.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class TestMultiThreadInserts {
    @Test
    public void testMultiThreadInserts () {
        final int nThreads = 2;
        final ExecutorService es = Executors.newFixedThreadPool (nThreads);
        final TrieMap<Object, Object> bt = new TrieMap<Object, Object> ();
        for (int i = 0; i < nThreads; i++) {
            final int threadNo = i;
            es.execute (new Runnable () {
                @Override
                public void run () {
                    for (int j = 0; j < 500 * 1000; j++) {
                        if (j % nThreads == threadNo) {
                            bt.put (Integer.valueOf (j), Integer.valueOf (j));
                        }
                    }
                }
            });
        }

        es.shutdown ();
        try {
            es.awaitTermination (3600L, TimeUnit.SECONDS);
        } catch (final InterruptedException e) {
            e.printStackTrace ();
        }
        
        for (int j = 0; j < 500 * 1000; j++) {
            final Object lookup = bt.lookup (Integer.valueOf (j));
            TestHelper.assertEquals (Integer.valueOf (j), lookup);
        }
    }
}
