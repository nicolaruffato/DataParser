package Data.Stack;

import Data.Collection;

public interface Stack<T> extends Collection {
    int getSize();
    void push(T data);
    T pop();
    T top();
    boolean isEmpty();
}
