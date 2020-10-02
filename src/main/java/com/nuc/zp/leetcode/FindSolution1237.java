package com.nuc.zp.leetcode;

import java.util.List;

/**
 * 给出一个函数  f(x, y) 和一个目标结果 z，请你计算方程 f(x,y) == z 所有可能的正整数 数对 x 和 y。
 * <p>
 * 给定函数是严格单调的，也就是说：
 * <p>
 * f(x, y) < f(x + 1, y)
 * f(x, y) < f(x, y + 1)
 * 函数接口定义如下：
 * <p>
 * interface CustomFunction {
 * public:
 *   // Returns positive integer f(x, y) for any given positive integer x and y.
 *   int f(int x, int y);
 * };
 * 如果你想自定义测试，你可以输入整数 function_id 和一个目标结果 z 作为输入，其中 function_id 表示一个隐藏函数列表中的一个函数编号，题目只会告诉你列表中的 2 个函数。  
 * <p>
 * 你可以将满足条件的 结果数对 按任意顺序返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：function_id = 1, z = 5
 * 输出：[[1,4],[2,3],[3,2],[4,1]]
 * 解释：function_id = 1 表示 f(x, y) = x + y
 * 示例 2：
 * <p>
 * 输入：function_id = 2, z = 5
 * 输出：[[1,5],[5,1]]
 * 解释：function_id = 2 表示 f(x, y) = x * y
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= function_id <= 9
 * 1 <= z <= 100
 * 题目保证 f(x, y) == z 的解处于 1 <= x, y <= 1000 的范围内。
 * 在 1 <= x, y <= 1000 的前提下，题目保证 f(x, y) 是一个 32 位有符号整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-positive-integer-solution-for-a-given-equation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSolution1237 {

    /**
     * 由于函数 f 对于两个变量的偏导都是正的，那么可以使用双指针法。
     * 我们思考，先固定 x ，从1 开始，那么可以让 y 从后往前找到匹配值
     * 如果匹配到了以后，那么对应于这个 x 已经没用了，x 可以增加
     * 同时增加后的 x 要匹配的 y 就一定比上一个 y 少。
     * 这就是双指针法的思路。
     * 具体来讲就是
     * 一个 x 指向头(1)，一个 y 指向尾(1000)
     * 判断 x 和 y 能否使得函数值等于 z
     * 当这个函数值小了，就增加 x
     * 当这个函数值大了，就减少 y
     * 相等的时候添加到答案，同时 x 和 y 一起更新。
     * 推荐使用这个方法，利用了函数 f 对两个变量的偏导都是正的这个条件。
     *
     */

//    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
//        List<List<Integer>> res = new ArrayList<>();
//        int left = 1;
//        int right = 1000;
//        while (left <= 1000 && right >= 1) {
//            int temp = customfunction.f(left,right);
//            if (temp == z) {
//                List<Integer> list = new ArrayList<>();
//                list.add(left);
//                list.add(right);
//                res.add(list);
//                left++;
//            } else if (temp > z) {
//                right--;
//            } else {
//                left++;
//            }
//        }
//        return res;
//    }

}

