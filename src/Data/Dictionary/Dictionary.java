package Data.Dictionary;

import Data.Collection;

public interface Dictionary<K extends Comparable<K>, V> extends Collection {
    void add(K key, V value);
    void remove(K key);
    V get(K key);
    boolean contains(K key);
    int size();
}
