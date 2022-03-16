package com.nuc.zp.leetcode.bl1_100;

import com.nuc.zp.leetcode.hj1_100.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述
 * 给定一个整数数组,判断其中是否有3个数和为N
 * 输入描述：
 * 输入为一行
 * 逗号前为一个整数数组，每个元素间用空格隔开；逗号后为N
 * 输出描述：
 * 输出bool值
 * True表示存在3个和为N的数
 * False表示不存在3个和为N的数
 * 示例1
 * 输入：
 * 1 2 3 4 5,10
 * 复制
 * 输出：
 * True
 * 复制
 * 备注：
 * 数组长度不超过2000，所以数均为int范围的正整数
 */
public class Bl9 {

    public String exist3NumSum(int[] arr, int sum) {

        boolean exist = false;
        Map<String, Integer> hashMap = new HashMap<>();
        for (Integer num : arr) {
            hashMap.put(String.valueOf(num), num);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int val = sum - arr[i] - arr[j];
                if (hashMap.containsKey(String.valueOf(val))&&val!=arr[i]&&val!=arr[j]) {
                    exist= true;
                    break;
                }
            }
            if (exist){
                break;
            }
        }
        return exist ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        Bl9 bl9 = new Bl9();
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = buf.readLine().split(",");
        int[] ints = Arrays.stream(s[0].split(" ")).parallel().mapToInt(Integer::parseInt).toArray();
        int N = Integer.parseInt(s[1]);
        System.out.println(bl9.exist3NumSum(ints,N));
    }


}
