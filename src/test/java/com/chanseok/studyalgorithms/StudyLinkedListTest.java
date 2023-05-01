package com.chanseok.studyalgorithms;

import org.junit.jupiter.api.Test;

class StudyLinkedListTest {

    @Test
    void study_linked_insertAt() {
        StudyLinkedList<Integer> list = new StudyLinkedList<>();
        list.add(0, 0);
        list.add(1, 1);
        list.add(2, 2);
        list.add(3, 3);
        list.add(4, 4);

        list.add(5);
        list.add(6);

        list.print();

        list.delete(0);
        list.delete();
        list.delete();

        list.print();
    }
}