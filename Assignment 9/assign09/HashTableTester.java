package assign09;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTester {

    @Test
    void tableContainsKeyValue(){
        HashTable<Integer,String> testTable = new HashTable();
        testTable.put(1,"1");
        assertTrue(testTable.containsValue("1"));
        assertTrue(testTable.containsKey(1));
    }

    @Test
    void tablePutNItemsIntsStrings(){

        int n = 1000;
        HashTable<Integer,String> testTable = new HashTable();
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

        int n = 1000;
        HashTable<String,String> testTable = new HashTable();
        for(int i = 1; i <= n; i++){
            String value = Integer.toString(i);
            String key = Integer.toString(i);
            assertEquals(null,testTable.put(key,value));

            assertEquals(value,testTable.get(key));
            assertTrue(testTable.containsValue(value));
            assertTrue(testTable.containsKey(key));

//            testTable.put(key,value);
        }

        assertEquals(n,testTable.size());

    }



    @Test
    void worstCaseFixesItself() {
        HashTable<Integer, String> testTable = new HashTable();

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
        HashTable<Integer, String> testTable = new HashTable();

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
    void entriesMethod(){
        int n = 1000;
        HashTable<Integer,String> testTable = new HashTable();
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

        int size = list.size();
        assertEquals(size,testList.size());
        for(int i = 0; i < size; i++){
            assertEquals(list.get(i),testList.get(i));
        }
    }
    @Test
    void isEmptyMethod(){
        int n = 1000;
        HashTable<Integer,String> testTable = new HashTable();

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
        int n = 1000;
        HashTable<Integer,String> testTable = new HashTable();

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
        HashTable<Integer, String> testTable = new HashTable();

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

        int n = 1000;
        HashTable<Integer,String> testTable = new HashTable();
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
    void replaceItem(){
        HashTable<Integer,String> testTable = new HashTable();
        for(int i = 0; i < 10; i++){
        testTable.put(i,Integer.toString(i));
        assertEquals(Integer.toString(i),testTable.get(i));
        }
        String val = testTable.get(3);
        assertEquals(testTable.get(3),val);
        assertEquals(testTable.put(3,"100"),val);
        assertNotEquals(testTable.get(3),val);
    }


}
