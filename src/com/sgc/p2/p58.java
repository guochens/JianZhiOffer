package com.sgc.p2;

import java.util.ArrayList;

public class p58 {
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
        System.out.println(Print(root1));
    }


    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        if(pRoot==null){
            return arrayLists;
        }
        arrayList.add(pRoot);
        boolean lr = true;

        add(arrayList,arrayLists,lr);
        return arrayLists;
    }

    public static void add(ArrayList<TreeNode> arrayList,ArrayList<ArrayList<Integer>> arrayLists,boolean lr){
        if(arrayList.isEmpty()){
            return;
        }
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        if(lr){
            for(int i = 0;i<arrayList.size();i++){
                arrayList1.add(arrayList.get(i).val);
            }
        }else{
            for(int i = arrayList.size()-1;i>=0;i--){
                arrayList1.add(arrayList.get(i).val);
            }
        }
        arrayLists.add(arrayList1);
        int size = arrayList.size();
        for(int i = 0;i<size;i++){
            TreeNode temp = arrayList.get(i);
            if(temp.left!=null){
                arrayList.add(temp.left);
            }
            if(temp.right!=null){
                arrayList.add(temp.right);
            }
        }
        for(int i = 0;i<size;i++){
            arrayList.remove(0);
        }
        add(arrayList,arrayLists,!lr);
    }
}
