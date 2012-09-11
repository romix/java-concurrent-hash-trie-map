About
=============================

This is a Java port of a concurrent trie hash map implementation from the Scala collections library. It is almost a line-by-line 
conversion from Scala to Java.

Idea + implementation techniques can be found in these reports written by Aleksandar Prokopec:
   *   http://infoscience.epfl.ch/record/166908/files/ctries-techreport.pdf
   *   http://lamp.epfl.ch/~prokopec/ctries-snapshot.pdf

The original Scala implementation can be found here and is a part of scala.collection.concurrent:
   *   [[Scala implementation][https://github.com/scala/scala/blob/930c85d6c96507d798d1847ea078eebf93dc0acb/src/library/scala/collection/concurrent/TrieMap.scala#L1]]

Some of the tests and implementation details were borrowed from this project:
   *  https://github.com/flegall/concurrent-hash-trie

Implementation status : 
   *   The given implementation is complete and implements all features of the original Scala implementation including support for 
   snapshots.
   *   Wherever necessary, code was adapted to be more easily usable in Java, e.g. it returns Objects instead of Option<V> as 
   many methods of Scala's collections do.   
   *   This class implements all the ConcurrentMap & Iterator methods and passes all the tests. Can be used as a drop-in replacement
       for usual Java maps, including ConcurrentHashMap.

       
License
===============================

This library is licensed under the Apache 2.0 license.


Usage
===============================

Usage of this library is very simple. Simply import the class com.romix.scala.collection.concurrent.TrieMap and use it as a usual Map.
    
    import com.romix.scala.collection.concurrent.TrieMap;
    
    Map myMap = new TrieMap <Object, Object> ();
    myMap.put("key", "value");
    

Building the library
===============================

Use a usual `mvn clean install`

Using the library with Maven projects
=====================================
		<dependency>
			<groupId>com.romix</groupId>
			<artifactId>java-concurrent-hash-trie-map</artifactId>
		</dependency>

    