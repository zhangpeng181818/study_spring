package com.nuc.zp.list;

import java.util.ArrayList;

public class ArrayListTest4 {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        System.out.println(list.size());
        ArrayList<Object> list2 = new ArrayList<>(8);
//        list2.add(5,1);//IndexOutOfBoundsException
        list2.add(2);
        System.out.println(list2.size());
        list2.add(3);
        list2.add(4);
        System.out.println(list2.size());//3
        list2.remove(1);
        System.out.println(list2.size());//2
        list2.add(0,5);
        System.out.println(list2.size());//3


    }
}
