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
/*
    public String hasname(String name) {
        return treeMap.get(name);
    }

    public String getName(String number) {
        Set<String> nameList = treeMap.keySet();
        for (String name : nameList) {
            if (treeMap.get(name).equals(number))
                return name;
        }
        return "Not Found";
    }



    public String display() {
        String output = "";
        Set<String> nameList = treeMap.keySet();
        for (String name : nameList) {
            output += name + treeMap.get(name) + "\n";
            System.out.println(name);
            System.out.println(treeMap.get(name));
        }
        //System.out.println(output);
        return output;
    }
    */
}

