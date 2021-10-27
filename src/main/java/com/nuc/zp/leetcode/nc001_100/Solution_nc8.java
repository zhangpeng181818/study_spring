package com.nuc.zp.leetcode.nc001_100;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_nc8 {

    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        // write code here

        ArrayList<ArrayList<Integer>>  res= new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        res.add(new ArrayList<>(Arrays.asList(root.val)));
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null){
                addVal(node.val,node.left.val,res);
                queue.add(node.left);
            }
            if(node.right!=null){
                addVal(node.val,node.right.val,res);
                queue.add(node.right);
            }
        }
        return res.stream().filter(list -> list.stream().mapToInt(Integer::valueOf).sum() == sum).collect(Collectors.toCollection(ArrayList::new));
    }

    public void addVal(Integer pre, Integer cur,ArrayList<ArrayList<Integer>> res){
        ArrayList<Integer> insert = new ArrayList();
        for(ArrayList list:res){
            int size = list.size();
            int pos = list.indexOf(pre);
            if(pos!=-1){
                ArrayList<Integer> nums = new ArrayList();


                res.add(nums);
                break;
            }
        }
    }
    public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }
}
