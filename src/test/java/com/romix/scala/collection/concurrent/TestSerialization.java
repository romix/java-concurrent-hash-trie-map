package com.romix.scala.collection.concurrent;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import junit.framework.Assert;

import org.junit.Test;

public class TestSerialization {
    @Test
    public void testSerialization() throws IOException, ClassNotFoundException {
        TrieMap<String, String> expected = new TrieMap<String, String>();

        expected.put("dude-0", "tom");
        expected.put("dude-1", "john");
        expected.put("dude-3", "ravi");
        expected.put("dude-4", "alex");

        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(expected);
        oos.close();

        final byte[] bytes = bos.toByteArray();
        final ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        final ObjectInputStream ois = new ObjectInputStream(bis);

        @SuppressWarnings("unchecked")
        final TrieMap<String, String> actual = (TrieMap<String, String>) ois.readObject();
        ois.close();

        Assert.assertEquals(expected, actual);
    }
}
