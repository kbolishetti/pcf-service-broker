package com.techolution.hashmap;

/**
 * Created by tdelesio on 5/7/17.
 */
public interface CustomHashMap<K, V> {
    public V get(K key);
    public void put(K key, V value);
    public boolean remove(K key);

}
