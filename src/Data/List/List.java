package Data.List;

import Data.Collection;

public interface List<T> extends Collection {
    int getSize();
    boolean isEmpty();
    T get(int index);
    T set(int index, T element);
}
