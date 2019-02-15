package com.zipcodewilmington.phonebook;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {
    PhoneBook phoneBook;
    @Before
    public void Setup(){
        phoneBook = new PhoneBook();
        phoneBook.add("Davis", "123-456-7890");
    }

    @After
    public void tearDown(){
        phoneBook.clear();
    }

    @Test
    public void testAdd(){
        //Given
        String expected = "123-456-7890";

        //When
        phoneBook.lookup("Davis");

        //Then
        Assert.assertEquals(expected, phoneBook.lookup("Davis"));
    }

    @Test
    public void testRemove1(){
        //Given
        phoneBook.remove("Davis");
        Integer expected = 0;

        //When
        phoneBook.getSize();

        //Then
        Assert.assertEquals(expected, phoneBook.getSize());
    }

    @Test
    public void testRemove2(){
        //Given

    }

    @Test
    public void testLookup(){
        //Given
        String  expected = "123-456-7890";

        //When
        phoneBook.hasname("Davis");

        //Then
        Assert.assertEquals(expected, phoneBook.hasname("Davis"));
    }

    @Test
    public void testReverseLookup(){
        //Given
        String expected = "Davis";

        //When
        phoneBook.hasnumber("123-456-7890");

        //Then
        Assert.assertEquals(expected, phoneBook.hasnumber("123-456-7890"));
    }

    @Test
    public void testDisplay(){
        //Given
        
    }
}
