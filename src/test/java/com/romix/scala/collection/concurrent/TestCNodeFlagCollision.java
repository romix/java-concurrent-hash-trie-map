package com.romix.scala.collection.concurrent;

import java.util.Map;

import org.junit.Test;

public class TestCNodeFlagCollision {
    @Test
    public void testCNodeFlagCollision () {
        final Map<Object, Object> map = new TrieMap<Object, Object> ();
        final Integer z15169 = Integer.valueOf (15169);
        final Integer z28336 = Integer.valueOf (28336);
        
        TestHelper.assertTrue (null == map.get (z15169));
        TestHelper.assertTrue (null == map.get (z28336));
        
        map.put (z15169, z15169);
        TestHelper.assertTrue (null != map.get (z15169));
        TestHelper.assertTrue (null == map.get (z28336));
        
        map.put (z28336, z28336);
        TestHelper.assertTrue (null != map.get (z15169));
        TestHelper.assertTrue (null != map.get (z28336));
        
        map.remove (z15169);
        
        TestHelper.assertTrue (null == map.get (z15169));
        TestHelper.assertTrue (null != map.get (z28336));
        
        map.remove (z28336);
        
        TestHelper.assertTrue (null == map.get (z15169));
        TestHelper.assertTrue (null == map.get (z28336));
    }
}
