package com.techolution.hashmap;

import org.springframework.stereotype.Component;

/**
 * Created by tdelesio on 5/7/17.
 */
@Component
public class CustomHashMapImpl<K,V> implements CustomHashMap<K,V> {
    private static final Integer INITIAL_CAPACITY = 16;
    private Entry<K, V>[] entry;

    public CustomHashMapImpl(){
        entry = new Entry[INITIAL_CAPACITY];
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int calculateHash(K key) {
        return Math.abs(key.hashCode()) % INITIAL_CAPACITY;
    }

    public V get(K key) {
        int hash = calculateHash(key);
        if (entry[hash] == null) {
            return null;
        } else {
            Entry<K, V> tempEntry = entry[hash];
            while (tempEntry != null) {
                if (tempEntry.key.equals(key))
                    return tempEntry.value;
                tempEntry = tempEntry.next;
            }
            return null;
        }
    }

    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        int hash = calculateHash(key);
        Entry<K, V> newEntry = new Entry<K, V>(key, value, null);
        if (entry[hash] == null) {
            entry[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = entry[hash];
            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) {
                        newEntry.next = current.next;
                        entry[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }

    public boolean remove(K key) {
        int hash = calculateHash(key);
        if (entry[hash] == null) {
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = entry[hash];
            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) {
                        entry[hash] = entry[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }

}