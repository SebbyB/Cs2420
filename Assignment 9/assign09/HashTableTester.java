


package assign09;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTester {
	

    @Test
    void tableContainsKeyValue(){
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();
        for(int i = 0; i < 100; i++) {
        assertEquals(null,testTable.put(i,Integer.toString(i)));
        }
        for(int i = 0; i < 100; i++) {
        assertTrue(testTable.containsValue(Integer.toString(i)));
        assertTrue(testTable.containsKey(i));
        }
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
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();
        int sizeCurrent = 0;
        for(int i = 0; i < 99; i++) {
        assertEquals(null,testTable.put(i,Integer.toString(i)));
        assertEquals(100,testTable.getCapacity());
        sizeCurrent++;
        assertEquals(sizeCurrent,testTable.size());
        }
        for(int i = 100; i < 211; i++) {
        assertEquals(null,testTable.put(i,Integer.toString(i)));
        assertEquals(211,testTable.getCapacity());
        sizeCurrent++;
        assertEquals(sizeCurrent,testTable.size());
        }
        for(int i = 211; i < 431; i++) {
        assertEquals(null,testTable.put(i,Integer.toString(i)));
        assertEquals(431,testTable.getCapacity());
        sizeCurrent++;
        assertEquals(sizeCurrent,testTable.size());
        }

    }

    @Test
    void entriesMethod(){
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

        int size = list.size();
        assertEquals(size,testList.size());
        for(int i = 0; i < size; i++){
            assertEquals(list.get(i),testList.get(i));
        }
    }
    @Test
    void isEmptyMethod(){
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
        int n = 199;
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();
        assertEquals(null, testTable.put(0, "0"));
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
        HashTable<Integer,String> testTable = new HashTable<Integer,String>();
        for(int i = 0; i < 99; i++) {
        assertEquals(null,testTable.put(i,Integer.toString(i)));
        assertEquals(Integer.toString(i),testTable.get(i));
        assertEquals(null,testTable.get(i+1));
        }
    }
}
