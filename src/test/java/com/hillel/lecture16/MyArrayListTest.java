package com.hillel.lecture16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyArrayListTest {
    private MyArrayList list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList();
    }

    @Test
    void emptyList() {
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(0, list.size());
        Assertions.assertEquals("", list.toString());
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.get(5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.set("value", 5));
    }

    @Test
    void addLast() {
        for (int i = 0; i < 5; i++) {
            list.addLast("element#" + i);
        }
        String[] expected = {"element#0", "element#1", "element#2", "element#3", "element#4"};

        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(5, list.size());
        Assertions.assertEquals("element#0, element#1, element#2, element#3, element#4", list.toString());
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], list.get(i));
        }
    }

    @Test
    void addFirst() {
        for (int i = 0; i < 5; i++) {
            list.addFirst("element#" + i);
        }
        String[] expected = {"element#4", "element#3", "element#2", "element#1", "element#0"};

        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(5, list.size());
        Assertions.assertEquals("element#4, element#3, element#2, element#1, element#0", list.toString());
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], list.get(i));
        }
    }

    @Test
    void add() {
        for (int i = 0; i < 5; i++) {
            list.addLast("element#" + i);
        }
        String[] expected = {"element#0", "element#1", "qwerty", "element#2", "element#3", "element#4"};

        list.add("qwerty", 2);

        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(6, list.size());
        Assertions.assertEquals("element#0, element#1, qwerty, element#2, element#3, element#4", list.toString());
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], list.get(i));
        }
    }

    @Test
    void delete() {
        for (int i = 0; i < 5; i++) {
            list.addLast("element#" + i);
        }
        String[] expected = {"element#0", "element#1", "element#3", "element#4"};

        String deletedElement = list.delete(2);

        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(4, list.size());
        Assertions.assertEquals("element#0, element#1, element#3, element#4", list.toString());
        Assertions.assertEquals("element#2", deletedElement);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], list.get(i));
        }
    }
}
