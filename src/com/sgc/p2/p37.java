package com.sgc.p2;

import java.util.*;

//输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
public class p37 {

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
        t3.left = t6;
        t3.right = t7;

        System.out.println(TreeDepth1(root1));
    }

    //非递归
    public static int TreeDepth1(TreeNode root) {
        int res = 0;
        if(root == null){
            return res;
        }
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        arrayList.add(root);
        while (!arrayList.isEmpty()){
            ArrayList<TreeNode> arrayList1 = new ArrayList<>();
            Iterator<TreeNode> iterator = arrayList.iterator();
            while (iterator.hasNext()){
                TreeNode temp = iterator.next();
                if(temp.left!=null){
                    arrayList1.add(temp.left);
                }
                if(temp.right!=null){
                    arrayList1.add(temp.right);
                }
            }
            res++;
            arrayList.clear();
            arrayList.addAll(arrayList1);
        }
        return res;
    }


    //递归
    public static int TreeDepth(TreeNode root) {
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
