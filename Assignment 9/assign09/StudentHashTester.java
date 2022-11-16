package assign09;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StudentHashTester {


    int n = 10000;


    @Test
    void badStudentExpect(){
        HashTable<StudentBadHash, Double> studentGpaTable = new HashTable<StudentBadHash, Double>();
        ArrayList<StudentBadHash> students = new ArrayList<>();
        double d = 3.0;
        for(int i = 0; i < n; i++) {
            String firstName = Integer.toString(i) + "a";
            String lastName = Integer.toString(i) + "b";
            int uid = 1019999 + i;
            double gpa = d + (double) ((i % 10) / 10);
            StudentBadHash student = new StudentBadHash(uid, firstName, lastName);
            assertNull(studentGpaTable.put(student, gpa));
            assertEquals(studentGpaTable.get(student), gpa);
            assertEquals(student.hashCode(), uid % 100);
            assertTrue(studentGpaTable.containsKey(student));
        }
    }

    int hashMedString(String string){
        int hashString = 0;
        for(char character : string.toCharArray()){
            hashString += Integer.valueOf(character);
        }
        return hashString;
    }
    @Test
    void mediumStudentExpect(){

        HashTable<StudentMediumHash, Double> studentGpaTable = new HashTable<StudentMediumHash, Double>();
        double d = 3.0;
        for(int i = 0; i < n; i++) {
            String firstName = Integer.toString(i) + "a";
            String lastName = Integer.toString(i) + "b";
            int uid = 1019999 + i;
            double gpa = d + (double) ((i % 10) / 10);
            StudentMediumHash student = new StudentMediumHash(uid, firstName, lastName);
            assertNull(studentGpaTable.put(student, gpa));
            assertEquals(studentGpaTable.get(student), gpa);
            assertEquals(student.hashCode(), hashMedString(firstName) + hashMedString(lastName) + uid);
            assertTrue(studentGpaTable.containsKey(student));
        }    

    }

    int goodHashString(String string){

        int hashString = 0;
        int size = string.length();
        for(int i = 0; i < size; i++){
            hashString += Integer.valueOf(string.charAt(i)) - i;
        }
        return hashString;
    }
    @Test
    void goodStudentExpect() {
        HashTable<StudentGoodHash, Double> studentGpaTable = new HashTable<StudentGoodHash, Double>();
        double d = 3.0;
        for (int i = 0; i < n; i++) {
            String firstName = Integer.toString(i) + "a";
            String lastName = Integer.toString(i) + "b";
            int uid = 1019999 + i;
            double gpa = d + (double) ((i % 10) / 10);
            StudentGoodHash student = new StudentGoodHash(uid, firstName, lastName);
            assertNull(studentGpaTable.put(student, gpa));
            assertEquals(studentGpaTable.get(student), gpa);
            assertEquals(student.hashCode(), goodHashString(firstName) + goodHashString(lastName) + uid);
            assertTrue(studentGpaTable.containsKey(student));
        }


    }
}
