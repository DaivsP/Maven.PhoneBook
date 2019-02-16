package com.zipcodewilmington.phonebook;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.misc.ASCIICaseInsensitiveComparator;

import java.lang.reflect.Array;
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

        @Test
        public void testAdd1Name1Number() {
            //Given
            String davisNumber1 = "123-456-7890";
            ArrayList<String> davisNumbers = new ArrayList<String>();
            davisNumbers.add(davisNumber1);
            phoneBook.add("Davis", davisNumbers);
            String expectedNumbers = "123-456-7890";

            //When
            ArrayList<String> returnedNumbersList = phoneBook.lookup("Davis");
            String firstReturnedNumber = returnedNumbersList.get(0);

            //Then
            Assert.assertEquals(expectedNumbers, firstReturnedNumber);
        }

        @Test
        public void testAdd1Name2Numbers() {
            //Given
            String davisNumber1 = "123-456-7890";
            String davisNumber2 = "111-222-3333";
            ArrayList<String> davisNumbers = new ArrayList<String>();
            davisNumbers.add(davisNumber1);
            davisNumbers.add(davisNumber2);
            phoneBook.add("Davis", davisNumbers);
            String expectedNumber1 = "123-456-7890";
            String expectedNumber2 = "111-222-3333";

            //When
            ArrayList<String> returnedNumbersList = phoneBook.lookup("Davis");
            String firstReturnedNumber = returnedNumbersList.get(0);
            String secondReturnedNumber = returnedNumbersList.get(1);

            //Then
            Assert.assertEquals(expectedNumber1, firstReturnedNumber);
            Assert.assertEquals(expectedNumber2, secondReturnedNumber);
        }

        @Test
        public void testRemove1Name() {
            //Given
            String davisNumber1 = "123-456-7890";
            ArrayList<String> davisNumbers = new ArrayList<String>();
            davisNumbers.add(davisNumber1);
            phoneBook.add("Davis", davisNumbers);
            phoneBook.remove("Davis");
            Integer expectedSize = 0;

            //When
            Integer actualSize = phoneBook.getSize();

            //Then
            Assert.assertEquals(expectedSize, actualSize);
        }

        @Test
        public void testRemove1NameWhen2NamesStored() {
            //Given
            String davisNumber1 = "123-456-7890";
            ArrayList<String> davisNumbers = new ArrayList<String>();
            davisNumbers.add(davisNumber1);
            phoneBook.add("Davis", davisNumbers);
            String chalieNumber1 = "123-123-1234";
            ArrayList<String> chalieNumbers = new ArrayList<String>();
            chalieNumbers.add(chalieNumber1);
            phoneBook.add("Chalie", chalieNumbers);

            //When
            phoneBook.remove("Davis");

            //Then
            Integer expectedSize = 1;
            Integer actualSize = phoneBook.getSize();
            Assert.assertEquals(expectedSize, actualSize);

            ArrayList<String> checkForNameDavis = phoneBook.lookup("Davis");
            Assert.assertNull(checkForNameDavis);

            ArrayList<String> checkForNameChalie = phoneBook.lookup("Chalie");
            String expectedNumber = "123-123-1234";
            String numberReturned = checkForNameChalie.get(0);
            Assert.assertEquals(expectedNumber, numberReturned);
        }

        @Test
        public void testReverseLookup() {
            //Given
            String davisNumber1 = "123-456-7890";
            ArrayList<String> davisNumbers = new ArrayList<String>();
            davisNumbers.add(davisNumber1);
            phoneBook.add("Davis", davisNumbers);
            String chalieNumber1 = "123-123-1234";
            ArrayList<String> chalieNumbers = new ArrayList<String>();
            chalieNumbers.add(chalieNumber1);
            phoneBook.add("Chalie", chalieNumbers);

            //When
            ArrayList<String> returnedNameDavis = phoneBook.reverseLookup("123-456-7890");
            ArrayList<String> returnedNameChalie = phoneBook.reverseLookup("123-123-1234");

            //Then
            String expectedNameDavis = "Davis";
            Assert.assertEquals(expectedNameDavis, returnedNameDavis.get(0));

            String expectedNameChalie = "Chalie";
            Assert.assertEquals(expectedNameChalie, returnedNameChalie.get(0));
        }

        @Test
        public void testReverseLookupDoesNotExist() {
            //Given
            String davisNumber1 = "123-456-7890";
            ArrayList<String> davisNumbers = new ArrayList<String>();
            davisNumbers.add(davisNumber1);
            phoneBook.add("Davis", davisNumbers);

            //When
            ArrayList<String> returnedNameDavis = phoneBook.reverseLookup("value does not exist");

            //Then
            Assert.assertNull(returnedNameDavis);
        }

        @Test
        public void testReverseLookupAllNames() {
            //Given
            String davisNumber1 = "123-123-1234";
            ArrayList<String> davisNumbers = new ArrayList<String>();
            davisNumbers.add(davisNumber1);
            phoneBook.add("Davis", davisNumbers);

            String chalieNumber1 = "123-123-1234";
            ArrayList<String> chalieNumbers = new ArrayList<String>();
            chalieNumbers.add(chalieNumber1);
            phoneBook.add("Chalie", chalieNumbers);

            String mikeNumber1 = "123-456-7890";
            ArrayList<String> mikeNumbers = new ArrayList<String>();
            mikeNumbers.add(mikeNumber1);
            phoneBook.add("Mike", mikeNumbers);

            //When
            ArrayList<String> returnedNames = phoneBook.reverseLookup("123-123-1234");

            //Then
            Integer expectedSize = 2;
            Integer returnedSize = returnedNames.size();
            Assert.assertEquals(expectedSize, returnedSize);

            Boolean returnedNameDavis = returnedNames.contains("Davis");
            Assert.assertTrue(returnedNameDavis);

            Boolean returnedNameChalie = returnedNames.contains("Chalie");
            Assert.assertTrue(returnedNameChalie);

            Boolean returnedNameMike = returnedNames.contains("Mike");
            Assert.assertFalse(returnedNameMike);
        }

        @Test
        public void testDisplay() {
            String davisNumber1 = "123-123-1234";
            ArrayList<String> davisNumbers = new ArrayList<String>();
            davisNumbers.add(davisNumber1);
            phoneBook.add("Davis", davisNumbers);
        }
    }
