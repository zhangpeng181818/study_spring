package com.nuc.zp.leetcode.item1001_1100;

/**
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * <p>
 * 示例1:
 * <p>
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 * 示例2:
 * <p>
 * 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 * 输出：4
 * 提示:
 * <p>
 * words的长度在[1, 1000000]之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-array-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindString1005 {

//    public int findString(String[] words, String s) {
//       return Arrays.asList(words).indexOf(s);
//    }

    public int findString(String[] words, String s) {

        int left = 0, right = words.length - 1;
        while (left <= right) {
            int med = ((right - left) >> 1) + left;
            while (left <= right && "".equals(words[left])) {
                left++;
            }
            while (left <= right && "".equals(words[right])) {
                right--;
            }
            int tmp = med;
            while(tmp < right && words[tmp].equals("")) tmp ++;

            if (words[tmp].compareTo(s) > 0) {
                right = med - 1;
            } else if (words[tmp].compareTo(s) < 0) {
                left = med + 1;
            } else {
                return tmp;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        FindString1005 findString1005 = new FindString1005();
        System.out.println(findString1005.findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "dad"));
        System.out.println(findString1005.findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ball"));
    }
}
