package Data.Dictionary;

import Data.Collection;
import Data.Pair;

public class ArrayDictionary<K extends Comparable<K>, V> implements Dictionary<K, V>{
    Pair<K, V>[] array;
    int size;

    public ArrayDictionary() {
        array = (Pair<K, V>[]) new Object[1];
        size = 0;
    }

    public ArrayDictionary(int capacity) {
        array = (Pair<K, V>[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        reallocate();
        int i = 0;
        for(; i < array.length && array[i].getKey().compareTo(key) < 0; i++){}
        if(i == array.length) {
            array[size++] = new Pair<>(key, value);
        }
        else {
            for(int j = size; j > i + 1; j--) {
                array[j] = array[j - 1];
            }
            array[i] = new Pair<>(key, value);
            size++;
        }
    }

    @Override
    public void remove(K key) {
        int indx = bin_search(key, 0, array.length);
        if (indx != -1) {
            for(int i = indx; i < array.length-1; i++) {
                array[i] = array[i+1];
            }
            size--;
            reallocate();
        }
    }

    @Override
    public V get(K key) {
        int indx = bin_search(key, 0, array.length);
        if (indx != -1) {
            return array[indx].getValue();
        }
        else return null;
    }

    @Override
    public boolean contains(K key) {
        int indx = bin_search(key, 0, array.length);
        return indx != -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private int bin_search(K key, int lower_bound, int upper_bound) {
        if(upper_bound <= lower_bound) return -1;
        else if(array[lower_bound+upper_bound/2].getKey().equals(key)) return lower_bound+upper_bound/2;
        else {
            if(array[lower_bound+upper_bound/2].getKey().compareTo(key) < 0)
                return bin_search(key, lower_bound+upper_bound/2 + 1, upper_bound);
            else
                return bin_search(key, lower_bound, lower_bound+upper_bound/2);
        }
    }

    private void reallocate() {
        // invariant : size <= capacity < 4 * size
        if(size == array.length) {
            Pair<K, V>[] t_array = (Pair<K, V>[]) new Object[array.length * 2];
            for(int i = 0; i < size; i++) {
                t_array[i] = array[i];
            }
            array = t_array;
        }
        else if(size < (array.length / 4)) {
            Pair<K, V>[] t_array = (Pair<K, V>[]) new Object[array.length / 2];
            for(int i = 0; i < size; i++) {
                t_array[i] = array[i];
            }
            array = t_array;
        }
    }
}
