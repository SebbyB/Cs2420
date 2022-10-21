//package assign06;
package com.assign05.assign06;



/**
 * This interface specifies the general behavior of a last-in-first-out (LIFO)
 * stack of elements.
 *
 * @author Erin Parker
 * @version March 3, 2021
 *
 * @param <E> - the type of elements contained in the stack
 */

import java.util.NoSuchElementException;

/**
 * Stack Data Structure implemented with LinkedList
 * @author Sebastian Barney, Amelia Neilson.
 * @version October 20th, 2022
 *
 * @param <E> - the type of elements contained in the stack
 */
public class LinkedListStack<E> implements Stack<E> {

    SinglyLinkedList<E> list;


    /**
     * Constructor for LinkedListStack Class. Creates an Empty Linked List.
     */
    LinkedListStack(){
        list = new SinglyLinkedList<>();
    }


    /**
     * Clears the Stack. Sets the list to an empty list.
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Checks if the stack is empty.
     * @return - true if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {

        if(list.isEmpty()){
        return true;}
        return false;
    }

    /**
     * Checks the top item of the stack.
     * @return - The value of the top item of the stack.
     * @throws NoSuchElementException - If there is nothing in the stack there is nothing to peek. Throws NoSuchElementException.
     */
    @Override
    public E peek() throws NoSuchElementException {

        if(isEmpty()){throw new NoSuchElementException();}
        E data = list.getFirst();
        return data;

    }

    /**
     * Deletes the top Element of the Stack.
     * @return Value of the Popped Item.
     * @throws NoSuchElementException - If there is nothing in the stack there is nothing to pop. Throws NoSuchElementException.
     */
    @Override
    public E pop() throws NoSuchElementException {
        if(isEmpty()){throw new NoSuchElementException();}
        E data = peek();

        list.deleteFirst();
        return data;
    }

    /**
     * Adds an Element to the top of the Stack.
     * @param element - the element to be added to the stack.
     */
    @Override
    public void push(E element) {

        list.insertFirst(element);
    }

    /**
     * gets the Size of the stack (How many elements are in the stack)
     * @return - an Integer representation of how many Elements are in the stack.
     */
    @Override
    public int size() {
        return list.size();
    }
}
