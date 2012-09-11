package com.romix.scala.collection.concurrent;

import org.junit.Assert;

public class TestHelper {

    public static void assertEquals (long expected, long found) {
        Assert.assertEquals (expected, found);
    }

    public static void assertEquals (int expected, int found) {
        Assert.assertEquals (expected, found);
    }

    public static void assertEquals (Object expected, Object found) {
        Assert.assertEquals (expected, found);
    }

    public static void assertTrue (boolean found) {
        Assert.assertTrue (found);
    }

    public static void assertFalse (boolean found) {
        Assert.assertFalse (found);
    }

}
