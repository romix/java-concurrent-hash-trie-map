package com.romix.scala;

/**
 * Mimic Option in Scala
 *  
 * @author Roman Levenstein <romixlev@gmail.com>
 *
 * @param <V>
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class Option<V> {
    private static final None NONE = new None();
    public static <V> Option<V> makeOption(V o){
        return o != null ? new Some<V>(o) : NONE;
    }

    public static <V> Option<V> makeOption(){
        return NONE;
    }
    public boolean nonEmpty () {
        return false;
    }
}
