package com.sgc.p2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class p21_tree {
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

        System.out.println(PrintFromTopToBottom(root1));
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp!=null){
                arrayList.add(temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return arrayList;
    }

}
