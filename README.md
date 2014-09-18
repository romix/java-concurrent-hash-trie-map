About
=============================

This is a Java port of a concurrent trie hash map implementation from the Scala collections library. It is almost a line-by-line 
conversion from Scala to Java.

Idea + implementation techniques can be found in these reports written by Aleksandar Prokopec:
   * http://infoscience.epfl.ch/record/166908/files/ctries-techreport.pdf - this is a nice introduction to Ctries, along with a correctness proof
   * http://lamp.epfl.ch/~prokopec/ctries-snapshot.pdf - a more up-to-date writeup which describes the snapshot operation

The original Scala implementation can be found here and is a part of scala.collection.concurrent:
   *   [Scala implementation](https://github.com/scala/scala/blob/930c85d6c96507d798d1847ea078eebf93dc0acb/src/library/scala/collection/concurrent/TrieMap.scala)

Some of the tests and implementation details were borrowed from this project:
   *  https://github.com/flegall/concurrent-hash-trie

Implementation status : 
   *   The given implementation is complete and implements all features of the original Scala implementation including support for 
   snapshots.
   *   Wherever necessary, code was adapted to be more easily usable in Java, e.g. it returns Objects instead of Option<V> as 
   many methods of Scala's collections do.   
   *   This class implements all the ConcurrentMap & Iterator methods and passes all the tests. Can be used as a drop-in replacement
       for usual Java maps, including ConcurrentHashMap.


What is a concurrent trie hash map also known as ctrie?
========================================================
ctrie is a lock-Free Concurrent Hash Array Mapped Trie.

A concurrent hash-trie or Ctrie is a concurrent thread-safe lock-free implementation of a hash array mapped trie.
 
It is used to implement the concurrent map abstraction. It has particularly scalable concurrent insert and remove operations 
and is memory-efficient. 

It supports O(1), atomic, lock-free snapshots which are used to implement linearizable lock-free size, iterator and clear operations. 
The cost of evaluating the (lazy) snapshot is distributed across subsequent updates, thus making snapshot evaluation horizontally scalable.

The original Scala-based implementation of the Ctrie is a part of the Scala standard library since the version 2.10.

More info about Ctries:

- http://infoscience.epfl.ch/record/166908/files/ctries-techreport.pdf - this is a nice introduction to Ctries, along with a correctness proof
- http://lamp.epfl.ch/~prokopec/ctries-snapshot.pdf - a more up-to-date writeup (more coherent with the current version of the code) which describes the snapshot operation
       

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
The prebuilt binaries of the library are available from Maven central. Please use the following dependency in your POM files:

		<dependency>
			<groupId>com.github.romix</groupId>
			<artifactId>java-concurrent-hash-trie-map</artifactId>
			<version>0.2.23</version>
		</dependency>


External dependencies
=====================================
This library is self-contained. It does not depend on any additional libraries. In particular, it does not require the rather big Scala's 
standard library to be used.

