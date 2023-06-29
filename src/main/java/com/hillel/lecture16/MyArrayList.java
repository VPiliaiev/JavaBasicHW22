package com.hillel.lecture16;

public class MyArrayList implements MyList {

    private static final int INITIAL_CAPACITY = 16;
    private String[] elements = new String[INITIAL_CAPACITY];
    private int size = 0;

    @Override
    public void addFirst(String value) {
        resize();
        System.arraycopy(elements, 0, elements, 1, size);
        elements[0] = value;
        size++;
    }

    @Override
    public void addLast(String value) {
        resize();
        elements[size] = value;
        size++;
    }

    @Override
    public void add(String value, int index) {
        validateIndex(index);
        resize();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = value;
        size++;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return elements[index];
    }

    @Override
    public void set(String value, int index) {
        validateIndex(index);
        elements[index] = value;
    }

    @Override
    public String delete(int index) {
        validateIndex(index);
        String deletedElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size - 1] = null;
        size--;
        return deletedElement;
    }

    @Override
    public void deleteLast() {
        if (size > 0) {
            elements[size - 1] = null;
            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        if (size >= elements.length) {
            String[] newElements = new String[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Wrong index");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}