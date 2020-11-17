package com.nuc.zp.leetcode.item5501_5600;

import java.util.*;

public class SlowestKey5546 {

    Queue<Character> queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));

    public char slowestKey(int[] releaseTimes, String keysPressed) {

        List<Integer> indexs = new ArrayList<>();
        int max = releaseTimes[0];
        indexs.add(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int temp = releaseTimes[i] - releaseTimes[i - 1];
            System.out.println(temp);
            if (temp > max) {
                max = temp;
                indexs.clear();
                indexs.add(i);
            } else if (temp == max) {
                indexs.add(i);
            }
        }
        for (Integer index : indexs) {
            queue.add(keysPressed.charAt(index));
        }
        return queue.isEmpty() ? ' ' : queue.poll();
    }

    public static void main(String[] args) {
        SlowestKey5546 slowestKey5546 = new SlowestKey5546();
//        System.out.println(slowestKey5546.slowestKey(new int[]{9, 29, 49, 50}, "cbcd"));
//        System.out.println(slowestKey5546.slowestKey(new int[]{12, 23, 36, 46, 62}, "spuda"));
//        System.out.println(slowestKey5546.slowestKey(new int[]{23, 34, 43, 59, 62, 80, 83, 92, 97}, "qgkzzihfc"));
        System.out.println(slowestKey5546.slowestKey(new int[]{28, 65, 97}, "gaf"));
    }
}
