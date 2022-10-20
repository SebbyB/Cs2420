//package assign06;
package com.assign05.assign06;



import java.util.NoSuchElementException;

public class LinkedListStack<E> implements Stack<E> {

    SinglyLinkedList<E> list;

     LinkedListStack(){
        list = new SinglyLinkedList<>();
    }


    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean isEmpty() {

        if(list.isEmpty()){
        return true;}
        return false;
    }

    @Override
    public E peek() throws NoSuchElementException {

        if(isEmpty()){throw new NoSuchElementException();}
        E data = list.getFirst();
        return data;

    }

    @Override
    public E pop() throws NoSuchElementException {
        if(isEmpty()){throw new NoSuchElementException();}
        E data = peek();

        list.deleteFirst();
        return data;
    }

    @Override
    public void push(E element) {

        list.insertFirst(element);
    }

    @Override
    public int size() {
        return list.size();
    }
}
