package com.nuc.zp.leetcode.item401_500;

/**
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * <p>
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * <p>
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * <p>
 * 示例 1:
 * <p>
 * n = 5
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第三行不完整，所以返回2.
 * 示例 2:
 * <p>
 * n = 8
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第四行不完整，所以返回3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrangeCoins441 {
    /**
     *
     * 根据数学公式，k(k+1) /2 = n，可以得到其正数解为：k = sqrt(2n+1/4) - 1/2。然后求整即可。
     * 唯一的问题是，这里2n+1/4有可能会超出sqrt函数的参数范围。
     * 于是，我们可以变换一下， k = sqrt(2) * sqrt(n+1/8) - 1/2，这样求平方根就不会超限了。

     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        int i = 1;
        long sum = 0;
        long left = 1, right = n / 2 + 1;
        while (left <= right) {
            long med = ((right - left) >> 1) + left;
            sum = (1 + med) * med / 2;
            if (sum > n) {
                right = med - 1;
                i = (int) med;
            } else if (sum < n) {
                left = med + 1;
            } else {
                return (int) med;
            }
        }
        return sum == n ? i : i - 1;
    }

    public static void main(String[] args) {
        ArrangeCoins441 arrangeCoins441 = new ArrangeCoins441();
        System.out.println(arrangeCoins441.arrangeCoins(3));
        System.out.println(arrangeCoins441.arrangeCoins(5));
        System.out.println(arrangeCoins441.arrangeCoins(8));
        System.out.println(arrangeCoins441.arrangeCoins(1804289383));
        System.out.println(arrangeCoins441.arrangeCoins(595));
    }
}
