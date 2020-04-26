package com.sgc.p2;


import jdk.nashorn.internal.runtime.regexp.joni.ast.StateNode;

import java.util.HashSet;

public class P4 {
    public static void main(String[] args) {
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};

        TreeNode t = reConstructBinaryTree(pre,in);
        System.out.println(t);
    }
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        int length = in.length;
        if(length==0){
            TreeNode temp = null;
            return temp;
        }
        TreeNode[] trees = new TreeNode[length];

        for(int i = 0;i<length;i++){
            trees[i]= new TreeNode(pre[i]);
            trees[i].left = null;
            trees[i].right = null;
        }

        int[] index = new int[length];
        for(int i =0; i<length;i++){
            for(int j = 0;j<length;j++){
                if(pre[i]==in[j]){
                    index[i] = j;
                }
            }
        }

        for(int i = 1; i<length; i++){
            boolean findfather = false;
            int max = length;
            int min = -1;
            int max_index = -1;
            int min_index = -1;
            for(int j = 0;j<i;j++) {
                if(index[i]>index[j]&&index[j]>min){
                    min = index[j];
                    min_index = j;
                }else if(index[i]<index[j]&&index[j]<max){
                    max = index[j];
                    max_index = j;
                }
            }
            if(min_index<0){
                trees[max_index].left = trees[i];
                continue;
            }
            if(max_index<0){
                trees[min_index].right = trees[i];
                continue;
            }
            if(max_index>min_index){
                trees[max_index].left = trees[i];
            }else{
                trees[min_index].right = trees[i];
            }
        }
        return trees[0];
    }
}


/**
 * Definition for binary tree
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}