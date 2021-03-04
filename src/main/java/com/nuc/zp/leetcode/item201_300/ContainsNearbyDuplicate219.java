package com.nuc.zp.leetcode.item201_300;

import java.util.*;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，
 * 并且 i 和 j 的差的 绝对值 至多为 k。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainsNearbyDuplicate219 {

    Map<Integer, List<Node>> bucket = new HashMap<>();
    List<Integer> indexs = new ArrayList<>();

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            List<Node> nodeList = bucket.get(nums[i]);

            if (nodeList != null) {
                indexs.add(i);
            } else {
                nodeList = new ArrayList<>();
            }
            nodeList.add(new Node(i));
            bucket.put(nums[i], nodeList);
        }
        if (indexs.isEmpty()) {
            return false;
        }
        for (int index : indexs) {
            List<Node> nodes = bucket.get(nums[index]);
//            nodes.sort(Comparator.comparing(o -> o.index));
            for (int i = 0; i < nodes.size(); i++) {
                if (i + 1 < nodes.size() && Math.abs(nodes.get(i).index - nodes.get(i + 1).index) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    class Node {
        public Integer index;

        public Node(int index) {
            this.index = index;
        }
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate219 containsNearbyDuplicate219 = new ContainsNearbyDuplicate219();
//        System.out.println(containsNearbyDuplicate219.containsNearbyDuplicate(new int[]{1,2,3,1},3));
//        System.out.println(containsNearbyDuplicate219.containsNearbyDuplicate(new int[]{1,0,1,1},1));
//        System.out.println(containsNearbyDuplicate219.containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
        System.out.println(containsNearbyDuplicate219.containsNearbyDuplicate(new int[]{1,2,3,1},3));
    }
}
