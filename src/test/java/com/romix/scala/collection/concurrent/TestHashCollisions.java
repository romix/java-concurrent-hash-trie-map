package com.romix.scala.collection.concurrent;


import org.junit.Test;

public class TestHashCollisions {
    @Test
    public void testHashCollisions () {
        final TrieMap<Object, Object> bt = new TrieMap<Object, Object> ();

        insertStrings (bt);
        insertChars (bt);
        insertInts (bt);
        insertBytes (bt);
        
        removeStrings (bt);
        removeChars (bt);
        removeInts (bt);
        removeBytes (bt);

        insertStrings (bt);
        insertInts (bt);
        insertBytes (bt);
        insertChars (bt);

        removeBytes (bt);
        removeStrings (bt);
        removeChars (bt);
        removeInts (bt);

        insertStrings (bt);
        insertInts (bt);
        insertBytes (bt);
        insertChars (bt);

        removeStrings (bt);
        removeChars (bt);
        removeInts (bt);
        removeBytes (bt);

        insertStrings (bt);
        insertInts (bt);
        insertBytes (bt);
        insertChars (bt);

        removeChars (bt);
        removeInts (bt);
        removeBytes (bt);
        removeStrings (bt);

        insertStrings (bt);
        insertInts (bt);
        insertBytes (bt);
        insertChars (bt);

        removeInts (bt);
        removeBytes (bt);
        removeStrings (bt);
        removeChars (bt);

        System.out.println (bt);
    }

    private static void insertChars (final TrieMap<Object, Object> bt) {
        TestHelper.assertEquals (null, bt.put ('a', 'a'));
        TestHelper.assertEquals (null, bt.put ('b', 'b'));
        TestHelper.assertEquals (null, bt.put ('c', 'c'));
        TestHelper.assertEquals (null, bt.put ('d', 'd'));
        TestHelper.assertEquals (null, bt.put ('e', 'e'));

        TestHelper.assertEquals ('a', bt.put ('a', 'a'));
        TestHelper.assertEquals ('b', bt.put ('b', 'b'));
        TestHelper.assertEquals ('c', bt.put ('c', 'c'));
        TestHelper.assertEquals ('d', bt.put ('d', 'd'));
        TestHelper.assertEquals ('e', bt.put ('e', 'e'));
    }

    private static void insertStrings (final TrieMap<Object, Object> bt) {
        TestHelper.assertEquals (null, bt.put ("a", "a"));
        TestHelper.assertEquals (null, bt.put ("b", "b"));
        TestHelper.assertEquals (null, bt.put ("c", "c"));
        TestHelper.assertEquals (null, bt.put ("d", "d"));
        TestHelper.assertEquals (null, bt.put ("e", "e"));

        TestHelper.assertEquals ("a", bt.put ("a", "a"));
        TestHelper.assertEquals ("b", bt.put ("b", "b"));
        TestHelper.assertEquals ("c", bt.put ("c", "c"));
        TestHelper.assertEquals ("d", bt.put ("d", "d"));
        TestHelper.assertEquals ("e", bt.put ("e", "e"));
    }

    private static void insertBytes (final TrieMap<Object, Object> bt) {
        for (byte i = 0; i < 128 && i >= 0; i++) {
            final Byte bigB = Byte.valueOf (i);
            TestHelper.assertEquals (null, bt.put (bigB, bigB));
            TestHelper.assertEquals (bigB, bt.put (bigB, bigB));
        }
    }

    private static void insertInts (final TrieMap<Object, Object> bt) {
        for (int i = 0; i < 128; i++) {
            final Integer bigI = Integer.valueOf (i);
            TestHelper.assertEquals (null, bt.put (bigI, bigI));
            TestHelper.assertEquals (bigI, bt.put (bigI, bigI));
        }
    }

    private static void removeChars (final TrieMap<Object, Object> bt) {
        TestHelper.assertTrue (null != bt.lookup ('a'));
        TestHelper.assertTrue (null != bt.lookup ('b'));
        TestHelper.assertTrue (null != bt.lookup ('c'));
        TestHelper.assertTrue (null != bt.lookup ('d'));
        TestHelper.assertTrue (null != bt.lookup ('e'));

        TestHelper.assertTrue (null != bt.remove ('a'));
        TestHelper.assertTrue (null != bt.remove ('b'));
        TestHelper.assertTrue (null != bt.remove ('c'));
        TestHelper.assertTrue (null != bt.remove ('d'));
        TestHelper.assertTrue (null != bt.remove ('e'));

        TestHelper.assertFalse (null != bt.remove ('a'));
        TestHelper.assertFalse (null != bt.remove ('b'));
        TestHelper.assertFalse (null != bt.remove ('c'));
        TestHelper.assertFalse (null != bt.remove ('d'));
        TestHelper.assertFalse (null != bt.remove ('e'));

        TestHelper.assertTrue (null == bt.lookup ('a'));
        TestHelper.assertTrue (null == bt.lookup ('b'));
        TestHelper.assertTrue (null == bt.lookup ('c'));
        TestHelper.assertTrue (null == bt.lookup ('d'));
        TestHelper.assertTrue (null == bt.lookup ('e'));
    }

    private static void removeStrings (final TrieMap<Object, Object> bt) {
        TestHelper.assertTrue (null != bt.lookup ("a"));
        TestHelper.assertTrue (null != bt.lookup ("b"));
        TestHelper.assertTrue (null != bt.lookup ("c"));
        TestHelper.assertTrue (null != bt.lookup ("d"));
        TestHelper.assertTrue (null != bt.lookup ("e"));

        TestHelper.assertTrue (null != bt.remove ("a"));
        TestHelper.assertTrue (null != bt.remove ("b"));
        TestHelper.assertTrue (null != bt.remove ("c"));
        TestHelper.assertTrue (null != bt.remove ("d"));
        TestHelper.assertTrue (null != bt.remove ("e"));

        TestHelper.assertFalse (null != bt.remove ("a"));
        TestHelper.assertFalse (null != bt.remove ("b"));
        TestHelper.assertFalse (null != bt.remove ("c"));
        TestHelper.assertFalse (null != bt.remove ("d"));
        TestHelper.assertFalse (null != bt.remove ("e"));

        TestHelper.assertTrue (null == bt.lookup ("a"));
        TestHelper.assertTrue (null == bt.lookup ("b"));
        TestHelper.assertTrue (null == bt.lookup ("c"));
        TestHelper.assertTrue (null == bt.lookup ("d"));
        TestHelper.assertTrue (null == bt.lookup ("e"));
    }

    private static void removeInts (final TrieMap<Object, Object> bt) {
        for (int i = 0; i < 128; i++) {
            final Integer bigI = Integer.valueOf (i);
            TestHelper.assertTrue (null != bt.lookup (bigI));
            TestHelper.assertTrue (null != bt.remove (bigI));
            TestHelper.assertFalse (null != bt.remove (bigI));
            TestHelper.assertTrue (null == bt.lookup (bigI));
        }
    }

    private static void removeBytes (final TrieMap<Object, Object> bt) {
        for (byte i = 0; i < 128 && i >= 0; i++) {
            final Byte bigB = Byte.valueOf (i);
            TestHelper.assertTrue (null != bt.lookup (bigB));
            TestHelper.assertTrue (null != bt.remove (bigB));
            TestHelper.assertFalse (null != bt.remove (bigB));
            TestHelper.assertTrue (null == bt.lookup (bigB));
        }
    }
}
