package com.chanseok.studyalgorithms;

public class StudyDeque<T> {
    private StudyDoublyLinkedList<T> list;

    public StudyDeque() {
        this.list = new StudyDoublyLinkedList<T>();
    }

    public void print() {
        this.list.print();
    }

    public void addFirst(T data) {
        this.list.add(0, data);
    }

    public T removeFirst() {
        return this.list.delete(0);
    }

    public void addLast(T data) {
        this.list.add(this.list.getCount(), data);
    }

    public T removeLast() {
        return this.list.delete();
    }

    public boolean isEmpty() {
        return (this.list.getCount() == 0);
    }
}
