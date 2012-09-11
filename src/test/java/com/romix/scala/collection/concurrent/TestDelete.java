package com.romix.scala.collection.concurrent;

import org.junit.Test;


public class TestDelete {
    @Test
    public void testDelete () {
        final TrieMap<Object, Object> bt = new TrieMap<Object, Object> ();

        for (int i = 0; i < 10000; i++) {
            TestHelper.assertEquals (null, bt.put (Integer.valueOf (i), Integer.valueOf (i)));
            final Object lookup = bt.lookup (Integer.valueOf (i));
            TestHelper.assertEquals (Integer.valueOf (i), lookup);
        }
        
        checkAddInsert (bt, 536);
        checkAddInsert (bt, 4341);
        checkAddInsert (bt, 8437);
        
        for (int i = 0; i < 10000; i++) {
            boolean removed = null != bt.remove(Integer.valueOf (i));
            TestHelper.assertEquals (Boolean.TRUE, Boolean.valueOf (removed));
            final Object lookup = bt.lookup (Integer.valueOf (i));
            TestHelper.assertEquals (null, lookup);
        }

        bt.toString ();
    }

    private static void checkAddInsert (final TrieMap<Object, Object> bt, int k) {
        final Integer v = Integer.valueOf (k);
        bt.remove (v);
        Object foundV = bt.lookup (v);
        TestHelper.assertEquals (null, foundV);
        TestHelper.assertEquals (null, bt.put (v, v));
        foundV = bt.lookup (v);
        TestHelper.assertEquals (v, foundV);
        
        TestHelper.assertEquals (v, bt.put (v, Integer.valueOf (-1)));
        TestHelper.assertEquals (Integer.valueOf (-1), bt.put (v, v));
    }
}
