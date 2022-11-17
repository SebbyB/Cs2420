package assign09;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StudentHashTester {


	/**
	 * Class that tests various aspects of the various Student#Hash classes
	 * 
	 * 
	 * @author Amelia Nelson && Sebastian Barney
	 * @version November 16, 2022
	 */

    int n = 10000;
    @Test
    void badStudentExpect(){
    	//Tests that bad student hashcode method functions properly
        HashTable<StudentBadHash, Double> studentGpaTable = new HashTable<StudentBadHash, Double>();
        ArrayList<StudentBadHash> students = new ArrayList<>();
        double d = 3.0;
        for(int i = 0; i < n; i++) {
        	//creates students
            String firstName = Integer.toString(i) + "a";
            String lastName = Integer.toString(i) + "b";
            int uid = 1019999 + i;
            double gpa = d + (double) ((i % 10) / 10);
            StudentBadHash student = new StudentBadHash(uid, firstName, lastName);
            //tests all values are as excpected
            assertNull(studentGpaTable.put(student, gpa));
            assertEquals(studentGpaTable.get(student), gpa);
            assertEquals(student.hashCode(), uid % 100);
            assertTrue(studentGpaTable.containsKey(student));
        }
    }


    @Test
    void mediumStudentExpect(){

        HashTable<StudentMediumHash, Double> studentGpaTable = new HashTable<StudentMediumHash, Double>();
        double d = 3.0;
        for(int i = 0; i < n; i++) {
        	//creates students
            String firstName = Integer.toString(i) + "a";
            String lastName = Integer.toString(i) + "b";
            int uid = 1019999 + i;
            double gpa = d + (double) ((i % 10) / 10);
            StudentMediumHash student = new StudentMediumHash(uid, firstName, lastName);
            //tests all values are as excpected
            assertNull(studentGpaTable.put(student, gpa));
            assertEquals(studentGpaTable.get(student), gpa);
            assertEquals(student.hashCode(), (firstName.length() + lastName.length())*uid);
            assertTrue(studentGpaTable.containsKey(student));
        }    

    }
    int power(int n,int m){

        for(int i = 0; i <= m; i++){
            n*=n;
        }
        return n;
    }

    int goodHashString(String string){
    	//Tests that good student hashcodes method functions properly with strings
        int hashString = 0;
        int size = string.length();
        for(int i = 0; i <= 7; i++){
            hashString+= size*(power(10,i));
        }
        return hashString;
    }
    @Test
    void goodStudentExpect() {
    	//Tests that goodstudent hashcodes method functions properly
        HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
        double d = 3.0;
        for (int i = 0; i < n; i++) {
        	//creates students
            String firstName = Integer.toString(i) + "a";
            String lastName = Integer.toString(i) + "b";
            int uid = 1019999 + i;
            double gpa = d + (double) ((i % 10) / 10);
            StudentGoodHash student = new StudentGoodHash(uid, firstName, lastName);
            //tests all values are as excpected
            assertNull(studentGpaTable.put(student, gpa));
            assertEquals(studentGpaTable.get(student), gpa);
            assertEquals(student.hashCode(), goodHashString(firstName) + goodHashString(lastName) + uid);
            assertTrue(studentGpaTable.containsKey(student));
        }


    }
}
