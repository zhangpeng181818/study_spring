package com.nuc.zp.list;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String,Object> hashMap = new HashMap<>();
        System.out.println(hashMap.put("1", 1));
        System.out.println(hashMap.put("2", 3));
        System.out.println(hashMap.put("2",null));
        System.out.println(hashMap.put("2",9));
//        System.out.println(hashMap.put(1, 2));
//        System.out.println(hashMap.put(17, 2));

//        int a= 10;
//        if (a>1){
//            System.out.println(1);
//        }else if (a>2){
//            System.out.println(2);
//        }
    }
}
