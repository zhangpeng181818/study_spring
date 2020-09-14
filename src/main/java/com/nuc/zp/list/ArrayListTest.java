package com.nuc.zp.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("list"));
        // class java.util.ArrayList
        System.out.println(list.getClass());

        Object[] listArray = list.toArray();
        // class [Ljava.lang.Object;
        System.out.println(listArray.getClass());
        listArray[0] = new Object();

        System.out.println();

        List<String> asList = Arrays.asList("asList");
        // class java.util.Arrays$ArrayList
        System.out.println(asList.getClass());

        Object[] asListArray = asList.toArray();
        // class [Ljava.lang.String;
        System.out.println(asListArray.getClass());
        // java.lang.ArrayStoreException
        asListArray[0] = new Object();
    }
}
