package StackIterator;

public class Node<Integer> {
    public int currentElement;
    public Node<Integer> prev;

    public Node(int currentElement){
        this.currentElement = currentElement;
        this.prev = null;

    }
}

