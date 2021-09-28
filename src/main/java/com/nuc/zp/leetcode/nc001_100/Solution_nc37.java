package com.nuc.zp.leetcode.nc001_100;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_nc37 {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort((o1, o2) -> o1.start - o2.start);
        int j = 1;
        int i = 0;
        while (j < intervals.size()) {
            Interval before = intervals.get(i);
            Interval after = intervals.get(j);
            if (before.end >= after.start) {
                Interval tmp = new Interval(before.start, Math.max(before.end, after.end));
                intervals.remove(i); // 重点删除后，位置会往后移
                intervals.remove(i);
                intervals.add(i, tmp);  // 重点add, 不是set
            } else {
                i++;
                j++;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        Solution_nc37 solutionNc37 = new Solution_nc37();
//        System.out.println(solutionNc37.merge(new ArrayList<>(Arrays.asList(new Interval(10, 30), new Interval(20, 60)
//                , new Interval(80, 100), new Interval(150, 180)))));

        System.out.println(solutionNc37.merge(new ArrayList<>(Arrays.asList(
                 new Interval(1, 4), new Interval(0, 1)))));

    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
