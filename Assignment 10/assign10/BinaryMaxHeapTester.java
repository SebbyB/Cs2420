package assign10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BinaryMaxHeap Tests
 * By @Authors Sebastian Barney and Amelia Neilson.
 */
public class BinaryMaxHeapTester {

    @Test
    void addTestingInOrder() {
        BinaryMaxHeap<Integer> tester = new BinaryMaxHeap<Integer>();
        for (int i = 10; i > 0; i--) {
            tester.add(i);
        }
        Object[] results = tester.getBackingArray();
        for (int i = 0; i < 10; i++) {
            assertEquals(10 - i, (Integer) results[i]);
        }
    }

    @Test
    void addTestingOutOfOrderPercolate() {
        BinaryMaxHeap<Integer> tester = new BinaryMaxHeap<Integer>();
        tester.add(1);
        tester.add(8);
        tester.add(6);
        tester.add(2);
        tester.add(3);
        tester.add(5);
        tester.add(9);
        Object[] results = tester.getBackingArray();
        assertEquals(9, results[0]);
        assertEquals(3, results[1]);
        assertEquals(8, results[2]);
        assertEquals(1, results[3]);
        assertEquals(2, results[4]);
        assertEquals(5, results[5]);
        assertEquals(6, results[6]);
    }

    @Test
    void resizingSizeTests() {
        BinaryMaxHeap<Integer> tester = new BinaryMaxHeap<Integer>();
        Object[] results = tester.getBackingArray();
        //Checks for correct size and backing array in beginning
        assertEquals(10, results.length);
        assertEquals(0, tester.size());
        //Checks that size appropriately grows
        for (int i = 0; i < 10; i++) {
            tester.add(i);
            assertEquals(i + 1, tester.size());
            results = tester.getBackingArray();
            assertEquals(10, results.length);
        }
        //Checks that size appropriately grows as does the backing array
        for (int i = 0; i < 10; i++) {
            tester.add(i);
            assertEquals(i + 11, tester.size());
            results = tester.getBackingArray();
            assertEquals(20, results.length);
        }
        //Last check that backing array repetitively grows as expected
        tester.add(21);
        assertEquals(21, tester.size());
        results = tester.getBackingArray();
        assertEquals(40, results.length);
//Checks that removal affects size appropriately
        for (int i = 20; i > 10; i--) {
            tester.extractMax();
            assertEquals(i, tester.size());
        }
        //Checks that size works appropriately after/alongside removal
        for (int i = 0; i < 5; i++) {
            assertEquals(11, tester.size());
            tester.add(i);
            assertEquals(12, tester.size());
            tester.extractMax();
            assertEquals(11, tester.size());
        }
//        Checks that size functions all the way to complete removal
        for (int i = 11; i > 0; i--) {
            assertEquals(i, tester.size());
            tester.extractMax();


        }
    }

    @Test
    void clearAndIsEmpty() {
        int n = 100;
        BinaryMaxHeap<Integer> testHeap = new BinaryMaxHeap<>();

        assertTrue(testHeap.isEmpty());
        assertEquals(testHeap.size(), 0);
        for (int i = 0; i < n; i++) {
            testHeap.add(i);
            assertFalse(testHeap.isEmpty());
            assertNotEquals(testHeap.size(), 0);
        }
        assertFalse(testHeap.isEmpty());
        assertNotEquals(testHeap.size(), 0);
        testHeap.clear();
        assertTrue(testHeap.isEmpty());
        assertEquals(testHeap.size(), 0);

    }


    @Test
    void extractMaxOutOfOrder() {
        BinaryMaxHeap<Integer> tester = new BinaryMaxHeap<Integer>();
        tester.add(1);
        tester.add(8);
        tester.add(6);
        tester.add(2);
        tester.add(3);
        tester.add(5);
        tester.add(9);
        System.out.println(Arrays.toString(tester.toArray()));
        assertEquals(9, tester.extractMax());
        System.out.println(Arrays.toString(tester.toArray()));

        assertEquals(8, tester.extractMax());
        System.out.println(Arrays.toString(tester.toArray()));

        assertEquals(6, tester.extractMax());
        System.out.println(Arrays.toString(tester.toArray()));

        assertEquals(5, tester.extractMax());
        assertEquals(3, tester.extractMax());
        assertEquals(2, tester.extractMax());
        assertEquals(1, tester.extractMax());
    }

    @Test
    void toArrayInOrderTests() {
        BinaryMaxHeap<Integer> tester = new BinaryMaxHeap<Integer>();
        for (int i = 10; i > 0; i--) {
            tester.add(i);
        }
        Object[] checker = new Object[10];
        for (int i = 10; i > 0; i--) {
            checker[10 - i] = i;
        }
        Object[] results = tester.toArray();
        for (int i = 0; i < 10; i++) {
            assertEquals(checker[i], results[i]);
        }
    }

    @Test
    void toArrayOutOfOrderTests() {
        BinaryMaxHeap<Integer> tester = new BinaryMaxHeap<Integer>();
        tester.add(1);
        tester.add(8);
        tester.add(6);
        tester.add(2);
        tester.add(3);
        tester.add(5);
        tester.add(9);
        Object[] checker = new Object[7];
        checker[0] = 9;
        checker[1] = 3;
        checker[2] = 8;
        checker[3] = 1;
        checker[4] = 2;
        checker[5] = 5;
        checker[6] = 6;
        Object[] results = tester.toArray();
        for (int i = 0; i < 7; i++) {
            assertEquals(checker[i], results[i]);
        }


    }
}
