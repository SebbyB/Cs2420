package assign09;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
            assertEquals(value,testTable.put(key,value));
            System.out.println(testTable.currLambda());


//            System.out.println(testTable.get(key));
//            assertEquals(value,testTable.get(key));
            assertTrue(testTable.containsValue(value));
            assertTrue(testTable.containsKey(key));

//            testTable.put(key,value);
        }

        System.out.println(testTable.currLambda());
        System.out.println(testTable.getCapacity());
        System.out.println(testTable.size());
        assertEquals(n,testTable.size());

    }

//    @Test
//    void tablePutNItemsStringsStrings(){
//
//        int n = 101;
//        HashTable<String,String> testTable = new HashTable();
//        for(int i = 1; i <= n; i++){
//            String value = Integer.toString(i);
//            String key = Integer.toString(i);
//            assertEquals(value,testTable.put(key,value));
//            assertEquals(value,testTable.get(key));
//            assertTrue(testTable.containsValue(value));
//            assertTrue(testTable.containsKey(key));
//
////            testTable.put(key,value);
//        }
//
//        assertEquals(n,testTable.size());
//
//    }



    @Test
    void doStuff() {
        HashTable<Integer, String> testTable = new HashTable();

        assertEquals("1", testTable.put(1, "1"));
        assertEquals("2", testTable.put(101, "2"));
        assertEquals("3", testTable.put(201, "3"));
        System.out.println(testTable.get(1));
        System.out.println(testTable.get(101));
        System.out.println(testTable.get(201));


    }
}
