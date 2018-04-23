package csci232.prog4;

import java.util.ArrayList;

/********************************
 * Author: Joshua Stephenson-Losey, Beau Anderson, Arash Ajam
 * Date: 4/13/18
 * Overview: test different scenarios of makeChange
 *********************************/
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

public class JUTest {
    //test for greedy aim of 42
    @Test
    void testChange6321() {
        Integer array[] = {1,5,10,21,25};

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(21);
        list.add(21);
        list.add(21);

        assertEquals(list, MakeChange.makeChange(array, 63));
    }
    //test for greedy aim of 42
    @Test
    void testChange42() {
        Integer array[] = {1,5,10,25};

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(25);
        list.add(10);
        list.add(5);
        list.add(1);
        list.add(1);

        assertEquals(list, MakeChange.makeChange(array, 42));
    }

    //test for evens aim of 30
    @Test
    void testChangeEven() {
        Integer array[] = {2,4,6,8,10};

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(10);
        list.add(10);
        list.add(10);

        assertEquals(list, MakeChange.makeChange(array, 30));
    }

    //test for more that just the first one
    @Test
    void testChangeEven2() {
        Integer array[] = {2,4,6,8,10};

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(10);
        list.add(10);
        list.add(8);

        assertEquals(list, MakeChange.makeChange(array, 28));
    }

    //test not the largest
    @Test
    void testChangeOdd() {
        Integer array[] = {1,3,5,7};

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(3);

        assertEquals(list, MakeChange.makeChange(array, 3));
    }

    //test the empty
    @Test
    void testChangeEmptyArray() {
        Integer array[] = {};
        Exception e = assertThrows(IllegalArgumentException.class, () -> {  MakeChange.makeChange(array,5); } );
        assertEquals("Array of size 0 is not allowed", e.getMessage());
    }

}
