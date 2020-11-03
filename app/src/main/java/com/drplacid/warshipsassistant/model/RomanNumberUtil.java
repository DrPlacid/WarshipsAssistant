package com.drplacid.warshipsassistant.model;

import java.util.TreeMap;

public class RomanNumberUtil {

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public final static String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }
}
