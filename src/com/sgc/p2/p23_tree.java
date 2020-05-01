package com.sgc.p2;
//深度优先搜索
//采用非递归方法，可以写博客
import java.util.*;

public class p23_tree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(3);

        TreeNode root1 = t1;

        root1.left = t2;
        root1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;

        System.out.println(FindPath(root1, 10));
    }


    //非递归方法
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int add = 0;
        while (!stack.isEmpty()){
            if(stack.peek()==null){
                stack.pop();
                //arrayList.remove(arrayList.size()-1);
                continue;
            }else if(set.contains(stack.peek())) {
                arrayList.remove(arrayList.size()-1);
                add = add - stack.pop().val;
                continue;
            }else{
                set.add(stack.peek());
                add = add + stack.peek().val;
                arrayList.add(stack.peek().val);
            }
            if(add==target && stack.peek().left==null && stack.peek().right==null){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i = 0;i<arrayList.size();i++){
                    temp.add(arrayList.get(i));
                }
                arrayLists.add(temp);
            }else if(add>target){
                arrayList.remove(arrayList.size()-1);
                int n_temp = stack.pop().val;
                add = add - n_temp;
            }else if(add<target) {
                TreeNode temp = stack.peek();
                stack.add(temp.left);
                stack.add(temp.right);

            }
        }
        arrayLists.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.size()>o2.size()?-1:1;
            }
        });
        return arrayLists;
    }


    //非递归方法
    public static ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<>
    }


}
