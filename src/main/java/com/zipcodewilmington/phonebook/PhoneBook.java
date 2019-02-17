package com.zipcodewilmington.phonebook;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private TreeMap<String, ArrayList<String>> treeMap;

    public PhoneBook() {
        treeMap = new TreeMap<String, ArrayList<String>>();
    }


    public void add(String name, ArrayList<String> numbers) {
        treeMap.put(name, numbers);
    }

    public ArrayList<String> lookup(String name) {
        return treeMap.get(name);
    }

    public void remove(String name) {
        treeMap.remove(name);
    }

    public Integer getSize() {
        return treeMap.size();
    }

    public ArrayList<String> reverseLookup(String phoneNumber) {
        ArrayList<String> returnArrayList = null;
        Set<String> listOfNames = treeMap.keySet();
        for (String name : listOfNames) {
            ArrayList<String> listOfNumbers = treeMap.get(name);
            for (String number : listOfNumbers) {
                if (phoneNumber.equals(number)) {
                    if (returnArrayList == null) {
                        returnArrayList = new ArrayList<String>();
                        returnArrayList.add(name);
                    } else {
                        returnArrayList.add(name);
                    }
                }
            }
        }
        return returnArrayList;
    }


    public String display() {
        Set<String> listOfNames = treeMap.keySet();
        String returnValue = "";
        Object[] listOfNamesArray = listOfNames.toArray();
        for (int i = 0; i < listOfNamesArray.length; i++) {
            String name = (String) listOfNamesArray[i];
            System.out.println(name);
            if (listOfNamesArray.length == 1) {
                returnValue += name + " " + treeMap.get(name);
                System.out.println(returnValue + "first if");
            } else {
                if (i == listOfNamesArray.length - 1) {
                    returnValue += name + " " + treeMap.get(name);
                    System.out.println("else: if");
                } else {
                    returnValue += name + " " + treeMap.get(name) + "\n";
                    System.out.println(returnValue + "else: else");
                }
            }
        }
        return returnValue;
    }
}