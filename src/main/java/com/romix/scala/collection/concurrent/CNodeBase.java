/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2003-2012, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

package com.romix.scala.collection.concurrent;



import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;



abstract class CNodeBase<K, V> extends MainNode<K, V> {
    
    @SuppressWarnings("rawtypes")
    private static final AtomicIntegerFieldUpdater<CNodeBase> UPDATER = AtomicIntegerFieldUpdater.newUpdater(CNodeBase.class, "csize");
    
    private volatile int csize = -1;
    
    public boolean CAS_SIZE(int oldval, int nval) {
        return UPDATER.compareAndSet(this, oldval, nval);
    }
    
    public void WRITE_SIZE(int nval) {
        UPDATER.set(this, nval);
    }
    
    public int READ_SIZE() {
        return csize;
    }
    
}