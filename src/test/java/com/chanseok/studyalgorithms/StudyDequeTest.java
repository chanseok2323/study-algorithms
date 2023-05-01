package com.chanseok.studyalgorithms;

import org.junit.jupiter.api.Test;

class StudyDequeTest {

    @Test
    void deque_test() {
        StudyDeque<Integer> deque = new StudyDeque<>();
        System.out.println("isEmpty = " + deque.isEmpty());

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        deque.print();

        System.out.println("isEmpty = " + deque.isEmpty());

        deque.removeFirst();
        deque.print();
        deque.removeFirst();
        deque.print();
        deque.removeFirst();
        deque.print();

        System.out.println("isEmpty = " + deque.isEmpty());

        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
    }
}