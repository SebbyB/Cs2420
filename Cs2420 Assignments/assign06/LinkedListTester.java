package com.assign05.assign06;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTester {
	

    SinglyLinkedList<Integer> createListDescendingIntsN(int min, int max, int increment){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        for(int i = min; i <= max; i+= increment){
            list.insertFirst(i);
        }
        return list;
    }
    SinglyLinkedList<Integer> createListAscendingIntsN(int min, int max, int increment){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        for(int i = max; i >= min; i-= increment){
            list.insertFirst(i);
        }
        return list;
    }
    /**************************************************************************/
    /* 							size tests                                    */
    /* 							     			   	   			              */
    /**************************************************************************/
    @Test
    void emptySize(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        assertTrue(list.size() == 0);       
    }
    
    @Test
    void size0to100insertFirstDeleteFirst(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        assertTrue(list.size() == 0);  
        for (int i = 1; i < 101; i++) {
        	list.insertFirst(i);
            assertEquals(list.size(),i);  

        }
        for (int i = 100; i > 1; i--) {
            assertEquals(list.size(),i);  
        	assertEquals(list.deleteFirst(), i);
        }
        assertEquals(list.deleteFirst(),1);
        assertEquals(list.size(),0);  
//		assertThrows(NoSuchElementException.class, () -> {list.getFirst();});
		
    }
    @Test
    void size0to100insertIndexDeleteIndex(){
    SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
            assertTrue(list.size() == 0);  
            for (int i = 0; i < 100; i++) {
            list.insert(i,i);
            assertEquals(list.size(),i + 1);  

         }
            for (int i = 100; i > 1; i--) {
                assertEquals(list.size(),i);  
                assertEquals(list.delete(i-1),i-1);
            }
            assertEquals(list.delete(0),0);
            assertEquals(list.size(),0); 
             
    }

    /**************************************************************************/
    /* 					       get and getFirst tests                         */
    /* 							     			   	   			              */
    /**************************************************************************/

    @Test
    void GetOutOfBoundsBeginning(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.get(-1);});
        ;
    }
    
    @Test
    void GetOutOfBoundsEnd(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.get(12);});
        ;
    }
    
    @Test
    void getFirstWhileCreate(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();

        for(int i = 0; i < 100; i++){
            list.insertFirst(i);
            assertEquals(list.getFirst(),i);
            assertEquals(list.get(i),0);
            assertEquals(list.get(0),i);
        }
    }
    @Test
    void getFirstAfterCreate(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();

        for(int i = 0; i < 100; i++){
            list.insert(i,i);
            assertEquals(list.get(i),i);
        }
        assertEquals(list.getFirst(),0);
    }
    
    @Test
    void emptyGetFirst(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
//        assertThrows(NoSuchElementException.class, () -> {list.getFirst();});    
    }
    
    /**************************************************************************/
    /* 							emptyList tests                               */
    /* 							     			   	   			              */
    /**************************************************************************/


    @Test
    void createListEmpty(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        assertTrue(list.size() == 0);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.get(0);});
    }

    @Test
    void emptyExistingList(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,1000,2);
        assertTrue(list.size() != 0);
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.size() == 0);
        assertTrue(list.isEmpty());

    }
    /**************************************************************************/
    /* 							insertFirst tests                             */
    /* 							     			   	   			              */
    /**************************************************************************/

    @Test
    void list0to10(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        int index = 0;
        for(int i = 0; i <= 10; i++){
            assertEquals(list.get(index),i);
            index++;
        }
        assertTrue(list.size == index);
    }
    @Test
    void list0to100(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,100,1);
        int index = 0;
        for(int i = 0; i <= 100; i++){
            assertEquals(list.get(index),i);
            index++;
        }
        assertTrue(list.size == index);
    }

    @Test
    void list0to1000(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,1000,1);
        int index = 0;
        for(int i = 0; i <= 1000; i++){
            assertEquals(list.get(index),i);
            index++;
        }
        assertTrue(list.size == index);
    }
    @Test
    void list10to100(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(10,100,1);
        int index = 0;
        for(int i = 10; i <= 100; i++){
            assertEquals(list.get(index),i);
            index++;
        }
        assertTrue(list.size == index);
    }

    @Test
    void list10to0(){
        SinglyLinkedList<Integer> list = createListDescendingIntsN(0,10,1);
        int index = 0;
        for(int i = 10; i >= 0; i--){
        assertEquals(list.get(index),i);
        index++;
        }
        assertTrue(list.size == index);

    }
    @Test
    void list100to0(){
        SinglyLinkedList<Integer> list = createListDescendingIntsN(0,100,1);
        int index = 0;
        for(int i = 100; i >= 0; i--){
            assertEquals(list.get(index),i);
            index++;
        }
        assertTrue(list.size == index);

    }

    @Test
    void list1000to10(){
        SinglyLinkedList<Integer> list = createListDescendingIntsN(10,1000,1);
        int index = 0;
        for(int i = 1000; i >= 10; i--){
            assertEquals(list.get(index),i);
            index++;
        }
        assertTrue(list.size == index);

    }
    
    /**************************************************************************/
    /* 							insertIndex tests                             */
    /* 							     			   	   			              */
    /**************************************************************************/

    @Test
    void insertOutOfBoundsBeginning(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.insert(-1,1);});
    }
    @Test
    void insertOutOfBoundsEnd(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.insert(12,1);});
    }
    @Test
    void insertMiddle(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        int n = list.size();
        list.insert(5,1);
        assertEquals(list.get(5),1);
        assertTrue(list.size() == (n + 1));
    }
    @Test
    void insertFirst(){

        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        int n = list.size();
        list.insert(0,1);
        assertEquals(list.get(0),1);
        assertTrue(list.size() == (n + 1));
    }
    
    @Test
    void insertSecond(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        int n = list.size();
        list.insert(1,12);
        assertEquals(list.get(1),12);
        assertTrue(list.size() == (n + 1));
    }
    @Test
    void insertSecondToLast(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        int n = list.size();
        list.insert(10,12);
        assertEquals(list.get(10),12);
        assertTrue(list.size() == (n + 1));
    }
    
    @Test
    void insertLast(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        int n = list.size();
        list.insert(11,1);
        assertEquals(list.get(11),1);
        assertTrue(list.size() == (n + 1));
    }
    /**************************************************************************/
    /* 							deleteIndex tests                             */
    /* 							     			   	   			              */
    /**************************************************************************/

    @Test
    void deleteOutOfBoundsBeginning(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.delete(-1);});
        ;
    }
    @Test
    void deleteOutOfBoundsEnd(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.delete(12);});
        ;
    }
    @Test
    void removeMiddle(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        int n = list.size();
        int comp = list.get(5);
        int afterComp = list.get(6);
        list.delete(5);
        assertFalse(comp == list.get(5));
        assertEquals(list.get(5), afterComp);
    }

    @Test
    void removeFirst(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        int n = list.size();
        int comp = list.get(0);
        int afterComp = list.get(1);
        list.delete(0);
        assertFalse(comp == list.get(0));
        assertTrue(list.size() == (n - 1));
        assertEquals(list.get(0), afterComp);
    }
    @Test
    void removeSecond(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        int n = list.size();
        int comp = list.get(1);
        int afterComp = list.get(2);
        list.delete(1);
        assertFalse(comp == list.get(0));
        assertTrue(list.size() == (n - 1));
        assertEquals(list.get(1), afterComp);
    }
    
    @Test
    void removeSecondToLast(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        int n = list.size();
        int comp = list.get(9);
        int afterComp = list.get(10);
        list.delete(9);
        assertFalse(comp == list.get(9));
        assertTrue(list.size() == (n - 1));
        assertEquals(list.get(9), afterComp);
    }

    @Test
    void removeLast(){
        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        int n = list.size();
        int afterComp = list.get(9);
        list.delete(10);
        assertTrue(list.size() == (n - 1));
        assertEquals(list.get(9), afterComp);
    }

    /**************************************************************************/
    /* 							deleteFirst tests                             */
    /* 							     			   	   			              */
    /**************************************************************************/

    @Test
    void emptyDeleteFirst(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
//        assertThrows(NoSuchElementException.class, () -> {list.deleteFirst();});    
    }
    @Test
    void removeOne(){

        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        int initSize = list.size();
        int deletedData = list.deleteFirst();
        assertEquals(0,deletedData);
        assertTrue(initSize != list.size());


    }
    
    @Test
    void removeFive(){

        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,5,1);
        
        for(int i = 0; i <= 5; i++){
        int deletedData = list.deleteFirst();
        assertEquals(6 - (i +1),list.size());
        assertEquals(i,deletedData);}
        
        assertTrue(6 != list.size());


    }
    @Test
    void removeAll(){

        SinglyLinkedList<Integer> list = createListAscendingIntsN(0,10,1);
        int initSize = list.size();
        for(int i = 0; i <= 10; i++){
            int deletedData = list.deleteFirst();
            assertEquals(initSize - (i+1) , list.size());
            assertEquals(i,deletedData);}
        assertTrue(initSize != list.size());
        assertTrue(list.isEmpty());
    }
    /**************************************************************************/
    /* 							Iterator tests                             */
    /* 							     			   	   			              */
    /**************************************************************************/
    @Test
    void IteratorEmpty(){
    	
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        Iterator<Integer>  iter = list.iterator();
        assertTrue(list.isEmpty());
        assertFalse(iter.hasNext());
        assertEquals(list.size(),0);
        
    }
    @Test
    void IteratorAddRemoveOne(){
    	
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        list.insertFirst(0);
        Iterator<Integer>  iter = list.iterator();
        assertTrue(iter.hasNext());
        assertEquals(0, iter.next());
        assertFalse(iter.hasNext());
        iter.remove();
        assertTrue(list.isEmpty());
        assertEquals(list.size(),0);
    }
    @Test
    void IteratorAddMultiple(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        list.insertFirst(0);
        list.insertFirst(10);
        Iterator<Integer>  iter = list.iterator();
        assertTrue(iter.hasNext());
        assertEquals(10, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(0, iter.next());
        assertFalse(iter.hasNext());
      
    }
    @Test
    void IteratorRemoveBeginning(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        list.insertFirst(0);
        list.insertFirst(1);        
        list.insertFirst(2);
        list.insertFirst(3);       
        list.insertFirst(4);
        Iterator<Integer>  iter = list.iterator();
        assertEquals(iter.next(),4);
        iter.remove();
        assertThrows(IllegalStateException.class, () -> {iter.remove();});
        assertEquals(list.get(0),3);
        assertEquals(list.size,4);
        
    }
    @Test
    void IteratorRemoveEnd(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        list.insertFirst(0);
        list.insertFirst(1);        
        list.insertFirst(2);
        list.insertFirst(3);       
        list.insertFirst(4);
        Iterator<Integer>  iter = list.iterator();
        for(int i = 0; i<5; i++){
        iter.next();
        }
        iter.remove();
        assertEquals(list.get(3),1);
        assertEquals(list.size,4);
        
    }
    @Test
    void IteratorRemoveMiddle(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        list.insertFirst(0);
        list.insertFirst(1);        
        list.insertFirst(2);
        list.insertFirst(3);       
        list.insertFirst(4);
        Iterator<Integer>  iter = list.iterator();
        for(int i = 0; i<3; i++){
        iter.next();
        }
        iter.remove();
        assertEquals(list.get(2),1);
        assertEquals(list.size,4);
        
    }

    @Test
    void IteratorRemoveEntireList(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        list.insertFirst(0);
        list.insertFirst(1);        
        list.insertFirst(2);
        list.insertFirst(3);       
        list.insertFirst(4);

        int i = 0;
        while(i < 5){
        Iterator<Integer>  iter = list.iterator();
        iter.next();
        int m = list.get(0);
        assertEquals(list.get(0),4-(i));
        iter.remove();
        assertEquals(list.size,5-(i+1));
        i++;
        }
        assertTrue(list.isEmpty());
    }
    @Test
    void IteratorRemoveFirst(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        list.insertFirst(0);
        list.insertFirst(10);
        Iterator<Integer>  iter = list.iterator();
        assertThrows(IllegalStateException.class, () -> {iter.remove();});
        
    }
    @Test
    void IteratorRemoveTwice(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        list.insertFirst(0);
        list.insertFirst(10);
        Iterator<Integer>  iter = list.iterator();
        iter.next();
        iter.next();
 //       assertEquals(10,iter.remove());
        iter.remove();
        
        assertThrows(IllegalStateException.class, () -> {iter.remove();});
        assertEquals(list.size(),1);
        assertEquals(list.get(0),10);
        
    }
    @Test
    void IteratorRemoveEveryOtherList(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        list.insertFirst(0);
        list.insertFirst(1);        
        list.insertFirst(2);
        list.insertFirst(3);       
        list.insertFirst(4);
        list.insertFirst(5);
        Iterator<Integer>  iter = list.iterator();
        for(int i = 0; i<3; i++){
        iter.next();
        iter.next();
        iter.remove();
        }
        assertEquals(list.get(0),5);
        assertEquals(list.get(1),3);
        assertEquals(list.get(2),1);
        assertEquals(list.size,3);

 //       assertEquals(10,iter.remove());   
    }
    /**************************************************************************/
    /* 							IndexOf tests                                 */
    /* 							     			   	   			              */
    /**************************************************************************/
    
    @Test
    void IndexGeneral(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        for(int i = 0; i< 5; i++) {
        list.insertFirst(i);
        }
        for(int i = 0; i< 5; i++) {
        assertEquals(list.indexOf(i), 5-(i+1));
        	}
        }
    @Test
    void IndexOutOfBounds(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        for(int i = 0; i< 5; i++) {
        list.insertFirst(i);
        }
        assertEquals(list.indexOf(-1),-1);
        assertEquals(list.indexOf(-2),-1);
        assertEquals(list.indexOf(5),-1);
        assertEquals(list.indexOf(6),-1);
    }
    
    /**************************************************************************/
    /* 							toArray tests                                 */
    /* 							     			   	   			              */
    /**************************************************************************/
    
    
    @Test
    void toArrayEmpty(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        Object[] finalArray = new Object[0];
        assertEquals(list.toArray().length,finalArray.length);
    }
    @Test
    void toArrayOne(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        list.insertFirst(1);
        Object[] finalArray = new Object[1];
        finalArray[0]= 1;
        assertEquals(list.toArray().length,finalArray.length);
        assertEquals(list.toArray()[0],finalArray[0]);
    }
    @Test
    void toArrayHundreds(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        for(int i = 0; i < 200; i++) {
        list.insert(i,i);
        }
        Object[] finalArray = new Object[200];
        for(int i = 0; i < 200; i++) {
        finalArray[i]= i;
        }
        assertEquals(list.toArray().length,finalArray.length);
        for(int i = 0; i < 200; i++) {
        assertEquals(list.toArray()[i],finalArray[i]);
        }
    }
    /**************************************************************************/
    /* 							clear tests                                 */
    /* 							     			   	   			              */
    /**************************************************************************/
    @Test
    void clearEmpty(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        assertTrue(list.size() == 0);
        list.clear();
        assertTrue(list.size() == 0);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.get(0);});
        ;
        
    }
    
    void clearOne(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        list.insertFirst(1);
        assertTrue(list.size() == 1);
        list.clear();
        assertTrue(list.size() == 0);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.get(0);});
        ;
    }
    
    void clearHundreds(){
        SinglyLinkedList <Integer> list = new SinglyLinkedList<Integer>();
        for(int i = 0 ; i < 200; i++) {
        list.insertFirst(i);
        }
        assertTrue(list.size() == 200);
        list.clear();
        assertTrue(list.size() == 0);
        assertThrows(IndexOutOfBoundsException.class, () -> {list.get(0);});
        ;
    }
    
    

}
