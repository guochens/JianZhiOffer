package com.sgc.p2;

import javax.swing.*;
import java.util.*;

public class p25 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);

        TreeNode root1 = t1;

        root1.left = t2;
        root1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

       // TreeNode test = Convert(root1);
        TreeNode test1 = Convert1(root1);
    }

//    public static TreeNode Convert(TreeNode pRootOfTree) {
//        if(pRootOfTree==null){
//            return null;
//        }
//        TreeNode preHead = null;
//
//        Stack<TreeNode> stack = new Stack<>();
//        Set<TreeNode> set = new HashSet<>();
//        stack.add(pRootOfTree);
//        while(!stack.isEmpty()){
//            TreeNode curr = stack.peek();
//            if(set.contains(curr)){
//                if(set.contains(curr.right)){
//                    TreeNode temp = stack.pop();
//                    preHead.right = temp;
//                    temp.left = preHead;
//                    preHead = preHead.right;
//                }else{
//                    if(set.contains(curr.right)){
//                        stack.pop();
//                    }
//                }
//            }
//            if(curr.left!=null){
//                stack.add(curr.left);
//            }else{
//                preHead = stack.pop();
//                preHead = preHead.right;
//            }
//        }
//    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        Map<Integer,TreeNode> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRootOfTree);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            map.put(temp.val,temp);
            if(temp.left!=null){
                stack.push(temp.left);
            }
            if(temp.right!=null){
                stack.push(temp.right);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(map.keySet());
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1>o2?1:-1;
            }
        });
        TreeNode preHead = new TreeNode(0);
        TreeNode head = map.get(arrayList.get(0));
        head.left = null;
        preHead.right = head;
        for(int i = 1;i<arrayList.size();i++){
            TreeNode t = map.get(arrayList.get(i));
            head.right = t;
            t.left = head;
            head = head.right;
        }
        head.right = null;
        return preHead.right;
    }

    static TreeNode head = null;
    static TreeNode prehead = null;
    public static TreeNode Convert1(TreeNode pRootOfTree) {
        convertsub(pRootOfTree);
        return prehead;
    }

    public static void convertsub(TreeNode root){
        if(root==null){
            return;
        }
        convertsub(root.left);
        if(head==null){
            head = root;
            prehead = root;
        }else{
            head.right = root;
            root.left = head;
            head = head.right;
        }
        convertsub(root.right);
    }
}
