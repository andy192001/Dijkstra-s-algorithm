package com.company;

// Кастомна черга. Нічого особливого, почитати про чергу можна тут https://javarush.com/quests/lectures/jru.module1.lecture23
public class Queue<T> {

    private Object[] elements;
    private static final int capacityDefault = 5;
    private int size;

    public Queue(int capacity){
        elements = new Object[capacity];
    }

    public Queue(){
        elements = new Object[capacityDefault];
    }

    public T get(int index){
        return (T) elements[index];
    }

    public void add(T e){
        if(e == null){
            throw new NullPointerException();
        }

        if(size == capacityDefault){
            resizeGrow();
        }
        elements[size] = e;
        size++;
    }

    private void resizeGrow() {
        Object[] arr = new Object[elements.length * 2];
        System.arraycopy(elements, 0, arr, 0, size);
        elements = arr;
    }

    private void resizeCut() {
        Object[] arr = new Object[elements.length - 1];
        System.arraycopy(elements, 1, arr, 0, size - 1);
        elements = arr;
    }

    public T poll(){
        T el = (T) elements[0];
        resizeCut();
        size--;
        return el;
    }

    public int size(){
        return size;
    }


}
