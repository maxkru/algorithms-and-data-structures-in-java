package lesson8.util;

public interface MyMap<K, V> {

    void put(K key, V value);

    V get(K key);

    V remove(K key);

    boolean containsKey(K key);

    boolean containsValue(V value);

    int size();

    boolean isEmpty();

}
