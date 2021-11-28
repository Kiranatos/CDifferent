package net.kiranatos.softserve.jom.s4.t3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

// T 3 
public class MyUtils {    
    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        if (!list.containsAll(map.values())) return false;
        
        for (String el : list)
            if (!map.containsValue(el)) return false;
        
        /*
        for (String str: map.keySet()) {
            System.out.println("MAP");
            if (!list.contains(map.get(str))) return false; }*/

        return true;
    }
    public static void main(String[] args) {
        Map<String, String> map = new HashMap <>();
        map.put("1", "cc");
        map.put("2", "bb");
        map.put("3", "cc");
        map.put("4", "aa");
        map.put("5", "cc");
        map.put("6", "cc");
        map.put("7", "cc");
//        map.put("5", "helicopter");
        
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("aa");
        list.add("cc");
        list.add("cc");
//        list.add("kk");
        
        System.out.println(new MyUtils().listMapCompare(list, map));
    }
}

/*
Create a listMapCompare() method of the MyUtils class to compare the contents 
of a list of strings and the values of a map.

For example, for a given list
[aa, bb, aa, cc]
and map
{1=cc, 2=bb, 3=cc, 4=aa, 5=cc}
you should get true.
*/