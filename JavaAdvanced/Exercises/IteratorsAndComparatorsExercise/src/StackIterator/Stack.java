package StackIterator;

import java.util.Iterator;
import java.util.List;

public class Stack<Integer> implements Iterable<Integer> {
    private Node<Integer> top;

    public Stack() {
        this.top = null;
    }

    //push
    public void push(int newElement) {
        Node<Integer> newNode = new Node<>(newElement);
        newNode.prev = this.top;
        this.top = newNode;
    }

    // pop

    public int pop() throws Exception {
        if (this.top == null) {
         throw new Exception ("No Elements");
        } else {
            Node<Integer> currentTop = this.top;
            this.top = this.top.prev;
            return currentTop.currentElement;
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node<Integer> currentNode = top;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Integer next(){
                int currentValue = currentNode.currentElement;
                this.currentNode = this.currentNode.prev;
                return (Integer) java.lang.Integer.valueOf(currentValue);
            }
        };
    }
}
