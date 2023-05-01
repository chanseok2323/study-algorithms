package com.chanseok.studyalgorithms;

public class StudyDoublyLinkedList<T> {
    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int count = 0;

    public T getTail() {
        return tail.data;
    }

    public int getCount() {
        return count;
    }

    public void add(int index, T data) {
        if(validIndex(index)) {
            throw new IllegalArgumentException();
        }

        LinkedNode<T> newNode = new LinkedNode<>(data);

        if(index == 0) {
            newNode.next = this.head;
            if(this.head != null) {
                this.head.prev = newNode;
            }
            this.head = newNode;
        } else if(index == this.count) {
            newNode.next = null;
            newNode.prev = this.tail;
            this.tail.next = newNode;
        } else {
            LinkedNode<T> currentNode = this.head;
            for(int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }

            newNode.next = currentNode.next;
            newNode.prev = currentNode;
            currentNode.next = newNode;
            newNode.next.prev = newNode;
        }

        if(newNode.next == null) {
            this.tail = newNode;
        }
        this.count++;
    }

    public T delete(int index) {
        if(validIndex(index)) {
            throw new IllegalArgumentException();
        }

        LinkedNode<T> currentNode = this.head;

        if(index == 0) {
            LinkedNode<T> deleteNode = this.head;
            if(this.head.next == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
                this.head.prev = null;
            }
            this.count--;
            return deleteNode.data;
        } else if(index == this.count-1) {
            LinkedNode<T> deletedNode = this.tail;
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
            this.count--;
            return deletedNode.data;
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }

            LinkedNode<T> deleteNode = currentNode.next;
            currentNode.next = currentNode.next.next;
            currentNode.next.prev = currentNode;
            this.count--;
            return deleteNode.data;
        }
    }

    public T delete() {
        return this.delete(this.count - 1);
    }

    public void add(T data) {
        add(this.count, data);
    }

    public void clear() {
        this.head = null;
        this.count = 0;
    }

    public T get(int index) {
        if(validIndex(index)) {
            throw new IllegalArgumentException();
        }

        LinkedNode<T> currentNode = this.head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    public void print() {
        LinkedNode<T> currentNode = this.head;


        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    private boolean validIndex(int index) {
        return (index > this.count || index < 0);
    }

    public static class LinkedNode<T> {
        private T data;
        private LinkedNode next;
        private LinkedNode prev;

        public LinkedNode() {
            this.data = null;
            this.next = null;
            this.prev = null;
        }

        public LinkedNode(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public LinkedNode(T data, LinkedNode<T> next, LinkedNode<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
