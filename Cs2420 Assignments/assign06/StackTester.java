//package assign06;
package com.assign05.assign06;


import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTester {



    LinkedListStack<Integer> createListDescendingIntsN(int min, int max, int increment){

        LinkedListStack<Integer> list = new LinkedListStack<>();
        for(int i = max; i >= min; i-= increment){
            list.push(i);
        }
        return list;
    }
    LinkedListStack<Integer> createListAscendingIntsN(int min, int max, int increment){

        LinkedListStack <Integer> list = new LinkedListStack<>();
        for(int i = min; i <= max; i+= increment){
            list.push(i);
        }
        return list;
    }



    /**************************************************************************/
    /* 							size tests                                    */
    /* 							     			   	   			              */
    /**************************************************************************/
    @Test
    void createEmptyStack(){
        LinkedListStack<Integer> list = new LinkedListStack<>();
        assertEquals(list.size(),0);
        assertTrue(list.isEmpty());
    }

    @Test
    void createStackSize1(){
        LinkedListStack list = createListAscendingIntsN(1,1,1);
        assertEquals(list.size(),1);
    }


    @Test
    void createStackSize100(){
        LinkedListStack list = createListAscendingIntsN(1,100,1);
        assertEquals(list.size(),100);
    }

    @Test
    void createStackSize1000(){
        LinkedListStack list = createListAscendingIntsN(1,1000,1);
        assertEquals(list.size(),1000);
    }

    @Test
    void createStackSize10000(){
        LinkedListStack list = createListAscendingIntsN(1,10000,1);
        assertEquals(list.size(),10000);
    }

    @Test
    void stackSizeIncrease(){
        LinkedListStack<Integer> list = new LinkedListStack<>();
        for(int i = 1; i <= 10; i++) {
            list.push(i);
            assertTrue(list.size() == i);
        }
    }


    /**************************************************************************/
    /* 							Push and Peek Tests                           */
    /* 							     			   	   			              */
    /**************************************************************************/


    @Test
    void push100(){

        LinkedListStack<Integer> list = new LinkedListStack<>();
        for(int i = 1; i <= 100; i++) {
            list.push(i);
            assertEquals(list.peek(),i);
            assertEquals(i,list.size());
        }
        assertEquals(list.size(),100);
    }


    @Test
    void pushAndPeek(){
        LinkedListStack<Integer> list = new LinkedListStack<>();
        for(int i = 1; i <= 10; i++) {
            list.push(i);
            assertEquals(list.peek(),i);
        }
    }

    @Test
    void peekAll(){
        LinkedListStack<Integer> list = createListAscendingIntsN(1,100,1);

        for(int i = list.size(); i > 0; i--){
            assertEquals(list.peek(),i);
            list.pop();
        }
    }

    @Test
    void PeekEmptyThenPushThenPeek(){
        LinkedListStack<Integer> list = new LinkedListStack<>();
        assertTrue(list.isEmpty());
        assertThrows(NoSuchElementException.class, () -> {list.peek();});
        list.push(1);
        assertEquals(list.peek(),1);
        assertFalse(list.isEmpty());
    }

    /**************************************************************************/
    /* 							Pop Tests                                     */
    /* 							     			   	   			              */
    /**************************************************************************/

    @Test
    void popHalf(){
        LinkedListStack<Integer> list = createListAscendingIntsN(1,100,1);

        int j = list.size();
        int end = list.size()/2;
        for(int i = end; i > 0; i--){

            assertEquals(list.pop(),j);
            j--;
            assertEquals(list.size(),j);
        }
        assertEquals(list.size(),end);

    }

    @Test
    void popAll(){
        LinkedListStack<Integer> list = createListAscendingIntsN(1,100,1);

        for(int i = list.size(); i > 0; i--){
            assertEquals(list.peek(),i);
            list.pop();
        }
        assertTrue(list.isEmpty());
    }


    @Test
    void PopEmpty(){
        LinkedListStack<Integer> list = new LinkedListStack<>();
        assertTrue(list.isEmpty());
        assertThrows(NoSuchElementException.class, () -> {list.pop();});
    }

    @Test
    void PopTooMany(){
        LinkedListStack<Integer> list = createListAscendingIntsN(1,100,1);

        for(int i = list.size(); i > 0; i--){
            assertEquals(list.peek(),i);
            list.pop();
        }
        assertTrue(list.isEmpty());

        assertThrows(NoSuchElementException.class, () -> {list.pop();});
    }


    /**************************************************************************/
    /* 							Clear Tests                                   */
    /* 							     			   	   			              */
    /**************************************************************************/



    @Test
    void clearExistingList(){
        LinkedListStack<Integer> list = createListAscendingIntsN(1,100,1);

        list.clear();
        assertTrue(list.isEmpty());

        assertThrows(NoSuchElementException.class, () -> {list.pop();});
    }


    @Test
    void clearThenPushThenClear(){
        LinkedListStack<Integer> list = createListAscendingIntsN(1,100,1);

        list.clear();
        assertTrue(list.isEmpty());

        assertThrows(NoSuchElementException.class, () -> {list.pop();});

        for(int j = 0; j < 10; j++){list.push(j);}
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

}
