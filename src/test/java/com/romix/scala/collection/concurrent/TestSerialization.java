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
        TrieMap<String, String> map = new TrieMap<String, String>();

        map.put("dude-0", "tom");
        map.put("dude-1", "john");
        map.put("dude-3", "ravi");
        map.put("dude-4", "alex");

        TrieMap<String, String> expected = map.readOnlySnapshot();

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
