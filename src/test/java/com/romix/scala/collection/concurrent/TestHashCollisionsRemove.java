package com.romix.scala.collection.concurrent;

import java.util.Map;

import org.junit.Test;

public class TestHashCollisionsRemove {
    @Test
    public void  testHashCollisionsRemove() {
        final Map<Object, Object> bt = new TrieMap<Object, Object> ();
        int count = 50000;
        for (int j = 0; j < count; j++) {
            final Object[] objects = TestMultiThreadMapIterator.getObjects (j);
            for (final Object o : objects) {
                bt.put (o, o);
            }
        }
        
        for (int j = 0; j < count; j++) {
            final Object[] objects = TestMultiThreadMapIterator.getObjects (j);
            for (final Object o : objects) {
                bt.remove (o);
            }
        }

        TestHelper.assertEquals (0, bt.size ());
        TestHelper.assertTrue (bt.isEmpty ());
    }
}
