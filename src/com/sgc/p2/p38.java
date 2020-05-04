package com.sgc.p2;

import java.util.Deque;

//输入一棵二叉树，判断该二叉树是否是平衡二叉树。
//
//在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
public class p38 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        TreeNode root1 = t1;

        root1.left = t2;
        root1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t5.right = t6;

        System.out.println(IsBalanced_Solution(root1));
    }


    public static boolean IsBalanced_Solution(TreeNode root) {
        return !(Depth(root)==-1);
    }

    public static int Depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int ldepth = Depth(root.left);
        if(ldepth==-1){
            return -1;
        }
        int rdepth = Depth(root.right);
        if(rdepth==-1){
            return -1;
        }
        if(ldepth-rdepth>1 || rdepth-ldepth>1){
            return -1;
        }
        return 1+Math.max(ldepth,rdepth);
    }

    public static boolean IsBalanced_Solution1(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        int ldepth = TreeDepth(root.left);
        int rdepth = TreeDepth(root.right);
        if(ldepth-rdepth>=2 || rdepth-ldepth>=2){
            return false;
        }

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public static int TreeDepth(TreeNode root){
        int res = 0;
        if(root == null){
            return res;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        res = Math.max(left,right)+1;
        return res;
    }

}
