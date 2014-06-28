package com.romix.scala.collection.concurrent;

import junit.framework.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Map;

public class TestSerialization {
    @Test
    public void testSerialization() throws Exception{
        TrieMap<String, String> expected = new TrieMap<String, String>();

        expected.put("dude-0", "tom");
        expected.put("dude-1", "john");
        expected.put("dude-3", "ravi");
        expected.put("dude-4", "alex");

        writeObject(expected, "/tmp/dudes.ser");

        TrieMap<String, String> actual = (TrieMap<String, String>) readObject("/tmp/dudes.ser");

        for(Map.Entry<String, String> entry : expected.entrySet()){
            Assert.assertEquals(entry.getValue(), actual.get(entry.getKey()));
        }

    }

    private Object readObject(String path) throws Exception{
        FileInputStream fileIn =
                new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Object o = in.readObject();
        in.close();
        fileIn.close();
        return o;
    }

    private void writeObject(Object o, String path) throws Exception{
        FileOutputStream fileOut =
                new FileOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(o);
        out.close();
        fileOut.close();
    }
}
