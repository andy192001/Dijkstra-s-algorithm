package com.company;

// Кастомна черга. Нічого особливого, почитати про чергу можна тут https://javarush.com/quests/lectures/jru.module1.lecture23
public class QueueCustom<T> {

    private Object[] elements;
    private int size;

    public QueueCustom(){
        elements = new Object[1];
    }

    public T get(int index){
        return (T) elements[index];
    }

    public void add(T e){
        if(e == null){
            throw new NullPointerException();
        }
        if(size >= 1){
            resizeGrow();
        }
        elements[size] = e;
        size++;
    }

    private void resizeGrow() {
        Object[] arr = new Object[elements.length + 1];
        for(int i = 0; i < elements.length; i++){
            arr[i] = elements[i];
        }
        elements = arr;
    }

    private void resizeCut() {
        Object[] arr = new Object[elements.length - 1];
        for (int i = 0; i < elements.length - 1; i++) {
            arr[i] = elements[i + 1];
        }
        elements = arr;
    }

    public T poll(){
        T el = (T) elements[0];
        resizeCut();
        if(size == 1){
            elements = new Object[1];
        }
        size--;
        return el;
    }

    public int size(){
        return size;
    }


}
