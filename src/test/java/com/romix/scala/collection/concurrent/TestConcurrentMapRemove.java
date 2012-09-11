package com.romix.scala.collection.concurrent;

import java.util.concurrent.ConcurrentMap;

import org.junit.Test;

public class TestConcurrentMapRemove {
    private static final int COUNT = 50*1000;

    @Test
    public void testConcurrentMapRemove () {
        final ConcurrentMap<Object, Object> map = new TrieMap<Object, Object> ();
        
        for (int i = 128; i < COUNT; i++) {
            TestHelper.assertFalse (map.remove (i, i));
            TestHelper.assertTrue (null == map.put (i, i));
            TestHelper.assertFalse (map.remove (i, "lol"));
            TestHelper.assertTrue (map.containsKey (i));
            TestHelper.assertTrue (map.remove (i, i));
            TestHelper.assertFalse (map.containsKey (i));
            TestHelper.assertTrue (null == map.put (i, i));
        }
    }
}
