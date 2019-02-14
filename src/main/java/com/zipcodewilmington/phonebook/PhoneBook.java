package com.zipcodewilmington.phonebook;

import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private TreeMap<String, String> inputs;


    public PhoneBook() {
        inputs = new TreeMap<String, String>();
    }


    public void add(String name, String number) {
        inputs.put(name, number);
    }

    public String lookup(String name) {
        return inputs.get(name);
    }

    public void remove(String name) {
        inputs.remove(name);
    }

    public Integer getSize() {
        return inputs.size();
    }

    public String hasname(String name) {
        return inputs.get(name);
    }

    public String hasnumber(String number) {
        Set<String> nameList = inputs.keySet();
        for (String name : nameList) {
            if (inputs.get(name).equals(number))
                return name;
        }
        return "Not Found";
    }

    public void clear() {
        inputs.clear();
    }
}

