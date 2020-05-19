package com.company;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Iterator;

public class MyStack<T> implements Iterable<T>{

    private Node<T> head;

    private int size;

    private static class Node<T> {

        private Node<T> next;

        private T value;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

    }

    private class Itr implements Iterator<T> {

        private Node<T> lastFound = new Node<>(null, head);

        @Override
        public boolean hasNext() {
            return lastFound != null && lastFound.next != null;
        }

        @Override
        public T next() {
            lastFound = lastFound.next;
            return lastFound.value;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    public MyStack() {
    }

    @SafeVarargs
    public MyStack(T... array) {
        for (T element : array)
            push(element);
    }

    public MyStack(Collection<T> collection) {
        for (T element : collection)
            push(element);
    }

    public void push(T val) {
        head = new Node<>(val, head);
        size++;
    }

    public T pop() {
        if (head == null) throw new EmptyStackException();
        T val = head.value;
        head = head.next;
        size--;
        return val;
    }

    public T peek() {
        if (head == null) throw new EmptyStackException();
        return head.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        Node<T> node = head;
        while (node != null) {
            builder.append(node.value).append(", ");
            node = node.next;
        }
        builder.setLength(builder.length() - 2);
        return "[" + builder.toString() + "]";
    }

}
