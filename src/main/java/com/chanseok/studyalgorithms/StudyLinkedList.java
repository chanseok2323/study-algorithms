package com.chanseok.studyalgorithms;

public class StudyLinkedList<T> {
    private LinkedNode<T> head;
    private int count = 0;

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
            this.head = newNode;
        } else {
            LinkedNode<T> currentNode = this.head;

            for(int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }

            newNode.next = currentNode.next;
            currentNode.next = newNode;
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
            this.head = this.head.next;
            this.count--;
            return deleteNode.data;
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }

            LinkedNode<T> deleteNode = currentNode.next;
            currentNode.next = currentNode.next.next;
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

        public LinkedNode() {
            this.data = null;
            this.next = null;
        }

        public LinkedNode(T data) {
            this.data = data;
            this.next = null;
        }

        public LinkedNode(T data, LinkedNode next) {
            this.data = data;
            this.next = next;
        }
    }
}
