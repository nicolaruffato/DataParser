package Data.List;

import Data.Collection;

import java.lang.reflect.Array;

public class ArrayList<T> implements List<T> {

    T[] array;
    int size;

    public ArrayList() {
        array = (T[]) new Object[1];
        size = 0;
    }

    public ArrayList(int capacity) {
        array = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException(); }
        else return array[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException(); }
        T temp = array[index];
        array[index] = element;
        return temp;
    }

    @Override
    public void add(T element) {
        reallocate();
        array[size++] = element;
    }

    @Override
    public T remove(int index) {
        T tmp = array[index];
        for(int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        reallocate();
        return tmp;
    }

    @Override
    public T remove() {
        T tmp = array[--size];
        reallocate();
        return tmp;
    }

    private void reallocate() {
        // invariant : size <= capacity < 4 * size
        if(size == array.length) {
            T[] t_array = (T[]) new Object[array.length * 2];
            for(int i = 0; i < size; i++) {
                t_array[i] = array[i];
            }
            array = t_array;
        }
        else if(size < (array.length / 4)) {
            T[] t_array = (T[]) new Object[array.length / 2];
            for(int i = 0; i < size; i++) {
                t_array[i] = array[i];
            }
            array = t_array;
        }
    }
}
