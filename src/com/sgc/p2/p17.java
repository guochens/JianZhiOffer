package com.sgc.p2;

import java.util.Map;
import java.util.Stack;

public class p17 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t8 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(7);

        TreeNode root1 = new TreeNode(0);

        root1.left = t2;
        root1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        Mirror(root1);
        Mirror1(root1);
    }

    public static void Mirror(TreeNode root) {
        if(root!=null){
            TreeNode temp;
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

    public static void  Mirror1(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;
            if(treeNode.left!=null){
                stack.push(treeNode.left);
            }
            if(treeNode.right!=null){
                stack.push(treeNode.right);
            }
        }
    }

}
