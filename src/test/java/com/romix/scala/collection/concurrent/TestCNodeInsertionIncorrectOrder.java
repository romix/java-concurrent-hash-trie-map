package com.romix.scala.collection.concurrent;

import java.util.Map;

import org.junit.Test;

public class TestCNodeInsertionIncorrectOrder {

    @Test
    public void testCNodeInsertionIncorrectOrder () {
        final Map<Object, Object> map = new TrieMap<Object, Object> ();
        final Integer z3884 = Integer.valueOf (3884);
        final Integer z4266 = Integer.valueOf (4266);
        map.put (z3884, z3884);
        TestHelper.assertTrue (null != map.get (z3884));
        
        map.put (z4266, z4266);
        TestHelper.assertTrue (null != map.get (z3884));
        TestHelper.assertTrue (null != map.get (z4266));
    }
}
