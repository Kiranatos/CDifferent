package net.kiranatos.softserve.jom.s4.t1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// T 1

public class MyUtils {

    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
        Map<String, List<String>> result = new HashMap<>();
        
        for (String phone: phones.keySet()) {
            String name = phones.get(phone);
            if (!result.containsKey(name)){
                List<String> listPhones = new ArrayList<>();
                listPhones.add(phone);
                result.put(name, listPhones);
            }
            else if(!result.get(name)
                    .contains(phone)) {
                result.get(name).add(phone);
            }            
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Map<String, String> list1 = new HashMap <String, String>();
        list1.put("0967654321", "Petro");
        list1.put("0677654321", "Petro");
        list1.put("0501234567", "Ivan");
        list1.put("0501234567", "Ivan");
        list1.put("0970011223", "Stepan");
        list1.put("0970011223", "Stepan");
        list1.put("0631234567", "Ivan");
        list1.put("0998888888", "Marta");
        list1.put("0779999999", "Marta");
        
        MyUtils mu = new MyUtils();
        Map<String, List<String>> result = mu.createNotebook(list1);
        Iterator<Map.Entry<String, List<String>>> it = result.entrySet().iterator();		
        while ( it.hasNext() ) {		
            Map.Entry<String, List<String>> pair = it.next();		
            String k = pair.getKey();		
            List<String> v = pair.getValue(); 
            System.out.println(k + " : " + v);
        }		
    }
}

/*
Create a createNotebook() method of the MyUtils class to create a new map with 
name as key and phone list as value.  The method receives a map with phone as key and name as value.

For example, for a given map
{0967654321=Petro, 0677654321=Petro, 0501234567=Ivan, 0970011223=Stepan, 0631234567=Ivan}

you should get
{Ivan=[0501234567, 0631234567], Petro=[0967654321, 0677654321], Stepan=[0970011223]}
*/

/*
Iterator<Map.Entry<String,Integer>> it = list_2.entrySet().iterator();		
while ( it.hasNext() ) {		
            Map.Entry<String,Integer> pair = it.next();		
            String k = pair.getKey();		
            Integer v = pair.getValue(); }		
		
for (String str: list_2.keySet()) // Получаем коллекцию ключей		
System.out.println(list_2.get(str)); // Получаем одно значение по ключу		
*/