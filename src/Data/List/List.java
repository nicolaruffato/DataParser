package Data.List;

import Data.Collection;

public interface List<T> extends Collection {
    T get(int index);
    T set(int index, T element);
    void add(T element);
    void add(int index, T element);
    T remove(int index);
    T remove();
}
