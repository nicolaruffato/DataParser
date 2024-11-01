package Data.List;

public class LinkedList<T> implements List<T> {

    private class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFront(T data) {
        Node<T> newNode = new Node<>(data, null, head);
        if(head != null) {
            head.prev = newNode;
        }
        head = newNode;
        size++;
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
        if(index < 0 || index >= size) { return null; }
        Node<T> ptr = head;
        while(index != 0) {
            ptr = ptr.next;
            index--;
        }
        return ptr.getData();
    }

    @Override
    public T set(int index, T element) {
        if(index < 0 || index >= size) { return null; }
        Node<T> ptr = head;
        while(index != 0) {
            ptr = ptr.next;
            index--;
        }
        T tmp = ptr.getData();
        ptr.setData(element);
        return tmp;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element, tail, null);
        if(tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public void add(int index, T element) {
        if(index >= 0  && index < size) {
            if(index == 0) {
                addFront(element);
            }
            else if(index == size - 1) {
                add(element);
            }
            else {
                Node<T> ptr = head;
                while(index != 1) {
                    ptr = ptr.next;
                    index--;
                }
                Node<T> tmp = ptr.next;
                ptr.next = new Node<>(element, ptr, tmp);
                tmp.prev = ptr.next;
            }
            size++;
        }
    }

    @Override
    public T remove(int index) {
        if(index < 0 || index >= size) { return null; }
        else if(index == 0) {
            T tmp = head.getData();
            head = head.next;
            head.prev = null;
            size--;
            return tmp;
        }
        else if(index == size - 1) {
            T tmp = tail.getData();
            tail = tail.prev;
            tail.next = null;
            size--;
            return tmp;
        }
        else {
            Node<T> ptr = head;
            while(index != 0) {
                ptr = ptr.next;
                index--;
            }
            ptr.prev.next = ptr.next;
            ptr.next.prev = ptr.prev;
            return ptr.getData();
        }
    }

    @Override
    public T remove() {
        if(tail == null) { return null; }
        else {
            T tmp = tail.getData();
            tail = tail.prev;
            tail.next = null;
            return tmp;
        }
    }
}
