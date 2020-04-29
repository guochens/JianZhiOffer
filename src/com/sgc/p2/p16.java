package com.sgc.p2;
//看的答案
//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
public class p16 {
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

        TreeNode root2 = new TreeNode(3);
        root2.left = t8;
        root2.right = t9;

        System.out.println(HasSubtree(root1, root2));
    }

    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //判断顺序不能改
        if(root2==null) {
            return false;
        }else if(root1==null){
            return false;
        }
        //boolean flag = false;
        if(root1.val==root2.val){//可以合并到isSubTree中判断
            return isSubtree(root1,root2);
        }else{
            return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
        }
    }

    public static boolean isSubtree(TreeNode root1,TreeNode root2){
        if(root2==null) {
            return true;
        }else if(root1==null){
            return false;
        }
        if(root1.val==root2.val){
            return isSubtree(root1.left,root2.left)&&isSubtree(root1.right,root2.right);
        }else{
            return false;
        }
    }
}

//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//
//    }
//
//}