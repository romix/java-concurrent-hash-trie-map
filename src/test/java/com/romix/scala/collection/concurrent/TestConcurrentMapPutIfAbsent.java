package com.romix.scala.collection.concurrent;

import java.util.concurrent.ConcurrentMap;

import org.junit.Test;

public class TestConcurrentMapPutIfAbsent {
    private static final int COUNT = 50*1000;

    @Test
    public void testConcurrentMapPutIfAbsent () {
        final ConcurrentMap<Object, Object> map = new TrieMap<Object, Object> ();
        
        for (int i = 0; i < COUNT; i++) {
            TestHelper.assertTrue (null == map.putIfAbsent (i, i));
            TestHelper.assertTrue (Integer.valueOf (i).equals (map.putIfAbsent (i, i)));
        }
    }
}
