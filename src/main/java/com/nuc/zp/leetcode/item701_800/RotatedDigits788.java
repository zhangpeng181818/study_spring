package com.nuc.zp.leetcode.item701_800;

/**
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，
 * 我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * <p>
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；
 * 2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；
 * 6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * <p>
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 *  
 * <p>
 * 提示：
 * <p>
 * N 的取值范围是 [1, 10000]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotated-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotatedDigits788 {

    public int rotatedDigits2(int N) {
        // Count how many n in [1, N] are good.
        int ans = 0;
        for (int n = 1; n <= N; ++n)
            if (good(n, false)) ans++;
        return ans;
    }

    // Return true if n is good.
    // The flag is true iff we have an occurrence of 2, 5, 6, 9.
    public boolean good(int n, boolean flag) {
        if (n == 0) return flag;

        int d = n % 10;
        if (d == 3 || d == 4 || d == 7) return false;
        if (d == 0 || d == 1 || d == 8) return good(n / 10, flag);
        return good(n / 10, true);
    }

    public int rotatedDigits(int N) {
        int count = 0;
        //N<10时直接返回其对应的好数个数
        if (N < 10) {
            if (N < 2) {
            } else if (N < 5) {
                count = 1;
            } else if (N < 6) {
                count = 2;
            } else if (N < 9) {
                count = 3;
            } else {
                count = 4;
            }
            return count;
        }
        int[] state = new int[N + 1];
        //将元素标记,好数如2, 5, 6, 9标记为1,普数如0,1,8标记为0,坏数如3,4,7标记为-1
        state[0] = 0;
        state[1] = 0;
        state[2] = 1;
        state[3] = -1;
        state[4] = -1;
        state[5] = 1;
        state[6] = 1;
        state[7] = -1;
        state[8] = 0;
        state[9] = 1;
        count = 4;
        for (int i = 10; i <= N; i++) {
            //个位数
            int ge = i % 10;
            //个位数之前的数字 i/10 已经计算过状态,可以直接使用
            //根据个位数的状态和个位数之前的状态分以下两种情况判断
            //1.个位数之前的数字为普数,则个位数必须为好数才能使 i 为好数
            //2.个位数之前的数字为好数,则个位只要不是坏数都可以使 i 为好数
            if ((state[i / 10] == 0 && state[ge] > 0) || (state[i / 10] > 0 && state[ge] >= 0)) {
                state[i] = 1;
                count++;
            } else if (state[i / 10] == 0 && state[ge] == 0) {
                //个位数和个位数之前的数都是普数, 则i为普数
                state[i] = 0;
            } else {
                state[i] = -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RotatedDigits788 rotatedDigits788 = new RotatedDigits788();
        System.out.println(rotatedDigits788.rotatedDigits(10));
        System.out.println(rotatedDigits788.rotatedDigits(857));
    }


}
