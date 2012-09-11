package com.romix.scala.collection.concurrent;

import java.util.concurrent.ConcurrentMap;

import org.junit.Test;

public class TestConcurrentMapReplace {
    private static final int COUNT = 50*1000;

    @Test
    public void testConcurrentMapReplace () {
        final ConcurrentMap<Object, Object> map = new TrieMap<Object, Object> ();
        
        for (int i = 0; i < COUNT; i++) {
            TestHelper.assertTrue (null == map.replace (i, "lol"));
            TestHelper.assertFalse (map.replace (i, i, "lol2"));
            TestHelper.assertTrue (null == map.put (i, i));
            TestHelper.assertTrue (Integer.valueOf (i).equals (map.replace (i, "lol")));
            TestHelper.assertFalse (map.replace (i, i, "lol2"));
            TestHelper.assertTrue (map.replace (i, "lol", i));
        }
    }
}
