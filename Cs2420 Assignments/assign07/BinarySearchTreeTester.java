//package assign07;
package com.assign05.assign07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class BinarySearchTreeTester {


    public static String seperate = "===========================================================\n===========================================================";

    int N = 100;



    /**************************************************************************/
    /* 							empty tests                                   */
    /* 							     			   	   			              */
    /**************************************************************************/
    @Test
    void checkEmptyTree(){
        BinarySearchTree<Integer> testTree = new BinarySearchTree<>();
        Assertions.assertTrue(testTree.isEmpty());
        testTree.add(1);
        Assertions.assertTrue(testTree.size() != 0);
        Assertions.assertFalse(testTree.isEmpty());
        testTree.clear();
        Assertions.assertTrue(testTree.size() == 0);
        Assertions.assertTrue(testTree.isEmpty());
    }

    @Test
    void clearTree(){
        BinarySearchTree<Integer> testTree = new BinarySearchTree<>();

        for(int i = 0; i <= N; i++) {
            Assertions.assertTrue(testTree.isEmpty());
            testTree.add(i);
            Assertions.assertTrue(testTree.size() != 0);

            Assertions.assertFalse(testTree.isEmpty());
            testTree.clear();
            Assertions.assertFalse(testTree.size() != 0);
            Assertions.assertTrue(testTree.isEmpty());
        }

    }



    /**************************************************************************/
    /* 							size tests                                    */
    /* 							     			   	   			              */
    /**************************************************************************/


    /**
     * Tests size() method for our BinarySearchTree Class implementation.
     */
    @Test
    void sizeChangeAccurate(){
        /**
         * Initializes an empty tree. Loops to N, adding to the tree each loop and checking if the size increases.
         * After N is reached, checks if size of tree is N.
         * Loops to 0, removing from tree each loop and checking if the size decreases.
         * After 0 is reached, checks if size is 0 / isEmpty.
         * Adds one element to the tree. Checks if size is 1 / !isEmpty.
         * Removes element. Checks if size is 0 / isEmpty
         */
        BinarySearchTree<Integer> testTree = new BinarySearchTree<>();
        for(int j = 1; j <= N; j++){
            Assertions.assertTrue(testTree.add(j));
            Assertions.assertEquals(testTree.size(), j);
        }
        Assertions.assertEquals(testTree.size(),N);
        for(int i = N; i >= 0; i--){
            Assertions.assertTrue(testTree.add(i));
            Assertions.assertEquals(testTree.size(), i);
        }
        Assertions.assertEquals(0, testTree.size());
        Assertions.assertTrue(testTree.isEmpty());
        testTree.add(1);
        Assertions.assertEquals(testTree.size(),1);
        Assertions.assertFalse(testTree.isEmpty());
        testTree.remove(1);
        Assertions.assertEquals(testTree.size(),0);
        Assertions.assertTrue(testTree.isEmpty());
    }




    /**************************************************************************/
    /* 							add tests                                     */
    /* 							     			   	   			              */
    /**************************************************************************/



    @Test
    void add0ToNInts(){
        BinarySearchTree<Integer> testTree = new BinarySearchTree<>();
        for(int i = 0; i <= N; i++){
            Assertions.assertTrue(testTree.add(i));
            Assertions.assertTrue(testTree.contains(i));
            Assertions.assertTrue(testTree.size() == i);
            Assertions.assertTrue(testTree.last() == i);
        }
    }

    @Test
    void add0ToNChars(){
        BinarySearchTree<Character> testTree = new BinarySearchTree<>();
        for(int i = 0; i <= N; i++){
            Assertions.assertTrue(testTree.add((char)i));
            Assertions.assertTrue(testTree.contains((char)i));
            Assertions.assertTrue(testTree.size() == i);
            Assertions.assertTrue(testTree.last() == (char)i);
        }
    }

    @Test
    void add0ToNStrings(){

        String s;
        BinarySearchTree<String> testTree = new BinarySearchTree<>();
        for(int i = 0; i <= N; i++){
            s = Integer.toString(i);
            Assertions.assertTrue(testTree.add(s));
            Assertions.assertTrue(testTree.contains(s));
            Assertions.assertTrue(testTree.size() == i);
            Assertions.assertTrue(testTree.last() == s);
        }
    }



    /**************************************************************************/
    /* 							addAll tests                                  */
    /* 							     			   	   			              */
    /**************************************************************************/

    @Test
    void add0ToNAddAllInts(){
        BinarySearchTree<Integer> testTree = new BinarySearchTree<>();
        ArrayList<Integer> testCollection = new ArrayList<>();
        for(int i = 0; i < N; i++){
            testCollection.add(i);}
        Assertions.assertTrue(testTree.addAll(testCollection));
        for(int j = 0; j < testTree.size(); j++){
            Assertions.assertTrue(testTree.contains(j));
        }
        Assertions.assertTrue(testTree.containsAll(testCollection));
    }
    @Test
    void add0ToNAddAllChars(){
        BinarySearchTree<Character> testTree = new BinarySearchTree<>();
        ArrayList<Character> testCollection = new ArrayList<>();
        for(int i = 0; i < N; i++){
            char k = (char)i;
            testCollection.add(k);}
        Assertions.assertTrue(testTree.addAll(testCollection));
        for(int j = 0; j < testTree.size(); j++){
            char l = (char)j;
            Assertions.assertTrue(testTree.contains(l));
        }
        Assertions.assertTrue(testTree.containsAll(testCollection));
    }
    @Test
    void add0ToNAddAllStrings(){
        String s;
        BinarySearchTree<String> testTree = new BinarySearchTree<>();
        ArrayList<String> testCollection = new ArrayList<>();
        for(int i = 0; i < N; i++){
            s = Integer.toString(i);
            testCollection.add(s);}
        Assertions.assertTrue(testTree.addAll(testCollection));
        for(int j = 0; j < testTree.size(); j++){
            s = Integer.toString(j);
            Assertions.assertTrue(testTree.contains(s));
        }
        Assertions.assertTrue(testTree.containsAll(testCollection));
    }



    /**************************************************************************/
    /* 							contains tests                                */
    /* 							     			   	   			              */
    /**************************************************************************/
    @Test
    void containsInts(){
        BinarySearchTree<Integer> testTree = new BinarySearchTree<>();
        for(int i = 0; i < N; i++){
            testTree.add(i);
            Assertions.assertTrue(testTree.contains(i));
            testTree.remove(i);
            Assertions.assertFalse(testTree.contains(i));
        }
    }
    @Test
    void containsChars(){
        BinarySearchTree<Character> testTree = new BinarySearchTree<>();
        for(int i = 0; i < N; i++){
            char s = (char)i;
            testTree.add(s);
            Assertions.assertTrue(testTree.contains(s));
            Assertions.assertEquals(testTree.last(),s);
            testTree.remove(s);
            Assertions.assertFalse(testTree.contains(s));
        }
    }
    @Test
    void containsString(){
        String s;
        BinarySearchTree<String> testTree = new BinarySearchTree<>();
        for(int i = 0; i < N; i++){
             s = Integer.toString(i);
            testTree.add(s);
            Assertions.assertTrue(testTree.contains(s));
            testTree.remove(s);
            Assertions.assertFalse(testTree.contains(s));
        }
    }




    /**************************************************************************/
    /* 							containsAll tests                             */
    /* 							     			   	   			              */
    /**************************************************************************/

    @Test
    void containsAllInts(){
        BinarySearchTree<Integer> testTree = new BinarySearchTree<>();
        BinarySearchTree<Integer> testTree2 = new BinarySearchTree<>();
        ArrayList<Integer> testCollection = new ArrayList<>();
        for(int i = 0; i < N; i++){
            Assertions.assertTrue(testCollection.add(i));
            Assertions.assertTrue(testTree2.add(i));
            testTree2.contains(i);
        }
        Assertions.assertTrue(testTree.addAll(testCollection));
        Assertions. assertTrue(testTree.containsAll(testCollection));
        Assertions.assertTrue(testTree2.containsAll(testCollection));

        testTree.remove(1);
        Assertions.assertFalse(testTree.containsAll(testCollection));
        testTree2.clear();
        Assertions.assertFalse(testTree2.containsAll(testCollection));
    }

    @Test
    void containsAllChars(){
        BinarySearchTree<Character> testTree = new BinarySearchTree<>();
        BinarySearchTree<Character> testTree2 = new BinarySearchTree<>();
        ArrayList<Character> testCollection = new ArrayList<>();
        char s;
        for(int i = 0; i < N; i++){
            s = (char)i;
            Assertions.assertTrue(testCollection.add(s));
            Assertions.assertTrue(testTree2.add(s));
            testTree2.contains(s);
        }
        Assertions.assertTrue(testTree.addAll(testCollection));
        Assertions. assertTrue(testTree.containsAll(testCollection));
        Assertions.assertTrue(testTree2.containsAll(testCollection));

        testTree.remove((char)1);
        Assertions.assertFalse(testTree.containsAll(testCollection));
        testTree2.clear();
        Assertions.assertFalse(testTree2.containsAll(testCollection));
    }

    @Test
    void containsAllStrings(){
        BinarySearchTree<String> testTree = new BinarySearchTree<>();
        BinarySearchTree<String> testTree2 = new BinarySearchTree<>();
        ArrayList<String> testCollection = new ArrayList<>();
        String s;
        for(int i = 0; i < N; i++){
            s = Integer.toString(i);
            Assertions.assertTrue(testCollection.add(s));
            Assertions.assertTrue(testTree2.add(s));
            testTree2.contains(s);
        }
        Assertions.assertTrue(testTree.addAll(testCollection));
        Assertions. assertTrue(testTree.containsAll(testCollection));
        Assertions.assertTrue(testTree2.containsAll(testCollection));
        testTree.remove(Integer.toString(1));
        Assertions.assertFalse(testTree.containsAll(testCollection));
        testTree2.clear();
        Assertions.assertFalse(testTree2.containsAll(testCollection));
    }



    /**************************************************************************/
    /* 							first tests                                   */
    /* 							     			   	   			              */
    /**************************************************************************/
    @Test
    void first(){

        BinarySearchTree<Integer> testTree = new BinarySearchTree<>();

        for(int i = N; i >= 0; i--){
            Assertions.assertTrue(testTree.add(i));
            Assertions.assertTrue(testTree.first().equals(i));
        }

        Assertions.assertTrue(testTree.first() == 0);


    }

    @Test
    void firstOnEmpty(){
        BinarySearchTree<Integer> testTree = new BinarySearchTree<>();
        assertThrows(NoSuchElementException.class, () -> {testTree.first();});
    }



    /**************************************************************************/
    /* 				                last tests                                */
    /* 							     			   	   			              */
    /**************************************************************************/
    @Test
    void lastInts(){

        BinarySearchTree<Integer> testTree = new BinarySearchTree<>();

        for(int i = 0; i <= N; i++){
            Assertions.assertTrue(testTree.add(i));
            Assertions.assertTrue(testTree.last().equals(i));
        }

        Assertions.assertTrue(testTree.last() == N);


    }

    @Test
    void lastOnEmpty(){
        BinarySearchTree<Integer> testTree = new BinarySearchTree<>();
        assertThrows(NoSuchElementException.class, () -> {testTree.last();});
    }






    /**************************************************************************/
    /* 				                remove tests                              */
    /* 							     			   	   			              */
    /**************************************************************************/
    @Test
    void removeInts(){
        BinarySearchTree<Integer> testTree = new BinarySearchTree<>();
        int M = N*2;
        for(int i = 0; i <= M; i++){
            testTree.add(i);
        }
        for(int j = 0; j <= N; j++){
            Assertions.assertTrue(testTree.remove(j));
            Assertions.assertFalse(testTree.contains(j));
        }
        int a = testTree.size();
        int size = testTree.size();
        Assertions.assertTrue(testTree.size() == size);
        Assertions.assertTrue(testTree.add(a));
        Assertions.assertTrue(testTree.contains(a));
        Assertions.assertFalse(testTree.size() == size);
        Assertions.assertTrue(testTree.remove(a));
        Assertions.assertFalse(testTree.contains(a));
        Assertions.assertTrue(testTree.size() == size);
    }
    @Test
    void removeChars(){
        BinarySearchTree<Character> testTree = new BinarySearchTree<>();
        int M = N*2;
        char c;
        for(int i = 0; i <= M; i++){
            c = (char)i;
            testTree.add(c);
        }
        for(int j = 0; j <= N; j++){
            c = (char)j;
            Assertions.assertTrue(testTree.remove(c));
            Assertions.assertFalse(testTree.contains(c));
        }
        int size = testTree.size();
        char a = (char)size;
        Assertions.assertTrue(testTree.size() == size);
        Assertions.assertTrue(testTree.add(a));
        Assertions.assertTrue(testTree.contains(a));
        Assertions.assertFalse(testTree.size() == size);
        Assertions.assertTrue(testTree.remove(a));
        Assertions.assertFalse(testTree.contains(a));
        Assertions.assertTrue(testTree.size() == size);
    }

    @Test
    void removeStrings(){
        BinarySearchTree<String> testTree = new BinarySearchTree<>();
        int M = N*2;
        String s;
        for(int i = 0; i <= M; i++){
            s = Integer.toString(i);
            testTree.add(s);
        }
        for(int j = 0; j <= N; j++){
            s = Integer.toString(j);
            Assertions.assertTrue(testTree.remove(s));
            Assertions.assertFalse(testTree.contains(s));
        }
        String a = Integer.toString(testTree.size());
        int size = testTree.size();
        Assertions.assertTrue(testTree.size() == size);
        Assertions.assertTrue(testTree.add(a));
        Assertions.assertTrue(testTree.contains(a));
        Assertions.assertFalse(testTree.size() == size);
        Assertions.assertTrue(testTree.remove(a));
        Assertions.assertFalse(testTree.contains(a));
        Assertions.assertTrue(testTree.size() == size);
    }


    /**************************************************************************/
    /* 				                removeAll tests                           */
    /* 							     			   	   			              */
    /**************************************************************************/
    @Test
    void removeAllInts(){
        BinarySearchTree<Integer> testTree = new BinarySearchTree<>();
        ArrayList<Integer> testCollection = new ArrayList<>();
        int M = N*2;
        for(int i = 0; i <= M; i++){
            testTree.add(i);
        }
        for(int j = 0; j <= N; j++){
            testCollection.add(j);
            Assertions.assertTrue(testCollection.contains(j));
            Assertions.assertTrue(testTree.contains(j));
        }
        testTree.removeAll(testCollection);
        Assertions.assertFalse(testTree.containsAll(testCollection));

    }

    
    @Test
    void removeAllChars(){
        BinarySearchTree<Character> testTree = new BinarySearchTree<>();
        ArrayList<Character> testCollection = new ArrayList<>();
        int M = N*2;
        char c;
        for(int i = 0; i <= M; i++){
            c = (char)i;
            testTree.add(c);
        }
        for(int j = 0; j <= N; j++){
            c = (char)j;

            testCollection.add(c);
            Assertions.assertTrue(testCollection.contains(c));
            Assertions.assertTrue(testTree.contains(c));
        }
        testTree.removeAll(testCollection);
        Assertions.assertFalse(testTree.containsAll(testCollection));
    }    
    @Test
    void removeAllStrings(){
        BinarySearchTree<String> testTree = new BinarySearchTree<>();
        ArrayList<String> testCollection = new ArrayList<>();
        int M = N*2;
        String s;
        for(int i = 0; i <= M; i++){
            s = Integer.toString(i);
            testTree.add(s);
        }
        for(int j = 0; j <= N; j++){
            s = Integer.toString(j);

            testCollection.add(s);
            Assertions.assertTrue(testCollection.contains(s));
            Assertions.assertTrue(testTree.contains(s));
        }
        testTree.removeAll(testCollection);
        Assertions.assertFalse(testTree.containsAll(testCollection));
    }



    /**************************************************************************/
    /* 				                toArrayList tests                         */
    /* 							     			   	   			              */
    /**************************************************************************/
    @Test
    void toArrayListInts(){
        BinarySearchTree<Integer> testTree = new BinarySearchTree<>();
        BinarySearchTree<Integer> testTree2 = new BinarySearchTree<>();
        ArrayList<Integer> testCollection = new ArrayList<>();
        for(int i = 0; i < N; i++){
            Assertions.assertTrue(testCollection.add(i));
            Assertions.assertTrue(testTree2.add(i));
        }
        Assertions.assertTrue(testTree.addAll(testCollection));
        Assertions. assertTrue(testTree.containsAll(testCollection));
        Assertions.assertTrue(testTree2.containsAll(testCollection));

        ArrayList<Integer> finList = testTree.toArrayList();

        Assertions.assertEquals(testTree.size(),finList.size());
        Assertions.assertEquals(testCollection.size(),finList.size());

        for(int j = 0; j < testCollection.size(); j++){
            Assertions.assertEquals(testCollection.get(j),finList.get(j));
        }

        Assertions.assertEquals(testCollection.toString(),finList.toString());
    }




//    public static void main(String[] args){
//
//
//
//        Scanner S = new Scanner(System.in);
//        System.out.println(seperate);
//        System.out.println("Start Data Collection with parameters:");
//        System.out.println("MaxSize...");
//        N = S.nextInt();
//        System.out.println("Increment...");
//        int increment = S.nextInt();
//
//
//    }


}
