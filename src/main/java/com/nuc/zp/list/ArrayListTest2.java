package com.nuc.zp.list;

import java.util.*;

public class ArrayListTest2 {
    public static void main(String[] args) {
        // 数据预热
              /* List<String> testList = createTestList(10);
         testForEach(testList);
        testFor(testList);
        testRandFor(10,testList);*/
        List<Integer> integers = Arrays.asList(10, 50, 100, 500, 1000, 10000, 50000, 100000, 5000000, 10000000, 30000000);
        for (Integer i : integers) {
            testRand(i);
        }

    }

    private static void testRand(int size) {
        System.out.println("-----------次数:" + size + "------------");
        List<String> list = createTestList(size);
        // 随机访问通过索引值去遍历。
        long time1 = System.nanoTime();
        testRandFor(size, list);
        long time2 = System.nanoTime();
        // 增强for循环
        testFor(list);
        long time3 = System.nanoTime();
        // 迭代器遍历
        testIterator(list);
        long time4 = System.nanoTime();
        // forEach + lambda
        testForEach(list);
        long time5 = System.nanoTime();

        System.out.println("随机访问tt" + (time2 - time1) / 1000 + " ms");
        System.out.println("增强for遍历tt" + (time3 - time2) / 1000 + " ms");
        System.out.println("迭代器遍历tt" + (time4 - time3) / 1000 + " ms");
        System.out.println("forEach遍历tt" + (time5 - time4) / 1000 + " ms");
        System.out.println();
    }

    private static void testRandFor(int size, List<String> list) {
        for (int i = 0; i < size; i++) {
            list.get(i).hashCode();
        }
    }

    private static void testFor(List<String> list) {
        for (String s : list) {
            s.hashCode();
        }
    }

    private static void testIterator(List<String> list) {
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            iter.next().hashCode();
        }
    }

    private static void testForEach(List<String> list) {
        list.forEach(p -> {
            p.hashCode();
        });
    }

    public static List<String> createTestList(int size) {
        List<String> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(UUID.randomUUID().toString());
        }
        return list;
    }
}