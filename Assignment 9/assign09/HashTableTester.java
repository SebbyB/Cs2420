package assign09;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTester {
	/**
	 * Class that tests various aspects of the HashTable class
	 * 
	 * this file requires helper methods that are currently commented out in 
	 * main class
	 * 
	 * 
	 * @author Amelia Nelson && Sebastian Barney
	 * @version November 16, 2022
	 */

    @Test
    void tableContainsKeyValue(){
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();
        //checks that put returns null if there is no previous value for the key
        for(int i = 0; i < 100; i++) {
        assertEquals(null,testTable.put(i,Integer.toString(i)));
        }
        for(int i = 0; i < 100; i++) {
        //checks that when a value is put into the table both the value and key
        //methods show them present
        assertTrue(testTable.containsValue(Integer.toString(i)));
        assertTrue(testTable.containsKey(i));
        }
        //checks that other random keys and values are not added on accident
        assertFalse(testTable.containsValue("-1"));
        assertFalse(testTable.containsKey(-1));
        assertFalse(testTable.containsValue("-5"));
        assertFalse(testTable.containsKey(-5));
        assertFalse(testTable.containsValue("100"));
        assertFalse(testTable.containsKey(100));
        assertFalse(testTable.containsValue("101"));
        assertFalse(testTable.containsKey(101));
        assertFalse(testTable.containsValue("150"));
        assertFalse(testTable.containsKey(150));
        assertFalse(testTable.containsValue("200"));
        assertFalse(testTable.containsKey(150));

    }
    
    @Test
    //Does all testing done on previous test except tests on negative keys and values
    void tableContainsKeyValueNegatives(){
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();
        for(int i = 0; i < 100; i++) {
        assertEquals(null,testTable.put(-i,Integer.toString(-i)));
        }
        for(int i = 0; i < 100; i++) {
        assertTrue(testTable.containsValue(Integer.toString(-i)));
        assertTrue(testTable.containsKey(-i));
        }
        assertFalse(testTable.containsValue("1"));
        assertFalse(testTable.containsKey(1));
        assertFalse(testTable.containsValue("5"));
        assertFalse(testTable.containsKey(5));
        assertFalse(testTable.containsValue("100"));
        assertFalse(testTable.containsKey(100));
        assertFalse(testTable.containsValue("101"));
        assertFalse(testTable.containsKey(101));
        assertFalse(testTable.containsValue("150"));
        assertFalse(testTable.containsKey(150));
        assertFalse(testTable.containsValue("200"));
        assertFalse(testTable.containsKey(150));
    }

    @Test
    void tablePutNItemsIntsStrings(){
    	//Tests that everything is funcitoning with intiger keys and string values
        int n = 1000;
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();
        for(int i = 1; i <= n; i++){
            int key = i;
            String value = Integer.toString(i);
            assertEquals(null,testTable.put(key,value));
            assertEquals(value,testTable.get(key));
            assertTrue(testTable.containsValue(value));
            assertTrue(testTable.containsKey(key));
        }
        assertEquals(n,testTable.size());

    }

    @Test
    void tablePutNItemsStringsStrings(){
    	//Tests that everything is funcitoning with string keys and string values
        int n = 1000;
        HashTable<String,String> testTable = new HashTable<String,String>();
        for(int i = 1; i <= n; i++){
            String value = Integer.toString(i);
            String key = Integer.toString(i);
            assertEquals(null,testTable.put(key,value));

            assertEquals(value,testTable.get(key));
            assertTrue(testTable.containsValue(value));
            assertTrue(testTable.containsKey(key));
        }
        assertEquals(n,testTable.size());

    }
    
    @Test
    void tablePutNItemsStringsInts(){
    	//Tests that everything is funcitoning with string keys and Integer values
        int n = 1000;
        HashTable<String,Integer> testTable = new HashTable<String,Integer> ();
        for(int i = 1; i <= n; i++){
            Integer value = i;
            String key = Integer.toString(i);
            assertEquals(null,testTable.put(key,value));

            assertEquals(value,testTable.get(key));
            assertTrue(testTable.containsValue(value));
            assertTrue(testTable.containsKey(key));
        }
        assertEquals(n,testTable.size());

    }



    @Test
    void worstCaseFixesItself() {
        HashTable<Integer, String> testTable = new HashTable<Integer, String> ();
    	//checks that in the worst case (multiple collisions on one hashkey) the table still functions
        int n = 99;
        for(int i = 0; i < n; i++){
        int key = 1 + 100*i;
        String value = Integer.toString(i);
            assertEquals(null,testTable.put(key,value));
            assertTrue(testTable.containsKey(key));
            assertTrue(testTable.containsValue(value));
            assertEquals(testTable.getCapacity(),100);
        }
        testTable.put((100*100+1),"100");
        assertNotEquals(100, testTable.getCapacity());

    }

    @Test
    void sizeChanges(){
    	//Checks that growth does not effect the previously tested functions ofthe hashtable
        HashTable<Integer, String> testTable = new HashTable<Integer, String>();
        int n = 1000;
        for(int i = 1; i <= n; i++){
            int key = i;
            String value = Integer.toString(i);
            assertEquals(null,testTable.put(key,value));
            assertTrue(testTable.containsKey(key));
            assertTrue(testTable.containsValue(value));
            assertEquals(i,testTable.size());
        }

        assertEquals(testTable.size(),n);
        testTable.remove(3);
        assertNotEquals(testTable.size(),n);
    }
    
    @Test
    void tableCapacityChangesSize(){
    	//Checks that capacity and size change appropriately as items are added
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();
        int sizeCurrent = 0;
        for(int i = 0; i < 99; i++) {
        assertEquals(null,testTable.put(i,Integer.toString(i)));
        assertEquals(100,testTable.getCapacity());
        sizeCurrent++;
        assertEquals(sizeCurrent,testTable.size());
        }
        //same checks after one expected growth
        for(int i = 100; i < 211; i++) {
        assertEquals(null,testTable.put(i,Integer.toString(i)));
        assertEquals(211,testTable.getCapacity());
        sizeCurrent++;
        assertEquals(sizeCurrent,testTable.size());
        }
        //checsk for after two expected growths
        for(int i = 211; i < 431; i++) {
        assertEquals(null,testTable.put(i,Integer.toString(i)));
        assertEquals(431,testTable.getCapacity());
        sizeCurrent++;
        assertEquals(sizeCurrent,testTable.size());
        }

    }

    @Test
    void entriesMethod(){
    	//Checsk that entries method is functioning correctly
        int n = 1000;
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();
        ArrayList<MapEntry<Integer,String>> testList = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            int key = i;
            String value = Integer.toString(i);
            assertEquals(null,testTable.put(key,value));
            assertEquals(value,testTable.get(key));
            assertTrue(testTable.containsValue(value));
            assertTrue(testTable.containsKey(key));
            testList.add(new MapEntry<>(key,value));
        }
        List<MapEntry<Integer,String>> list = testTable.entries();
        //End testing that all aspects of the expected final list and outputed list are the saem
        int size = list.size();
        assertEquals(size,testList.size());
        for(int i = 0; i < size; i++){
            assertEquals(list.get(i),testList.get(i));
        }
    }
    @Test
    void isEmptyMethod(){
    	//Tests that empty method can accurately tell if table is empty
        int n = 1000;
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();

        assertTrue(testTable.isEmpty());
        for(int i = 1; i <= n; i++){
            int key = i;
            String value = Integer.toString(i);
            assertEquals(null,testTable.put(key,value));
            assertEquals(value,testTable.get(key));
            assertTrue(testTable.containsValue(value));
            assertTrue(testTable.containsKey(key));
        }
        assertFalse(testTable.isEmpty());
        assertFalse(testTable.entries().isEmpty());


    }
    @Test
    void clearMethod(){
    	//Tests whether clear method is functioning correctly
        int n = 1000;
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();

        assertTrue(testTable.isEmpty());
        for(int i = 1; i <= n; i++){
            int key = i;
            String value = Integer.toString(i);
            assertEquals(null,testTable.put(key,value));
            assertEquals(value,testTable.get(key));
            assertTrue(testTable.containsValue(value));
            assertTrue(testTable.containsKey(key));
        }
        assertFalse(testTable.isEmpty());
        testTable.clear();
        assertTrue(testTable.isEmpty());
        assertTrue(testTable.entries().isEmpty());

    }
    @Test
    void backingArrGrows() {
    	//Checks that the backing array and behind the scenes values are correct
        HashTable<Integer, String> testTable = new HashTable<Integer, String>();
        int n = 99;
        for(int i = 0; i < n; i++){
            int key = i;
            String value = Integer.toString(i);
            assertEquals(null,testTable.put(key,value));
            assertTrue(testTable.containsKey(key));
            assertTrue(testTable.containsValue(value));
            assertEquals(testTable.getCapacity(),100);
            assertEquals(i+1,testTable.size());
        }
        testTable.put(100,"100");
        assertEquals(100,testTable.size());
        assertNotEquals(100, testTable.getCapacity());

    }

    @Test
    void removeItem(){
    	//Checks if remove works on singular individual value
        int n = 1000;
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();
        for(int i = 1; i <= n; i++) {
            int key = i;
            String value = Integer.toString(i);
            assertEquals(null, testTable.put(key, value));
            assertTrue(testTable.containsValue(value));
            assertTrue(testTable.containsKey(key));
            testTable.remove(key);
            assertFalse(testTable.containsValue(value));
            assertFalse(testTable.containsKey(key));
        }
        assertEquals(testTable.size(), 0);
    }
    
    @Test
    void removeItemMultiple(){
    	//Extensively tests remove funciton in consecutive steps
        int n = 199;
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();
        assertEquals(null, testTable.put(0, "0"));
        //Goes through each number from 1 to n-1, removing two numbers consecutively
        //and checking the function is correct
        for(int i = 1; i <= n -1; i++) {
            int key = i;
            int key2 = i + 1;
            String value = Integer.toString(i);
            String value2 = Integer.toString(i +1);
            assertEquals(1,testTable.size());
            assertEquals(null, testTable.put(key, value));
            assertTrue(testTable.containsValue(value));
            assertTrue(testTable.containsKey(key));
            assertEquals(null, testTable.put(key2, value2));
            assertTrue(testTable.containsValue(value2));
            assertTrue(testTable.containsKey(key2));
            assertEquals(3,testTable.size());
            assertTrue(value.equals(testTable.remove(key)));
            assertTrue(value2.equals(testTable.remove(key2)));
            assertFalse(testTable.containsValue(value));
            assertFalse(testTable.containsKey(key));
            assertFalse(testTable.containsValue(value2));
            assertFalse(testTable.containsKey(key2));
            assertEquals(1,testTable.size());
        }
        //Checks that specifically values at the end of a list are removed correctly
        //when deleted consecuqtively
        for(int i = n-1; i <= n; i++) {
            int key = i;
            int key2 = i + 1;
            String value = Integer.toString(i);
            String value2 = Integer.toString(i +1);
            assertEquals(null, testTable.put(key, value));
            assertTrue(testTable.containsValue(value));
            assertTrue(testTable.containsKey(key));
            assertEquals(null, testTable.put(key2, value2));
            assertTrue(testTable.containsValue(value2));
            assertTrue(testTable.containsKey(key2));
            assertTrue(value.equals(testTable.remove(key)));
            assertTrue(value2.equals(testTable.remove(key2)));
            assertFalse(testTable.containsValue(value));
            assertFalse(testTable.containsKey(key));
            assertFalse(testTable.containsValue(value2));
            assertFalse(testTable.containsKey(key2));
        }
        //Checks that values that are deleted right before empty and at empty are functioning
        assertTrue(testTable.containsValue("0"));
        assertTrue(testTable.containsKey(0));
        testTable.remove(0);
        assertFalse(testTable.containsValue("0"));
        assertFalse(testTable.containsKey(0));
        assertEquals(testTable.size(), 0);
        assertEquals(null,testTable.remove(0));
    }


    @Test
    void replaceItem(){
    	//Checks that items are correctly replaced when value with the same key is added
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();
        for(int i = 0; i < 10; i++){
        testTable.put(i,Integer.toString(i));
        assertEquals(Integer.toString(i),testTable.get(i));
        }
        String val = testTable.get(3);
        assertEquals(testTable.get(3),val);
        assertEquals(testTable.put(3,"100"),val);
        assertNotEquals(testTable.get(3),val);
    }
    
    @Test
    void replaceItemsConsecutively(){
    	//Tests that replacing items consecutively returns correct responses
        int n = 1000;
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();
        assertEquals(null, testTable.put(0, "0"));
        for(int i = 1; i <= n; i++) {
            int key = i;
            String value = Integer.toString(i);
            String value2 = Integer.toString(i +1);
            assertEquals(null, testTable.put(key, value));
            assertTrue(testTable.containsValue(value));
            assertFalse(testTable.containsValue(value2));
            assertTrue(testTable.containsKey(key));
            assertEquals(value, testTable.put(key, value2));
            assertTrue(testTable.containsValue(value2));
            assertTrue(testTable.containsKey(key));
            testTable.remove(i-1);
            assertFalse(testTable.containsValue(value));

        }
    }
    
    @Test
    void tableGetChanging(){
    	//Tests that the get function returns correct values over varying values
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();
        for(int i = 0; i < 99; i++) {
        assertEquals(null,testTable.put(i,Integer.toString(i)));
        assertEquals(Integer.toString(i),testTable.get(i));
        assertEquals(null,testTable.get(i+1));
        }
    }
}
