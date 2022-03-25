package com.nuc.zp.leetcode.bm1_100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 *    1
 *  2   3
 *4  5
 示例1
 输入：
 [1,2,4,5,3],[4,2,5,1,3]
 1,3,2,5,4
 复制
 返回值：
 [1,3,5]


          1
        2   3
      4  5 6 7
    8
 [1,2,4,8,5,3,6,7] [8,4,2,5,1,6,3,7]
 [1,3,7,8]



 */
public class Solution_bm41 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     * @param xianxu int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    private HashMap<Integer, Integer> ans = new HashMap<>();
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int j = 0;
    public int[] solve (int[] xianxu, int[] zhongxu) {
        //将xianxu节点的值映射到相应的中序节点的下标。
        for(int i = 0; i < zhongxu.length; i++){
            map.put(zhongxu[i], i);
        }
        //开始构建二叉树。
        build(xianxu, zhongxu, 0, xianxu.length-1, 0);

        //创建放回答案的数组
        int[] temp = new int[ans.size()];

        //将值传入数组。
        for(int i = 0; i < ans.size(); i++){
            temp[i] = ans.get(i);
        }

        return temp;
    }

    public void build(int[] xianxu, int[] zhongxu, int left, int right, int i){
        if(left > right){
            return;
        }
        int index = map.get(xianxu[j++]);
        //构建左子树
        build(xianxu, zhongxu, left, index-1, i+1);
        //构建右子树
        build(xianxu, zhongxu, index+1, right, i+1);
        //存储第i层的最右边的那个节点。
        ans.put(i, zhongxu[index]);
    }


    public static void main(String[] args) {

    }
}
/**
 * 可以发现解这道题，我们有两个步骤：
 * 1. 建树
 * 2. 打印右视图
 *
 * 首先建树方面，前序遍历是根左右的顺序，中序遍历是左根右的顺序，因为节点值互不相同，
 * 我们可以根据在前序遍历中找到根节点（每个子树部分第一个就是），再在中序遍历中找到对应的值，
 * 从其左右分割开，左边就是该树的左子树，右边就是该树的右子树，于是将问题划分为了子问题。
 *
 * 而打印右视图即找到二叉树每层最右边的节点元素，我们可以采取dfs（深度优先搜索）遍历树，根据记录的深度找到最右值。
 *
 * step 1：首先检查两个遍历序列的大小，若是为0，则空树不用打印。
 * step 2：建树函数根据上述说，每次利用前序遍历第一个元素就是根节点，在中序遍历中找到它将二叉树划分为左右子树，利用l1 r1 l2 r2分别记录子树部分在数组中分别对应的下标，并将子树的数组部分送入函数进行递归。
 * step 3：dfs打印右视图时，使用哈希表存储每个深度对应的最右边节点，初始化两个栈辅助遍历，第一个栈记录dfs时的节点，第二个栈记录遍历到的深度，根节点先入栈。
 * step 4：对于每个访问的节点，每次左子节点先进栈，右子节点再进栈，这样访问完一层后，因为栈的先进后出原理，每次都是右边被优先访问，因此我们在哈希表该层没有元素时，添加第一个该层遇到的元素就是最右边的节点。
 * step 5：使用一个变量逐层维护深度最大值，最后遍历每个深度，从哈希表中读出每个深度的最右边节点加入数组中
 */