package com.sgc.p2;

import java.util.*;

//给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
public class p61 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        //TreeNode t8 = new TreeNode(8);

        TreeNode root1 = t1;

        root1.left = t2;
        root1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        //t4.left = t8;

        System.out.println(KthNode(root1, 4).val);
        System.out.println(KthNode(root1, 1).val);
        System.out.println(KthNode(root1, 5).val);
        System.out.println(KthNode(root1, 7).val);
    }
    //非递归
    public static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>(); //建立栈
        TreeNode cur = pRoot;
        //while 部分为中序遍历
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur); //当前节点不为null，应该寻找左儿子
                cur = cur.left;
            } else {
                cur = stack.pop();//当前节点null则弹出栈内元素，相当于按顺序输出最小值。
                if (--k <= 0) { //计数器功能
                    return cur;
                }
                cur = cur.right;
            }
        }
        return null;
    }


    public static TreeNode KthNode1(TreeNode pRoot, int k){
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        mot(pRoot,arrayList);
        if(arrayList.size()<k || k==0){
            return null;
        }
//        Collections.sort(arrayList, new Comparator<TreeNode>() {
//            @Override
//            public int compare(TreeNode o1, TreeNode o2) {
//                return o1.val>o2.val?1:-1;
//            }
//        });
        return arrayList.get(k-1);
    }
    public static void   mot(TreeNode pRoot, ArrayList<TreeNode> arrayList){
        if(pRoot==null){
            return;
        }
        mot(pRoot.left,arrayList);
        arrayList.add(pRoot);
        mot(pRoot.right,arrayList);
    }
}
