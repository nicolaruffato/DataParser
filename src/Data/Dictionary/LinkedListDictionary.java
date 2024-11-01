package Data.Dictionary;

import Data.Pair;

public class LinkedListDictionary<K extends Comparable<K>, V> implements Dictionary<K, V> {

    private Node<Pair<K, V>> head;
    private int size;

    public LinkedListDictionary() {
        head = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        head = new Node<>(new Pair<>(key, value), head);
        size++;
    }

    @Override
    public void remove(K key) {
        if(head != null) {
            if(head.getData().getKey().equals(key)) {
                head = head.getNext();
            }
            else {
                Node<Pair<K, V>> tmp = head;
                while(tmp.getNext() != null) {
                    if(tmp.getNext().getData().getKey().equals(key)) {
                        tmp = tmp.getNext().getNext();
                        size--;
                        break;
                    }
                    tmp = tmp.getNext();
                }
            }
        }
    }

    @Override
    public V get(K key) {
        if(head != null) {
            Node<Pair<K, V>> tmp = head;
            while(tmp != null) {
                if(tmp.getData().getKey().equals(key)) {
                    return tmp.getData().getValue();
                }
                tmp = tmp.getNext();
            }
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        if(head != null) {
            Node<Pair<K, V>> tmp = head;
            while(tmp != null) {
                if(tmp.getData().getKey().equals(key)) {
                    return true;
                }
                tmp = tmp.getNext();
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
