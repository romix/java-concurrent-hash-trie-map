package com.romix.scala.collection.concurrent;

import org.junit.Test;

public class TestInsert {
    @Test
    public void testInsert () {
        final TrieMap<Object, Object> bt = new TrieMap<Object, Object> ();
        TestHelper.assertEquals (null, bt.put ("a", "a"));
        TestHelper.assertEquals (null, bt.put ("b", "b"));
        TestHelper.assertEquals (null, bt.put ("c", "b"));
        TestHelper.assertEquals (null, bt.put ("d", "b"));
        TestHelper.assertEquals (null, bt.put ("e", "b"));

        for (int i = 0; i < 10000; i++) {
            TestHelper.assertEquals (null, bt.put (Integer.valueOf (i), Integer.valueOf (i)));
            final Object lookup = bt.lookup (Integer.valueOf (i));
            TestHelper.assertEquals (Integer.valueOf (i), lookup);
        }

        bt.toString ();
    }
}
