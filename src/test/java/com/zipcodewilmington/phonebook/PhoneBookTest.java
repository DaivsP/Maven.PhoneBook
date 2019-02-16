package com.zipcodewilmington.phonebook;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {
    PhoneBook phoneBook;

    @Before
    public void Setup() {
        phoneBook = new PhoneBook();
        String davisNumber1 = "123-456-7890";
        String davisNumber2 = "111-222-3333";
        String chalieNumber1 = "123-123-1234";
        ArrayList<String> davisNumbers = new ArrayList<String>();
        ArrayList<String> chalieNumbers = new ArrayList<String>();
        chalieNumbers.add(chalieNumber1);
        davisNumbers.add(davisNumber1);
        davisNumbers.add(davisNumber2);
        phoneBook.add("Davis", davisNumbers);
        phoneBook.add("Chalie", chalieNumbers);
    }

    @After
    public void tearDown() {
        phoneBook.clear();
    }

    @Test
    public void testAdd1Name1Number() {
        //Given
        String expectedNumbers = "123-456-7890";

        //When
        ArrayList<String> returnedNumbersList = phoneBook.lookup("Davis");
        String firstReturnedNumber = returnedNumbersList.get(0);

        //Then
        //Assert.assertNotNull(returnedNumbersList);
        Assert.assertEquals(expectedNumbers, firstReturnedNumber);
    }

    @Test
    public void testAdd1Name2Numbers(){
        //Given
        String expectedNumbers = "123-456-7890" + "111-222-3333";

        //When
        ArrayList<String> returnedNumbersList = phoneBook.lookup("Davis");
        String returnedNumbers = returnedNumbersList.get(0) + returnedNumbersList.get(1);

        //Then
        Assert.assertEquals(expectedNumbers, returnedNumbers);
    }

    @Test
    public void testRemove1Name(){
        //Given
        phoneBook.remove("Davis");
        Integer expected = 1;

        //When
        Integer actual = phoneBook.getSize();

        //Then
        Assert.assertEquals(expected, actual);
    }
/*
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
        String expected = "Chalie" + "111-222-3333" + "\n" + "Davis" + "123-456-7890" + "\n";

        //When
        phoneBook.display();

        //Then
        Assert.assertEquals(expected, phoneBook.display());

    }
    */
}
