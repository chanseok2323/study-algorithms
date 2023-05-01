package com.chanseok.studyalgorithms;

public class StudyStack<T> {
    private StudyLinkedList<T> list;

    public StudyStack() {
        this.list = new StudyLinkedList<>();
    }

    public void push(T data) {
        list.add(0, data);
    }

    public T pop() {
        return this.list.delete(0);
    }

    public T peek() {
        return this.list.get(0);
    }

    public boolean isEmpty() {
        return (this.list.getCount() == 0);
    }
}
