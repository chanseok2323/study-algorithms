package com.chanseok.studyalgorithms;

public class StudyQueue<T> {
    private StudyDoublyLinkedList<T> list;

    public StudyQueue() {
        this.list = new StudyDoublyLinkedList<>();
    }

    public void enqueue(T data) {
        this.list.add(data);
    }

    public T dequeue() {
        return this.list.delete();
    }

    public T front() {
        return this.list.getTail();
    }

    public boolean isEmpty() {
        return (this.list.getCount() == 0);
    }
}
