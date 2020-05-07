package com.sgc.p2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class p57 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(4);

        TreeNode root1 = t1;

        root1.left = t2;
        root1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        System.out.println(isSymmetrical1(root1));
    }

    public static boolean isSymmetrical1(TreeNode pRoot){
        return pRoot==null || judge(pRoot.left,pRoot.right);
    }

    public static boolean judge(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }else if(left==null||right==null){
            return false;
        }else if(left.val!=right.val){
            return false;
        }
        return judge(left.left,right.right) && judge(left.right,right.left);
    }

    public static boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            ArrayList<TreeNode> arrayList =  new ArrayList<>();
            ArrayList<Integer> arrayList1 = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode temp = queue.poll();
                if(temp.left==null){
                    arrayList1.add(0);
                }else{
                    arrayList1.add(1);
                }
                if(temp.right==null){
                    arrayList1.add(0);
                }else{
                    arrayList1.add(1);
                }
                TreeNode l = temp.left==null?new TreeNode(-1):temp.left;
                TreeNode r = temp.right==null?new TreeNode(-1):temp.right;
                arrayList.add(l);
                arrayList.add(r);
            }
            for(int i = 0;i<arrayList.size()/2;i++){
                if(arrayList.get(i).val!=arrayList.get(arrayList.size()-i-1).val){
                    return false;
                }
            }
            for(int i = 0;i<arrayList.size();i++){
                if(arrayList1.get(i)!=0){
                    queue.offer(arrayList.get(i));
                }
            }
        }
        return true;
    }
}
