package com.zipcodewilmington.phonebook;

import java.sql.SQLOutput;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private TreeMap<String, String> treeMap;


    public PhoneBook() {
        treeMap = new TreeMap<String, String>();
    }


    public void add(String name, String number) {
        treeMap.put(name, number);
    }

    public String lookup(String name) {
        return treeMap.get(name);
    }

    public void remove(String name) {
        treeMap.remove(name);
    }

    public Integer getSize() {
        return treeMap.size();
    }

    public String hasname(String name) {
        return treeMap.get(name);
    }

    public String hasnumber(String number) {
        Set<String> nameList = treeMap.keySet();
        for (String name : nameList) {
            if (treeMap.get(name).equals(number))
                return name;
        }
        return "Not Found";
    }

    public void clear() {
        treeMap.clear();
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
}

