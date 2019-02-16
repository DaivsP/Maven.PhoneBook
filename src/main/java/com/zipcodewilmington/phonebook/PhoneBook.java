package com.zipcodewilmington.phonebook;

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

    public void clear() {
        treeMap.clear();
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
        return null;
    }
}

