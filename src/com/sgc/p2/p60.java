package com.sgc.p2;

import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.SplittableRandom;

//请实现两个函数，分别用来序列化和反序列化二叉树
//
//二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
// 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
//
//二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
//
//例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
public class p60 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        TreeNode root1 = t1;

//        root1.left = t2;
//        root1.right = t3;
//        t2.left = t4;
//        t2.right = t5;
//        t3.left = t6;
//        t3.right = t7;
//        t4.left = t8;
        root1.left = t2;
        t2.left = t3;
        t3.left = t4;
        String s= Serialize(root1);
        System.out.println();
        TreeNode temp = Deserialize(s);
    }

    public static String Serialize(TreeNode root) {
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int rowStart = 0;
        int size = 0;
        boolean end = true;
        if(root==null){
            return "";
        }
        arrayList.add(root);
        rowStart++;
        size++;
        end=false;
        StringBuffer sb = new StringBuffer();
        sb.append(root.val);
        sb.append(',');
        int i = 0;
        while (!end){
            int ntemp = rowStart;
            int sizetemp = 0;
            end = true;
            for(;i<size;i++){
                TreeNode temp = arrayList.get(i);
                if(temp.left!=null){
                    end = false;
                    arrayList.add(temp.left);
                    arrayList1.add(1);
                }else {
                    arrayList.add(new TreeNode(-1));
                    arrayList1.add(0);
                }
                if(temp.right!=null){
                    end = false;
                    arrayList.add(temp.right);
                    arrayList1.add(1);
                }else {
                    arrayList.add(new TreeNode(-1));
                    arrayList1.add(0);
                }

                sizetemp+=2;
            }
            for(int j = 0;!end && j<arrayList1.size();j++) {
                rowStart++;
                if(arrayList1.get(j)==1){
                    sb.append(arrayList.get(ntemp+j).val);
                    sb.append(",");
                }else if(j%2==0){
                    if(arrayList1.get(j+1)==1){
                        sb.append("#");
                        sb.append(",");
                    }
                }else if(j%2==1){
                    if(arrayList1.get(j-1)==1){
                        sb.append("#");
                        sb.append(",");
                    }
                }
            }
            size += sizetemp;
            arrayList2.addAll(arrayList1);
            arrayList1.clear();
        }
        return sb.toString().substring(0,sb.length()-1);
    }
    public static TreeNode Deserialize(String str) {
        if(str.length()==0){
            return null;
        }
        String [] numbers = str.split(",");
        int i = 0;
        int rowSize = 1;
        int comSize = 0;
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        arrayList.add(new TreeNode(Integer.parseInt(numbers[0])));
        i++;
        comSize++;
        rowSize*=2;
        int row = 1;
        for(;i<numbers.length;row++){
            int addNum = 0;
            for(int k = 0;k<=row-1;k++){
                addNum += Math.pow(2,k);
            }
            int newRowSize = 0;
            for(;i<numbers.length && i-comSize<rowSize;i++) {
                TreeNode temp = null;
                if (!numbers[i].equals("#")) {
                    temp = new TreeNode(Integer.parseInt(numbers[i]));
                    if ((i-comSize) % 2 == 1) {
                        arrayList.get((addNum+i-comSize-1) / 2).right = temp;
                    } else {
                        arrayList.get((addNum+i-comSize-1) / 2).left = temp;
                    }
                    arrayList.add(temp);
                    newRowSize+=2;
                } else {
                    arrayList.add(new TreeNode(-1));
                }
            }
            addNum = 0;
            for(int k = 0;k<=row;k++){
                addNum += Math.pow(2,k);
            }
            for(int k = arrayList.size();k<addNum;k++){
                arrayList.add(new TreeNode(-1));
            }
            comSize += rowSize;
            rowSize = newRowSize;
        }
        return arrayList.get(0);
    }
}
