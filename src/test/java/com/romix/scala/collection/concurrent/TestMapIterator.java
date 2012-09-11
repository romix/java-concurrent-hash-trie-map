package com.romix.scala.collection.concurrent;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

public class TestMapIterator {
    @Test
    public void testMapIterator () {
        for (int i = 0; i < 60 * 1000; i+= 400 + new Random ().nextInt (400)) {
            System.out.println (i);
            final Map<Integer, Integer> bt = new TrieMap <Integer, Integer> ();
            for (int j = 0; j < i; j++) {
                TestHelper.assertEquals (null, bt.put (Integer.valueOf (j), Integer.valueOf (j)));
            }
            int count = 0;
            final Set<Integer> set = new HashSet<Integer> ();
            for (final Map.Entry<Integer, Integer> e : bt.entrySet ()) {
                set.add (e.getKey ());
                count++;
            }
            for (final Integer j : set) {
                TestHelper.assertTrue (bt.containsKey (j));
            }
            for (final Integer j : bt.keySet ()) {
                TestHelper.assertTrue (set.contains (j));
            }

            TestHelper.assertEquals (i, count);
            TestHelper.assertEquals (i, bt.size ());
            
            for (final Iterator<Map.Entry<Integer, Integer>> iter = bt.entrySet ().iterator (); iter.hasNext ();) {
                final Entry<Integer, Integer> e = iter.next ();
                TestHelper.assertTrue (e.getValue () == bt.get (e.getKey ()));
                e.setValue (e.getValue () + 1);
                TestHelper.assertTrue (e.getValue () == e.getKey () + 1);
                TestHelper.assertTrue (e.getValue () == bt.get (e.getKey ()));
                e.setValue (e.getValue () - 1);
            }

            for (final Iterator<Integer> iter = bt.keySet ().iterator (); iter.hasNext ();) {
                final Integer k = iter.next ();
                TestHelper.assertTrue (bt.containsKey (k));
                iter.remove ();
                TestHelper.assertFalse (bt.containsKey (k));
            }
            
            TestHelper.assertEquals (0, bt.size ());
            TestHelper.assertTrue (bt.isEmpty ());
        }
    }
}
