package lesson8.util;

import java.util.*;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private static final int INT_REMOVE_SIGN_CONSTANT = 0x7fffffff;
    private static final String ENTRY_STRING_SEPARATOR = ", ";

    private class Entry {
        private final K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 7;
    private int size = 0;

    private LinkedList<Entry>[] entryLists;

    public MyHashMap() {
        entryLists = new LinkedList[capacity];
        for (int i = 0; i < entryLists.length; i++) {
            entryLists[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & INT_REMOVE_SIGN_CONSTANT) % capacity;
    }

    @Override
    public void put(K key, V value) {
        int hash = hash(key);
        LinkedList<Entry> entryListForThisHash = entryLists[hash];
        for (Entry entry : entryListForThisHash) {
            if (key.equals(entry.key)) {
                entry.value = value;
                return;
            }
        }
        entryListForThisHash.addLast(new Entry(key, value));
        size++;
    }

    @Override
    public V get(K key) {
        int hash = hash(key);
        LinkedList<Entry> entryListForThisHash = entryLists[hash];
        for (Entry entry : entryListForThisHash) {
            if (key.equals(entry.key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int hash = hash(key);
        LinkedList<Entry> entryListForThisHash = entryLists[hash];
        Iterator<Entry> it = entryListForThisHash.iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            if (entry.key.equals(key)) {
                it.remove();
                size--;
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        int hash = hash(key);
        LinkedList<Entry> entryListForThisHash = entryLists[hash];
        for (Entry entry : entryListForThisHash) {
            if (key.equals(entry.key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (LinkedList<Entry> entryLinkedList : entryLists) {
            for (Entry entry : entryLinkedList) {
                if (entry.value.equals(value))
                    return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (LinkedList<Entry> entryLinkedList : entryLists) {
            for (Entry entry : entryLinkedList) {
                sb.append(entry.key);
                sb.append("=");
                sb.append(entry.value);
                sb.append(ENTRY_STRING_SEPARATOR);
            }
        }
        if (sb.charAt(sb.length() - ENTRY_STRING_SEPARATOR.length()) == ENTRY_STRING_SEPARATOR.charAt(0))
            sb.delete(sb.length() - ENTRY_STRING_SEPARATOR.length(), sb.length());
        sb.append("]");
        return sb.toString();
    }
}
